package com.familytree.controller;

import com.familytree.dto.AddMemberDto;
import com.familytree.dto.PersonDto;
import com.familytree.service.FamilyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("/person")
    public PersonDto savePerson(@RequestBody AddMemberDto personDto) {
        log.info("FamilyController::savePerson started for id: " + personDto.getId());
        return familyService.savePerson(personDto);
    }

    @GetMapping("/person/{id}/parents")
    public List<PersonDto> listAllParents(@PathVariable("id") Long id) {
        log.info("FamilyController::listAllParents started for id: " + id);
       return familyService.listAllParents(id);
    }

    @GetMapping("/person/{id}/childrens")
    public List<PersonDto> listAllChildrens(@PathVariable("id") Long id) {
        log.info("FamilyController::listAllChildrens started for id: " + id);
       return familyService.listAllChildrens(id);
    }

    @GetMapping("/person/{id}/descendants")
    public List<PersonDto> listAllDescendants(@PathVariable("id") Long id) {
        log.info("FamilyController::listAllDescendants started for id: " + id);
        return familyService.listAllDescendants(id);
    }

    @GetMapping("/person/{id}/ancestors")
    public List<PersonDto> listAllAncestors(@PathVariable("id") Long id) {
        log.info("FamilyController::listAllAncestors started for id: " + id);
        return familyService.listAllAncestors(id);
    }

}
