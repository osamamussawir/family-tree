package com.familytree.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberDto {

    private Long id;

    private String name;

    private PersonDto father;

    private PersonDto mother;
}
