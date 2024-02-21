package Model;

import java.util.ArrayList;

public class WorkerList {

    private ArrayList<Worker> workerList;
    private ArrayList<History> history;

    public WorkerList() {
        workerList = new ArrayList<>();
        history = new ArrayList<>();
        initialData();
    }

    public ArrayList<Worker> getList() {
        return workerList;
    }

    public ArrayList<History> getHistory() {
        return history;
    }

    public void addWorker(Worker worker) {
        workerList.add(worker);
    }

    public Worker getWorkerByCode(int id) {
        for (Worker worker : workerList) {
            if (worker.getId() == id) {
                return worker;
            }
        }
        return null;
    }

    public boolean isNotDuplicate(int id) {
        return getWorkerByCode(id) != null;
    }

    private void initialData() {
        Worker tuBan1 = new Worker(1, "Bao", 19, 2000, "Runntera");
        Worker tuBan2 = new Worker(2, "Zy", 20, 2000, "Demacia");
        workerList.add(tuBan1);
        workerList.add(tuBan2);
        History h1 = new History(1, "Bao", 19, 1000, true, "12/02/2012");
        history.add(h1);
    }

}
