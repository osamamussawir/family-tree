package com.familytree.repository;

import com.familytree.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Person, Long> {

    Person[] findByMother(Person mother);
}
