package by.bsuir.exm.dao.impl;

import by.bsuir.exm.dao.PersonDao;
import by.bsuir.exm.entity.Person;
import by.bsuir.exm.sessionFactory.SessionFactoryImpl;
import by.bsuir.exm.utils.SessionUtils;

import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public boolean addPerson(Person person) {
        return SessionUtils.saveEntity(person);
    }

    @Override
    public boolean updatePerson(Person person) {
        return SessionUtils.updateEntity(person);
    }

    @Override
    public boolean deletePerson(int id) {
        return SessionUtils.deleteEntity(id, Person.class);
    }

    @Override
    public List<Person> showPeople() {
        return (List<Person>) SessionFactoryImpl.getSessionFactory()
                .openSession()
                .createQuery("FROM Person")
                .list();
    }

    @Override
    public Person findPersonById(int id) {
        return SessionUtils.find(Person.class, id, "personId");
    }
}
