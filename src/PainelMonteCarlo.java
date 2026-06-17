import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class PainelMonteCarlo extends JPanel {
    private SimulacaoPi simulacao;
    private int pontosDesenhados = 0;
    private Timer timer;
    private int pontosPorTick = 50;

    public PainelMonteCarlo(SimulacaoPi simulacao) {
        this.simulacao = simulacao;
        criarTimer();
    }

    private void criarTimer() {
        timer = new Timer(30, e -> {
            pontosDesenhados += pontosPorTick;
            if (pontosDesenhados >= simulacao.getPontos().size()) {
                pontosDesenhados = simulacao.getPontos().size();
                timer.stop();
            }
            repaint();
        });
        timer.start();
    }

    public void reiniciar(SimulacaoPi novaSimulacao) {
        if (timer != null) timer.stop();
        this.simulacao = novaSimulacao;
        this.pontosDesenhados = 0;
        criarTimer();
        repaint();
    }

    public void setVelocidade(int pontosPorTick) {
        this.pontosPorTick = pontosPorTick;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawRect(50, 50, 400, 400);
        g.setColor(Color.BLUE);
        g.drawOval(50, 50, 400, 400);
        int dentro = 0;
        for (int i = 0; i < pontosDesenhados; i++) {
            Ponto p = simulacao.getPontos().get(i);
            if (p.isDentro()) {
                g.setColor(Color.GREEN);
                dentro++;
            } else {
                g.setColor(Color.RED);
            }
            int px = 50 + (int)((p.getX() + 1) * 200);
            int py = 50 + (int)((p.getY() + 1) * 200);
            g.fillOval(px, py, 4, 4);
        }

        double piEstimado = 0;
        if (pontosDesenhados > 0) {
            piEstimado = (double) dentro / pontosDesenhados * 4;
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("π estimado: " + String.format("%.5f", piEstimado), 60, 480);
        g.drawString("Pontos: " + pontosDesenhados + " / " + simulacao.getPontos().size(), 60, 500);
        g.drawString("Dentro do círculo: " + dentro, 60, 520);
    }
}