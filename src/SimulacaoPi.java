import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class SimulacaoPi extends Simulacao{
    private List<Ponto> pontos = new ArrayList<>();
    public SimulacaoPi(int interacoes) {
        super("SimulacaoPi", interacoes);
    }

    public List<Ponto> getPontos() {
        return pontos;
    }

    @Override
    public void executar() {
        Random random = new Random();
        int pontosDentro = 0;
        for(int i = 0; i < interacoes; i++){
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;
            boolean dentro = (x*x + y*y <= 1);

            pontos.add(new Ponto(dentro, x, y));

            if(dentro) pontosDentro++;
            resultados.add((double) pontosDentro / (i+1) * 4);
        }
        if (Math.abs(getResultado() - Math.PI) > 0.01){
            throw new ConvergenciaException("Pi nao convergiu: " + getResultado());
        }

    }

    @Override
    public double getResultado() {
        return resultados.get(resultados.size() -1);
    }
}
