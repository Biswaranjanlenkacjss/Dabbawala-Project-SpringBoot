package org.example;

public class Emp_Location {

    private String location;

    private String country;

    public Emp_Location() {
    }

    public Emp_Location(String location, String country) {
        this.location = location;
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Emp_Location{" +
                "location='" + location + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
