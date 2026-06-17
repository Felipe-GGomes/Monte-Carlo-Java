import java.util.ArrayList;
import java.util.List;

public class GerenciadorSimulacao {
    private List<Simulavel> simulacoes = new ArrayList<>();

    public void adicionar(Simulavel s){
        simulacoes.add(s);
    }

    public void executarTodas(){
        for(Simulavel s: simulacoes){
            try{
                s.executar();
                System.out.println(s.toString());
                System.out.println("Resultado: " +  s.getResultado());
            } catch (ConvergenciaException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
