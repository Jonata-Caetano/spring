package com.bmarques.springrabbitcloud;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeEvent {

    private String empName;
    private String empID;

}