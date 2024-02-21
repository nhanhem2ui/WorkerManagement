package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class History {
    
    private int id;
    private String name;
    private int age;
    private int salary;
    private boolean status;
    private LocalDate date;
    
    public History(int id, String name, int age, int salary, boolean status, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = convertStringToDate(date);
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getSalary() {
        return salary;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = convertStringToDate(date);
    }
    
    protected final LocalDate convertStringToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }
    
    @Override
    public String toString() {
        return String.format("W %-4d %-8s %-8d %-14d %-12s %-10s",
                id, name, age, salary, (status ? "UP" : "DOWN"), date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
