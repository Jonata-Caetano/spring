package com.bmarques.springamazonlambda.functions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Contact {

    private Integer id;
    private String name;
    private String address;
}
