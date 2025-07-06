package com.cognizant.orm_learn.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @Column(name = "sk_id")
    private int id;

    @Column(name = "sk_name")
    private String name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;

    public Skill(){}

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Set<Employee> getEmployeeList() { 
        return employeeList; 
    }
    public void setEmployeeList(Set<Employee> employeeList) { 
        this.employeeList = employeeList; 
    }
    @Override
    public String toString() {
        return "Skill{" + "id=" + id + ", name='" + name + "'}";
    }
}
