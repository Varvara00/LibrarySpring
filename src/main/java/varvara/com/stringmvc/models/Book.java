package varvara.com.stringmvc.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = " director should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String director;

    @Min(value = 1900, message = "Year of production should be greater than 1900")
    private int yearOfProduction;


    public Book() {

    }

    public Book(int id, String name, String director, int yearOfProduction) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.yearOfProduction = yearOfProduction;


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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

}


