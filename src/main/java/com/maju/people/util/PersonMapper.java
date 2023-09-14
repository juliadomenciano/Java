package com.maju.people.util;

import com.maju.people.dto.request.PersonRequestDTO;
import com.maju.people.dto.response.PersonResponseDTO;
import com.maju.people.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public Person toPerson (PersonRequestDTO PersonDTO) {
        return Person.builder()
                .name(PersonDTO.getName())
                .cpf(PersonDTO.getCpf())
                .age(PersonDTO.getAge())
                .build();
    }

    public PersonResponseDTO toPersonDTO(Person person) {
        return new PersonResponseDTO(person);
    }

    public List<PersonResponseDTO> toPeopleDTO(List<Person> peopleList) {
        return peopleList.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePersonData(Person person, PersonRequestDTO personDTO) {

        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setAge(personDTO.getAge());
    }

}
