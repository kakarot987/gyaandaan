package com.teacher.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "Api response message for volunteer registration.")
public class AddVolunteerResponse {

    @ApiModelProperty(
            value = "The primary identifier of the volunteer.",
            required = true,
            accessMode = ApiModelProperty.AccessMode.READ_ONLY,
            example = "eefb648a-75d0-410b-8a98-6a26c1629cbe",
            position = 1
    )
    private Long volunteerId;

    @ApiModelProperty(
            value = "Registration Date",
            required = true,
            accessMode = ApiModelProperty.AccessMode.READ_ONLY,
            example = "23/12/2021",
            position = 2
    )
    private Date registrationDate;

    public AddVolunteerResponse(Long volunteerId, Date registrationDate) {
        this.volunteerId = volunteerId;
        this.registrationDate = registrationDate;
    }
}
