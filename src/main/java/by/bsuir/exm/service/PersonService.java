package by.bsuir.exm.service;

import by.bsuir.exm.entity.Person;

import java.util.List;

public interface PersonService {
    boolean addPerson(Person person);
    boolean updatePerson(Person person);
    boolean deletePerson(int id);
    List<Person> showPeople();
    Person findPersonById(int id);
}
