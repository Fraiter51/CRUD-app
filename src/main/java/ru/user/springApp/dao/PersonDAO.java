package ru.user.springApp.dao;

import org.springframework.stereotype.Component;
import ru.user.springApp.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private final ArrayList<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom",24,"tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jack", 52 , "Jack@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",18,"bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",34,"Mike@gmail.com"));
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
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());

    }
    public void delete(int id){
        people.removeIf(p-> p.getId() == id);
    }

}

