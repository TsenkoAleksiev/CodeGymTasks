package com.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here
        String[] input = new String[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            input[i] = args[i + 1];
        }

        String name = null;
        Sex sex = null;
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM dd yyyy");
        int index = 0;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople){
                    for (int i = 0; i < input.length - 2; i += 3) {
                        name = input[i];
                        sex = (input[i + 1].equals("m")) ? Sex.MALE : Sex.FEMALE;
                        try {
                            date = simpleDateFormat.parse(input[i + 2]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        create(name, sex, date);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople){
                    for (int i = 0; i < input.length - 3; i += 4) {
                        index = Integer.parseInt(input[i]);
                        name = input[i + 1];
                        sex = (input[i + 2].equals("m")) ? Sex.MALE : Sex.FEMALE;
                        try {
                            date = simpleDateFormat.parse(input[i + 3]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        update(index, name, sex, date);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople){
                    for (int i = 0; i < input.length; i++) {
                        delete(Integer.parseInt(input[i]));
                    }
                }
                break;
            case "-i":
                synchronized (allPeople){
                    for(String str : input){
                        index = Integer.parseInt(str);
                        info(allPeople.get(index));
                    }
                }
                break;
        }
    }

    //-c name1 sex1 bd1 name2 sex2 bd2 ...
    //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
    //-d id1 id2 id3 id4 ...
    //-i id1 id2 id3 id4 ...

    public static void create(String name, Sex sex, Date birthDate) {
        if (sex.equals(Sex.MALE)) allPeople.add(Person.createMale(name, birthDate));
        else allPeople.add(Person.createFemale(name, birthDate));
        System.out.println(allPeople.size() - 1);
    }

    public static void update(int index, String name, Sex sex, Date birthDate) {
        Person tempPerson = allPeople.get(index);
        tempPerson.setName(name);
        tempPerson.setSex(sex);
        tempPerson.setBirthDate(birthDate);
    }

    public static void delete(int index) {
        update(index, null, null, null);
    }

    public static void info(Person person) {
        StringBuilder sb = new StringBuilder();
        String sex = "";
        if(person.getSex() != null) {
            sex = (person.getSex().equals(Sex.MALE)) ? "m" : "f";
        }
        String date = "";
        if(person.getBirthDate() != null){
            date = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH).format(person.getBirthDate());
        }
        sb.append(person.getName())
                .append(" ")
                .append(sex)
                .append(" ")
                .append(date);
        System.out.println(sb.toString());
    }
}
