import java.util.ArrayList;
import java.util.List;

public abstract class Simulacao implements Simulavel{
    protected String nome;
    protected int interacoes;
    List<Double> resultados = new ArrayList<>();

    public Simulacao(String nome, int interacoes) {
        this.nome = nome;
        this.interacoes = interacoes;
    }

    public abstract void executar();
    public abstract double getResultado();

    @Override
    public String toString() {
        return "---Simulacao---\n" +
                "interacoes |" + interacoes + "\n" +
                "nome       |"+ nome + "\n" +
                "resultados |" + resultados + "\n";
    }
}
