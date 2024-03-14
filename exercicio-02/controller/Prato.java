package controller;

import java.util.concurrent.TimeUnit;

public class Prato extends Thread {
    private final int pratoId;
    private static final double tempoDeEntrega = 0.5;

    public Prato(int pratoId) {
        this.pratoId = pratoId;
    }

    @Override
    public void run() {
        String nomePrato = (pratoId % 2 == 0) ? "Lasanha a Bolonhesa" : "Sopa de Cebola";
        double tempoMinimo = (pratoId % 2 == 0) ? 0.6 : 0.5;
        double tempoMaximo = (pratoId % 2 == 0) ? 1.2 : 0.8;

        double tempoCozimento = tempoMinimo + Math.random() * (tempoMaximo - tempoMinimo);

        System.out.println(pratoId + ": Iniciando cozimento do " + nomePrato + " (ID " + pratoId + ")...");
        System.out.println(pratoId + ": Tempo de cozimento do estimado: " + tempoCozimento + " segundos");

        for (double t = 0; t <= tempoCozimento; t += 0.1) {
            double percentual = (t / tempoCozimento) * 100;
            System.out.println(pratoId + ": Progresso do " + nomePrato + ": " + percentual + "%");
            sleep(100); 
        }

        System.out.println(pratoId + ": " + nomePrato + " pronto! Realizando entrega...");
        sleep((int) (tempoDeEntrega * 1000)); 
        System.out.println(pratoId + ": Entrega do " + nomePrato + " concluída!");
    }

    private void sleep(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
