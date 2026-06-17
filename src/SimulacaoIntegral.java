import java.util.Random;

public class SimulacaoIntegral extends Simulacao{
    private double limiteA;
    private double limiteB;

    public SimulacaoIntegral(int interacoes, double limiteA, double limiteB) {
        super("SimulacaoIntegral", interacoes);
        this.limiteA = limiteA;
        this.limiteB = limiteB;
    }

    @Override
    public void executar() {
        Random random = new Random();
        double soma = 0;
        for(int i = 0; i < interacoes; i++){
            double x = limiteA + random.nextDouble() * (limiteB - limiteA);
            soma += x*x;
            resultados.add(soma / (i+1) * (limiteB - limiteA));
        }
    }

    @Override
    public double getResultado() {
        return resultados.get(resultados.size() - 1);
    }
}
