package com.student.Controller;

import com.netflix.discovery.converters.Auto;

import com.student.Repository.StudentRepository;
import com.student.Request.AddStudentRequest;
import com.student.Response.AddStudentResponse;
import com.student.Response.MessageResponse;
import com.student.Service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Api(tags = "Student Details")
@RestController
@RequestMapping(path = "/student/api")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @ApiOperation(
            value = "Add a Student to the application.",
            authorizations = {@Authorization(value = AUTHORIZATION)}
    )
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Student Added Succesfully."
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
    @PostMapping(value = "/addStudent", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addStudent(
            @RequestBody AddStudentRequest addStudentRequest){
        if(studentRepository.findByStudentMail(addStudentRequest.getStudentMail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error : Email is already in use."));
        }
        Optional<AddStudentResponse> addStudentResponse = studentService.addStudent(addStudentRequest);
        if(addStudentResponse.isPresent()){
            return ResponseEntity
                    .of(addStudentResponse)
                    .ok(new MessageResponse("Student added succesfully"));
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Unknown Error Occur"));
        }
    }



}