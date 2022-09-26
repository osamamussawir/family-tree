package com.familytree.service;

import com.familytree.dto.AddMemberDto;
import com.familytree.dto.PersonDto;

import java.util.List;

public interface FamilyService {

    PersonDto savePerson(AddMemberDto person);

    List<PersonDto> listAllParents(Long id);

    List<PersonDto> listAllChildrens(Long id);

    List<PersonDto> listAllDescendants(Long id);

    List<PersonDto> listAllAncestors(Long id);
}
