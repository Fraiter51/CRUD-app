package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private final ArrayList<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Jack"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int index){
        return people.stream().filter(person -> person.getId()==index).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person person){
        Person personToBeUpdated =show(id);
        personToBeUpdated.setName(person.getName());
    }
    public void delete(int id){
        people.removeIf(p-> p.getId() == id);
    }

}

