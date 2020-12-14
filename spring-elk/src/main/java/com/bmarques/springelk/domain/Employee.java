package com.bmarques.springelk.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "employee")
public class Employee {

  @Id
  private String id;
  @Field(type = FieldType.Object)
  private Organization organization;
  @Field(type = FieldType.Object)
  private Department department;
  private String name;
  private int age;
  private String position;
}