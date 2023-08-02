package org.example;

public class Emp_Departments {
    private String  id;

    private String name;

    public Emp_Departments() {
    }

    public Emp_Departments(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp_Departments{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
