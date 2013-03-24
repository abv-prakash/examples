package com.abhinav.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class Comparators
{

    public static class Name implements Comparable<Name>
    {

        private final String firstName;
        private final String lastName;

        public Name(final String fname, final String lname)
        {
            this.firstName = fname;
            this.lastName = lname;
        }

        public String firstName()
        {
            return firstName;
        }

        public String lastName()
        {
            return lastName;
        }

        @Override
        public boolean equals(final Object o)
        {

            if (!(o instanceof Name))
            {
                return false;

            }

            Name n = (Name) o;
            return firstName.equals(n.firstName) && lastName.equals(n.lastName);

        }

        @Override
        public int hashCode()
        {

            return 31 * firstName.hashCode() + lastName.hashCode();
        }

        @Override
        public String toString()
        {
            return firstName + ":" + lastName;
        }

        public int compareTo(final Name n)
        {

            int ret = lastName.compareTo(n.lastName);
            return (ret != 0 ? ret : firstName.compareTo(n.lastName));

        }

    }

    public static class Employee implements Comparable<Employee>
    {

        public Name name;
        public int  number;
        public Date hireDate;

        public Employee(final Name name, final int number, final Date hireDate)
        {

            this.name = name;
            this.number = number;
            this.hireDate = hireDate;

        }

        public int compareTo(final Employee o)
        {
            return name.compareTo(o.name);
        }

    }

    public static void main(final String args[])
    {

        Name nameArray[] =
        { new Name("jell", "Smith"), new Name("john", "smith"), new Name("tom", "alter") };

        List<Name> nameList = Arrays.asList(nameArray);

        Collections.sort(nameList);
        System.out.println(nameList);

        Date hireDate = new Date();

        Employee[] empArray =
        { new Employee(nameArray[0], 1, hireDate), new Employee(nameArray[1], 2, hireDate) };

        List<Employee> employeeList = new ArrayList<Employee>(Arrays.asList(empArray));

        Collections.sort(employeeList, new Comparator<Employee>()
        {
            public int compare(final Employee e1, final Employee e2)
            {
                return e2.hireDate.compareTo(e1.hireDate);

            }
        });

    }

}