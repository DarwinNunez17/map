package com.laborator.FootballDatabase.Domain;

import javax.persistence.*;

@Entity
@Table(name = "awards")
public class Awards {
    @Id
    private String name;
    private int year;

    public Awards(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year){this.year = year;}
}