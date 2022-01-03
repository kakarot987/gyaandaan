package com.student.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "Api response message for Student registration.")
public class AddStudentResponse {

    @ApiModelProperty(
            value = "The primary identifier of the student.",
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

    public AddStudentResponse(Long volunteerId, Date registrationDate) {
        this.volunteerId = volunteerId;
        this.registrationDate = registrationDate;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

