package by.bsuir.exm.service.impl;

import by.bsuir.exm.dao.PersonDao;
import by.bsuir.exm.dao.impl.PersonDaoImpl;
import by.bsuir.exm.entity.Person;
import by.bsuir.exm.service.PersonService;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateError;

import java.util.List;

@NoArgsConstructor
public class PersonServiceImpl implements PersonService {
    PersonDao personDao = new PersonDaoImpl();

    @Override
    public boolean addPerson(Person person) {
        boolean isAdded = false;
        try {
            if (personDao.addPerson(person))
                isAdded = true;
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updatePerson(Person person) {
        boolean isUpdated = false;
        try {
            if (personDao.updatePerson(person))
                isUpdated = true;
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deletePerson(int id) {
        boolean isDeleted = false;
        try {
            if (personDao.deletePerson(id))
                isDeleted = true;
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public List<Person> showPeople() {
        List<Person> people = null;
        try {
            people = personDao.showPeople();
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    @Override
    public Person findPersonById(int id) {
        Person person = null;
        try {
            person = personDao.findPersonById(id);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}