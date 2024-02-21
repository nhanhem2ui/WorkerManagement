package Controller;

import Model.History;
import Model.Worker;
import Model.WorkerList;
import java.util.Scanner;

public class Handler {

    private Scanner sc;

    public Handler() {
        sc = new Scanner(System.in);
    }

    public void addWorker(WorkerList list) {
        System.out.println("Enter Code:");
        int id = sc.nextInt();
        if (list.isNotDuplicate(id)) {
            System.out.println("Code already exist.");
            addWorker(list);
        }
        System.out.println("Enter Name: ");
        String name = sc.next();
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        if (!(age >= 18 && age <= 100)) {
            System.out.println("Invalid age.");
            addWorker(list);
        }
        System.out.println("Enter Salary: ");
        int salary = sc.nextInt();
        if (salary < 0) {
            System.out.println("Salary must not be negative");
            addWorker(list);
        }
        System.out.println("Enter work location: ");
        String location = sc.next();
        Worker worker = new Worker(age, name, age, salary, location);
        list.addWorker(worker);
    }

    public void upSalary(WorkerList list) {
        System.out.println("Enter Code: ");
        int id = sc.nextInt();
        if (list.isNotDuplicate(id)) {
            System.out.println("Enter Salary: ");
            int salary = sc.nextInt();
            Worker worker = list.getWorkerByCode(id);
            worker.setSalary(worker.getSalary() + salary);
            System.out.println("Enter Date: ");
            String date = sc.next();
            History newHistory = new History(id, worker.getName(), worker.getAge(), worker.getSalary(), true, date);
            list.getHistory().add(newHistory);
        } else {
            System.out.println("Code not exist.");
        }
    }

    public void downSalary(WorkerList list) {
        System.out.println("Enter Code: ");
        int id = sc.nextInt();
        if (list.isNotDuplicate(id)) {
            System.out.println("Enter Salary to deduct: ");
            int deduction = sc.nextInt();
            Worker worker = list.getWorkerByCode(id);
            int newSalary = worker.getSalary() - deduction;
            if (newSalary >= 0) {
                worker.setSalary(newSalary);
                System.out.println("Salary updated successfully.");
                System.out.println("Enter Date: ");
                String date = sc.next();
                History newHistory = new History(id, worker.getName(), worker.getAge(), worker.getSalary(), false, date);
                list.getHistory().add(newHistory);
            } else {
                System.out.println("Deduction amount exceeds current salary. Please enter a valid deduction amount.");
                downSalary(list);
            }
        } else {
            System.out.println("Code not exist.");
        }
    }

    public void displayHistory(WorkerList list) {
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.println("Code \tName \tAge \tSalary \t\tStatus \t\tDate");
        for (History history : list.getHistory()) {
            System.out.println(history.toString());
        }
    }
}
