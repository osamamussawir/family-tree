package com.familytree.controller;

import com.familytree.dto.AddMemberDto;
import com.familytree.dto.PersonDto;
import com.familytree.service.FamilyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("/person")
    public PersonDto savePerson(@RequestBody AddMemberDto personDto) {
        return familyService.savePerson(personDto);
    }

    @GetMapping("/person/{id}/parents")
    public List<PersonDto> listAllParents(@PathVariable("id") Long id) {
       return familyService.listAllParents(id);
    }

    @GetMapping("/person/{id}/childrens")
    public List<PersonDto> listAllChildrens(@PathVariable("id") Long id) {
       return familyService.listAllChildrens(id);
    }

    @GetMapping("/person/{id}/descendants")
    public List<PersonDto> listAllDescendants(@PathVariable("id") Long id) {
        return familyService.listAllDescendants(id);
    }

    @GetMapping("/person/{id}/ancestors")
    public List<PersonDto> listAllAncestors(@PathVariable("id") Long id) {
        return familyService.listAllAncestors(id);
    }

}
