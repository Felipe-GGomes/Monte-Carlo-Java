import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class JanelaMonteCarlo {
    private JFrame janela;
    private PainelMonteCarlo painel;
    private int iteracoes;

    public JanelaMonteCarlo(int iteracoes) {
        this.iteracoes = iteracoes;

        janela = new JFrame("Monte Carlo - Estimando Pi");
        janela.setSize(600, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());

        SimulacaoPi simulacao = new SimulacaoPi(iteracoes);
        simulacao.executar();
        painel = new PainelMonteCarlo(simulacao);
        // painel de explicação no topo
        JLabel explicacao = new JLabel(
                "<html><div style='text-align: center; padding: 10px;'>" +
                        "<b>Simulação de Monte Carlo - Estimando π</b><br>" +
                        "Pontos aleatórios são lançados no quadrado. " +
                        "A proporção dos que caem dentro do círculo (verdes) " +
                        "multiplicada por 4 estima o valor de π." +
                        "</div></html>"
        );
        janela.add(explicacao, BorderLayout.NORTH);
        janela.add(painel, BorderLayout.CENTER);

        // painel de controles na parte de baixo
        JPanel controles = new JPanel(new FlowLayout());

        JButton botaoReiniciar = new JButton("Reiniciar Simulação");
        botaoReiniciar.addActionListener(e -> {
            SimulacaoPi nova = new SimulacaoPi(iteracoes);
            nova.executar();
            painel.reiniciar(nova);
        });

        JLabel labelVelocidade = new JLabel("Velocidade:");
        JSlider slider = new JSlider(10, 500, 50);
        slider.addChangeListener(e -> painel.setVelocidade(slider.getValue()));

        controles.add(botaoReiniciar);
        controles.add(labelVelocidade);
        controles.add(slider);

        janela.add(controles, BorderLayout.SOUTH);
        janela.setVisible(true);
    }
}