package view;

import controller.Prato;

public class Main {

    public static void main(String[] args) {
        Prato[] pratos = new Prato[5];

        for (int i = 0; i < 5; i++) {
            pratos[i] = new Prato(i + 1);
            pratos[i].start();
        }

        for (Prato prato : pratos) {
            try {
                prato.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Todos os pratos foram cozidos e entregues!");
    }
}
