package com.bmarques.springrabbitcloud.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeEvent {

    private String empName;
    private String empID;

}