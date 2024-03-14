package view;

import controller.WorkerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(21);

        for (int i = 1; i <= 21; i++) {
            Thread worker = new WorkerThread(i);
            executor.execute(worker);
        }

        executor.shutdown();
    }
}
