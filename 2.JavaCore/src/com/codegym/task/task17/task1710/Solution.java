package com.codegym.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here
        crud(args);
    }

    public static void crud(String[] input){
        String command = input[0];
        String name = "";
        String sex = "";
        Date date = null;

        int index = 0;

        if(command.equals("-c") || command.equals("-u")){
            if(!command.equals("-u")){
                sex = input[2];
                name = input[1];
            }else{
                sex = input[3];
                name = input[2];
            }

            try {
                date = new SimpleDateFormat("MM dd yyyy").parse(input[input.length - 1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        if(command.equals("-u") || command.equals("-d") || command.equals("-i")) {
            index = Integer.parseInt(input[1]);
        }

        switch (command){
            case "-c":
                create(name, sex, date);
                break;
            case "-u":
                update(index, name, sex, date);
                break;
            case "-d":
                Person person = allPeople.get(index);
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;
            case "-i":
                printPerson(allPeople.get(index));
                break;
            default:
                System.out.println("Wrong command!");
        }
    }

    public static void create(String inName, String sex, Date date){
        if(sex.equals("m")) allPeople.add(Person.createMale(inName, date));
        if(sex.equals("f")) allPeople.add(Person.createFemale(inName, date));
        System.out.println(allPeople.size() - 1);
    }

    public static void update(int index, String name, String sex, Date date){
        allPeople.get(index).setName(name);
        allPeople.get(index).setSex((sex.equals("m")) ? Sex.MALE : Sex.FEMALE);
        allPeople.get(index).setBirthDate(date);
    }

    public static void printPerson(Person person){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        String dateStr = simpleDateFormat.format(person.getBirthDate());
        String sex = (person.getSex() == Sex.MALE) ? "m" : "f";
        sb
                .append(person.getName())
                .append(" ")
                .append(sex)
                .append(" ")
                .append(dateStr);
        System.out.println(sb.toString());
    }
}
