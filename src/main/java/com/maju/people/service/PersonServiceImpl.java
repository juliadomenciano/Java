package com.maju.people.service;

import com.maju.people.dto.request.PersonRequestDTO;
import com.maju.people.dto.response.PersonResponseDTO;
import com.maju.people.entity.Person;
import com.maju.people.repository.PersonRepository;
import com.maju.people.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {

        return personMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO, Long id) {
        Person person = returnPerson(id);


    }

    @Override
    public String delete(Long id) {
        return null;
    }

    private Person returnPerson(Long id) {
       return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person wasn't found on database"));
    }
}
