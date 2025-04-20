package net.itinajero.jobOffers.model;
import java.util.Date;
//Model Class for SpringBoot
public class Vacancy {

    private Integer id;
    private String name;
    private String description;
    private Date date;
    private double salary;
    private Integer excels;
    private String image="noImage.png";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getExcels() {
        return excels;
    }

    public void setExcels(Integer excels) {
        this.excels = excels;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //Override because inherits from object class, and this class already has the toString method
    //

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", salary=" + salary +
                ", excels=" + excels +
                ", image='" + image + '\'' +
                '}';
    }
}
