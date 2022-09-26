package com.familytree.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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
