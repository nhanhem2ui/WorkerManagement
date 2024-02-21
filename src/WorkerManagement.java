import Controller.Handler;
import Model.WorkerList;
import View.Menu;

public class WorkerManagement {

    private Handler handler;
    private WorkerList list;

    public WorkerManagement() {
        handler = new Handler();
        list = new WorkerList();
    }

    public void displayMainMenu() {
        Menu<String> mainMenu = new Menu<>("Worker management", new String[]{
            "Add Worker",
            "Up salary",
            "Down salary",
            "Display Information salary",
            "Exit"
        }) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 ->
                        handler.addWorker(list);
                    case 2 ->
                        handler.upSalary(list);
                    case 3 ->
                        handler.downSalary(list);
                    case 4 ->
                        handler.displayHistory(list);
                    case 5 ->
                        System.exit(0);
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        mainMenu.run();
    }

    public static void main(String[] args) {
        WorkerManagement main = new WorkerManagement();
        main.displayMainMenu();
    }
}
