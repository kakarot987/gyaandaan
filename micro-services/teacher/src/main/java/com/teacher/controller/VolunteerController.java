package com.teacher.controller;

import com.teacher.Entity.Volunteer;
import com.teacher.Request.AddVolunteerRequest;
import com.teacher.Response.AddVolunteerResponse;
import com.teacher.Response.MessageResponse;
import com.teacher.Service.VolunteerService;
import com.teacher.repository.VolunteerRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Api(tags = "Volunteer Details")
@RestController
@RequestMapping("/volunteer/api/")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @ApiOperation(
            value = "Add a valunteer to an application.",
            authorizations = {@Authorization(value = AUTHORIZATION)}
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Volunteer Added Succesfully."
            ),
            @ApiResponse(
                    code = 400,
                    message = "Bad request"
            ),
            @ApiResponse(
                    code = 401,
                    message = "You did not supply valid credentials"
            ),
            @ApiResponse(
                    code = 403,
                    message = "The requesting credentials don't provide access to this resource or operation."
            ),
            @ApiResponse(
                    code = 500,
                    message =  "The service couldn't perform the request"
            )
    })
    @PostMapping(value = "/addVolunteer", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addVolunteerResponse(
            @RequestBody AddVolunteerRequest addVolunteerRequest){
        if(volunteerRepository.findByVolunteerMail(addVolunteerRequest.getVolunteerMail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error : Email is already in use."));
        }
        Optional<AddVolunteerResponse> addVolunteerResponse = volunteerService.addVolunteer(addVolunteerRequest);
        if(addVolunteerResponse.isPresent()){
            return ResponseEntity
                    .of(addVolunteerResponse)
                    .ok(new MessageResponse("Volunteer added succesfully"));
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Unknown Error Occur"));
        }
    }


}
