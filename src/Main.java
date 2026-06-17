public class Main {
    public static void main(String[] args) {
        // PARTE 1 — lógica OO
        System.out.println("=== Executando Simulações ===");
        GerenciadorSimulacao g = new GerenciadorSimulacao();
        g.adicionar(new SimulacaoPi(5000));
        g.adicionar(new SimulacaoIntegral(100000, 0, 1));
        g.executarTodas();

        // PARTE 2 — visualização gráfica
        System.out.println("\n=== Abrindo Janela Gráfica ===");
        new JanelaMonteCarlo(10000);
    }
}