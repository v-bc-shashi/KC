package com.shashi.java8.list;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class SampleEmployess {

    List<Employee> getALLEmployees(){
        List employeeList = new LinkedList<Employee>();

        Employee emp1= new Employee("Nathan Hong","E02061","Director","Finance", "Corporate", "Male", "Asian", 50,
                                   LocalDate.of(2019,10,2), 150631, "United States","Phoenix");
        employeeList.add(emp1);

       Employee emp2= new Employee("Chloe Kim","E02062","Sr. Analyst","Sales", "Specialty Products", "Female", "Asian", 39,
                LocalDate.of(2012,7,6), 72850, "United States","Miami");
        employeeList.add(emp2);

        Employee emp3= new Employee("Isaac Guzman","E02063","Account Representative","Sales", "Corporate", "Male", "Asian", 39,
                LocalDate.of(2010,8,18), 97951, "United States","Phoenix");
        employeeList.add(emp3);


        Employee emp4= new Employee("Cameron Lo","E02004","Network Administrator","IT", "Research & Development", "Male", "Asian", 39,
                LocalDate.of(2019,3,24), 83951, "China","Shanghai");
        employeeList.add(emp4);



        Employee emp5= new Employee("Harper Castillo","E02005","Systems Architect","IT", "Corporate", "Female", "Latino", 39,
                LocalDate.of(2018,4,7), 98062, "United States","Seattle");
        employeeList.add(emp5);


        Employee emp6= new Employee("Harper Dominguez","E02006","Director","Engineering", "Corporate", "Female", "Latino", 42,
                LocalDate.of(2005,06,18), 175391, "United States","Austin");
        employeeList.add(emp6);


        Employee emp7= new Employee("Ezra Vu","E02007","Administrator","IT Manufacturing", "Corporate", "Male", "Asian", 62,
                LocalDate.of(2004,04,22), 175391, "United States","Phoenix");
        employeeList.add(emp7);


        Employee emp8= new Employee("Jade Hu Sr","E02008","Analyst","Accounting", "Specialty Products", "Female", "Asian", 58,
                LocalDate.of(2009,06,27), 89744, "China","Chongqing");
        employeeList.add(emp8);


        Employee emp9= new Employee("Jade Hu Sr","E02008","Analyst","Accounting", "Specialty Products", "Female", "Asian", 58,
                LocalDate.of(2009,06,27), 89744, "China","Chongqing");
        employeeList.add(emp9);


        Employee emp10= new Employee("Gianna Holmes","E02010","System Administrator","Manufacturing", "Manufacturing", "Female", "Caucasian", 38,
                LocalDate.of(2011,9,27), 97630, "United States","Seattle");
        employeeList.add(emp10);


        Employee emp11= new Employee("Jameson Thomas","E02011","Manager","Finance", "Specialty Products", "Male", "Caucasian", 52,
                LocalDate.of(2015,05,2), 105879, "United States","Phoenix");
        employeeList.add(emp11);


        Employee emp12= new Employee("Jameson Pena","E02012","Systems Analyst","IT", "Manufacturing", "Male", "Latino", 49,
                LocalDate.of(2003,10,12), 40499, "United States","Miami");
        employeeList.add(emp12);


        Employee emp13= new Employee("Bella Wu","E02013","Sr. Analyst","Finance", "Specialty Products", "Female", "Asian", 63,
                LocalDate.of(2014,8,03), 71418, "United States","Phoenix");
        employeeList.add(emp13);


        Employee emp14= new Employee("Jose Wong","E02014","Network Administrator","IT", "Manufacturing", "Male", "Asian", 45,
                LocalDate.of(2017,11,15), 150558, "China","Chongqing");
        employeeList.add(emp14);


        Employee emp15= new Employee("Lucas Richardson","E02015","Manager","Marketing", "Corporate", "Female", "Caucasian", 39,
                LocalDate.of(2018,07,22), 18912, "United States","Miami");
        employeeList.add(emp15);


        Employee emp16= new Employee("Jacob Moore","E02016","Sr. Manager","Marketing", "Corporate", "Female", "Black", 42,
                LocalDate.of(2021,06,18), 131422, "United States","Phoenix");
        employeeList.add(emp16);


        Employee emp17= new Employee("Luna Lu","E02017"," Systems Architect","IT", "Corporate", "Female", "Asian", 62,
                LocalDate.of(1997,04,26), 64208, "United States","Miami");
        employeeList.add(emp17);


        Employee emp18= new Employee("Bella Tran","E02018","Vice President","Engineering", "Specialty Products", "Female", "Asian", 58,
                LocalDate.of(2010,8,27), 89744, "China","Chengdu");
        employeeList.add(emp18);


        Employee emp19= new Employee("Ivy Chau","E02019","Analyst","Sales", "Specialty Products", "Female", "Asian", 61,
                LocalDate.of(2019,06,27), 54811, "China","Chongqing");
        employeeList.add(emp19);


        Employee emp20= new Employee("Jordan Kumar","E02020","Service Desk","Analyst", "Specialty Products", "Female", "Caucasian", 38,
                LocalDate.of(2017,11,29), 95729, "United States","Seattle");
        employeeList.add(emp20);



        Employee emp21= new Employee("Sophia Gutierrez","E02021","Manager","Accounting", "Specialty Products", "Female", "Latino", 63,
                LocalDate.of(2009,8,29), 102649, "United States","Austin");
        employeeList.add(emp21);

        Employee emp22= new Employee("Eli Dang","E02022","Sr. Manager","Accounting", "Specialty Products", "Male", "Caucasian", 38,
                LocalDate.of(2017,11,29), 95729, "United States","Chicago");
        employeeList.add(emp22);


        Employee emp23= new Employee("Lillian Lewis","E02023","Technical Architect","IT", "Research & Development", "Female", "Black", 43,
                LocalDate.of(2013,11,29), 83323, "United States","Phoenix");
        employeeList.add(emp23);


        Employee emp24= new Employee("Serenity Cao","E02024","Account","Sales", "Manufacturing", "Female", "Asian", 38,
                LocalDate.of(2018,11,21), 95729, "China","Shanghai");
        employeeList.add(emp24);


        Employee emp25= new Employee("Parker Lai","E02025","Vice President","Accounting", "Specialty Products", "Male", "Asian", 48,
                LocalDate.of(2006,11,29), 95729, "China","Chongqing");
        employeeList.add(emp25);



        Employee emp26= new Employee("Charles Simmons","E02026","Manager","Sales", "Specialty Products", "Male", "Caucasian", 48,
                LocalDate.of(1997,11,27), 95729, "China","Chongqing");
        employeeList.add(emp26);


        Employee emp27= new Employee("Jayden Luu","E02027","Director","Manufacturing", "Accounting", "Female", "Asian", 64,
                LocalDate.of(2004,11,29), 95729, "China","Beijing");
        employeeList.add(emp27);


        Employee emp28= new Employee("Brooks Richardson","E02028","Analyst","Marketing", "Specialty Products", "Female", "Caucasian", 58,
                LocalDate.of(2020,11,24), 51341 , "United States","Seattle");
        employeeList.add(emp28);


        Employee emp29= new Employee("Ivy Thompson","E02029","Manager","Marketing", "Manufacturing", "Female", "Caucasian", 38,
                LocalDate.of(2017,11,29), 95729, "United States","Seattle");
        employeeList.add(emp29);


        Employee emp30= new Employee("Peyton Wright","E02030","Sr. Manager","Marketing", "Corporate", "Female", "Caucasian", 41,
                LocalDate.of(2017,11,29), 153370, "United States","Chicago");
        employeeList.add(emp30);

        return  employeeList;
    }


}
