package com.example.hrbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class RegisterForm {
    @Column(columnDefinition ="varchar(20) unique not null")
    private String username;
    @Column(columnDefinition ="varchar(255) not null")
    private String password;
    @Pattern(regexp ="(HR|customer)")
    private String role;
    private String FullName;
    @Column(columnDefinition ="varchar(10) unique not null")
    private String phoneNumber;
    private String email;
    private String major;
    private String goal;
    private String category;
    private String summary;
    private Integer yearsOfExperience;


}
