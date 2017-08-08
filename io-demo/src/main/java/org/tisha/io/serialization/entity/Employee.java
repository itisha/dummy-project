package org.tisha.io.serialization.entity;

import java.io.Serializable;

/**
 * @author Tsikhan Kuprevich
 * @since 8/8/2017
 */
public class Employee implements Serializable {

    int id;
    String name;
    double salary;
    transient int ssn;

    public Employee(int id, String name, double salary, int ssn) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", ssn=" + ssn +
                '}';
    }
}

