package com.familytree.controller;

import com.familytree.dto.PersonDto;
import com.familytree.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyController {

    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/person")
    public void savePerson(@RequestBody Person person) {

    }

    @GetMapping("/person/{id}/parents")
    public List<PersonDto> listAllParents(@PathVariable("id") Long id) {
      return null;
    }

    @GetMapping("/person/{id}/childrens")
    public List<PersonDto> listAllChildrens(@PathVariable("id") Long id) {
       return null;
    }

    @GetMapping("/person/{id}/descendants")
    public List<PersonDto> listAllDescendants(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("/person/{id}/ancestors")
    public List<PersonDto> listAllAncestors(@PathVariable("id") Long id) {
        return null;
    }

}
