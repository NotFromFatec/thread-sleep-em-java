package controller;

public class WorkerThread extends Thread {
    private final int threadId;

    public WorkerThread(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        int remainder = threadId % 3;

        switch (remainder) {
            case 1:
                for (int i = 0; i < 2; i++) {
                    work(200, 1000, 1000);
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    work(500, 1500, 1500);
                }
                break;
            case 0:
                for (int i = 0; i < 3; i++) {
                    work(1000, 2000, 1500);
                }
                break;
        }

        System.out.println("Thread " + threadId + ": Finalizou...");
    }

    private void work(int minCalc, int maxCalc, int db) {
        System.out.println("Thread " + threadId + ": Realizando cálculos...");
        sleepRandomTime(minCalc, maxCalc);
        System.out.println("Thread " + threadId + ": Transação de BD...");
        sleepTime(db);
    }

    private void sleepRandomTime(int minMillis, int maxMillis) {
        try {
            Thread.sleep((long) (minMillis + Math.random() * (maxMillis - minMillis)));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void sleepTime(int millis) {
        try {
            Thread.sleep((long) millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
