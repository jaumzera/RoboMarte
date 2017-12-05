package br.com.joaomassan.robo;

import java.util.regex.Pattern;
import lombok.Data;

/**
 *
 * @author jaumzera
 */
@Data
public class Robo {

    private static final Pattern COMMANDOS_ACEITOS = Pattern.compile("[LRM]+");

    private Posicao posicao;

    private final Terreno terreno;

    public Robo(Terreno terreno) {
        this.terreno = terreno;
        this.posicao = new Posicao(Ponto.em(0, 0), Sentidos.N);
    }

    public void mover(String instrucoes) {
        validarEntrada(instrucoes);
        String[] comandos = instrucoes.split("");

        for (String comando : comandos) {
            Posicao novaPosicao = null;

            switch (comando) {
                case "M":
                    novaPosicao = posicao.mover();
                    break;
                case "L":
                    novaPosicao = posicao.virarEsquerda();
                    break;
                case "R":
                    novaPosicao = posicao.virarDireita();
                    break;
            }

            if (novaPosicao != null
                    && terreno.podeMoverPara(novaPosicao.getPonto())) {
                posicao = novaPosicao;
            } else {
                throw new IllegalStateException(
                        "A posição especificada ("
                        + posicao.toString() + ") é inválida.");
            }
        }
    }

    private void validarEntrada(String instrucoes) throws IllegalArgumentException {
        if (!COMMANDOS_ACEITOS.matcher(instrucoes).matches()) {
            throw new IllegalArgumentException("Os comandos aceitos:\n"
                    + "\t L      (left) vira à esquerda\n"
                    + "\t R      (right) vira à direita\n "
                    + "\t M      (move) faz o robo andar na direção configurada.");
        }
    }
}
