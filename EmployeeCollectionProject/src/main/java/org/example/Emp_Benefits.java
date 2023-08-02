package org.example;

public class Emp_Benefits {
    private  String  benefitId ;

    private String Name;

    private String Description;

    public Emp_Benefits() {
    }

    public Emp_Benefits(String benefitId, String name, String description) {
        this.benefitId = benefitId;
        Name = name;
        Description = description;
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Emp_Benefits{" +
                "benefitId='" + benefitId + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }

}
