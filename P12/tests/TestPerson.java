package tests;

import store.Person;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("Waseem", "(123)456-7890");

        System.out.println(person);
    }
}
