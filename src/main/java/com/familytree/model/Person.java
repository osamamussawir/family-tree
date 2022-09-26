package com.familytree.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @Id
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private Person father;

    @OneToOne(fetch = FetchType.EAGER)
    private Person mother;

    @OneToMany(mappedBy = "father" , fetch = FetchType.LAZY)
    private List<Person> childrens;

}
