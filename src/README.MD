# Monte Carlo - Estimando π

Projeto final da disciplina de Introdução à Orientação a Objetos (UTFPR).

## Descrição

Simulação de Monte Carlo em Java que estima o valor de π lançando pontos aleatórios em um quadrado e calculando a proporção dos que caem dentro de um círculo. Inclui também cálculo de integrais pelo mesmo método.

## Estrutura

- `Simulavel` — interface base
- `Simulacao` — classe abstrata
- `SimulacaoPi` — estima π via Monte Carlo
- `SimulacaoIntegral` — calcula integrais
- `ConvergenciaException` — exceção customizada
- `GerenciadorSimulacao` — gerencia as simulações
- `JanelaMonteCarlo` + `PainelMonteCarlo` — interface gráfica em Swing

## Como rodar

Abre no IntelliJ e executa a classe `Main`.

## Autor

Felipe — UTFPR Pato Branco, 2026