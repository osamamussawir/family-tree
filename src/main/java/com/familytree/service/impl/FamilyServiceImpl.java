package com.familytree.service.impl;

import com.familytree.dto.AddMemberDto;
import com.familytree.dto.PersonDto;
import com.familytree.exception.MemberNotFoundException;
import com.familytree.model.Person;
import com.familytree.repository.FamilyRepository;
import com.familytree.service.FamilyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepository familyRepository;

    private final ObjectMapper objectMapper;

    @Override
    public PersonDto savePerson(AddMemberDto personDto) {
        Person person = objectMapper.convertValue(personDto, Person.class);
        person = familyRepository.save(person);
        return objectMapper.convertValue(person, PersonDto.class);
    }

    @Override
    public List<PersonDto> listAllParents(Long id) {
        Person person = fetchPersonById(id);
        PersonDto mother = objectMapper.convertValue(person.getMother(), PersonDto.class);
        PersonDto father = objectMapper.convertValue(person.getFather(), PersonDto.class);
        return Arrays.asList(mother, father);
    }

    @Override
    public List<PersonDto> listAllChildrens(Long id) {
        Person person = fetchPersonById(id);
        Person[] childrens;
        if(person.getChildrens().isEmpty()) {
            childrens = familyRepository.findByMother(person);
        } else {
            childrens = person.getChildrens().toArray(new Person[0]);
        }
       return Arrays.stream(childrens)
                .map(member -> objectMapper.convertValue(member, PersonDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> listAllDescendants(Long id) {
        Person person = fetchPersonById(id);
        List<Person> childrens;

        if(person.getChildrens().isEmpty()) {
            childrens = Arrays.asList(familyRepository.findByMother(person));
        } else {
            childrens = person.getChildrens();
        }

        List<Person> descendants = getdescendants(childrens, new ArrayList<>());

        return descendants.stream()
               .map(member -> objectMapper.convertValue(member, PersonDto.class))
               .collect(Collectors.toList());

    }

    @Override
    public List<PersonDto> listAllAncestors(Long id) {
        Person person = fetchPersonById(id);
        List<Person> ancestors = getAncestors(person, new ArrayList<>());
        return ancestors.stream()
                .map(member -> objectMapper.convertValue(member, PersonDto.class))
                .collect(Collectors.toList());
    }

    private Person fetchPersonById(Long id) {
        return familyRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Member not found against id"));
    }

    private List<Person> getdescendants(List<Person> childrens, List<Person> descendants) {

        if(childrens == null) {
            return descendants;
        }
        descendants.addAll(childrens);
        childrens.forEach(child -> getdescendants(child.getChildrens(), descendants));
        return descendants;
    }

    private List<Person> getAncestors(Person person, List<Person> ancestors) {

        if(person.getFather() == null && person.getMother() == null) {
            return ancestors;
        }
        ancestors.add(person.getFather());
        ancestors.add(person.getMother());
        getAncestors(person.getFather(), ancestors);
        getAncestors(person.getMother(), ancestors);
        return ancestors;
    }

}
