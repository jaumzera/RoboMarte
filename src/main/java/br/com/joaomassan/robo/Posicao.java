package br.com.joaomassan.robo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jaumzera
 */
@Data
@EqualsAndHashCode(of = {"ponto", "sentido"})
public class Posicao {

    private final Ponto ponto;

    private final Sentidos sentido;

    public Posicao(Ponto em, Sentidos sentido) {
        this.ponto = em;
        this.sentido = sentido;
    }

    public Posicao mover() {
        Posicao novaPosicao;
        switch (sentido) {
            case N:
                novaPosicao = deslocarParaNorte();
                break;
            case S:
                novaPosicao = deslocarParaSul();
                break;
            case E:
                novaPosicao = deslocarParaLeste();
                break;
            case W:
                novaPosicao = deslocarParaOeste();
                break;
            default:
                novaPosicao = this;
        }

        return novaPosicao;
    }

    public Posicao virarEsquerda() {
        return new Posicao(ponto, sentido.virarEsquerda());
    }

    public Posicao virarDireita() {
        return new Posicao(ponto, sentido.virarDireita());
    }

    public Posicao deslocarParaNorte() {
        return new Posicao(ponto.moverYEm(1), Sentidos.N);
    }

    public Posicao deslocarParaSul() {
        return new Posicao(ponto.moverYEm(-1), Sentidos.S);
    }

    public Posicao deslocarParaLeste() {
        return new Posicao(ponto.moverXEm(1), Sentidos.E);
    }

    public Posicao deslocarParaOeste() {
        return new Posicao(ponto.moverXEm(-1), Sentidos.W);
    }

    @Override
    public String toString() {
        return "{" + ponto.getX()
                + "," + ponto.getY()
                + "," + sentido.toString()
                + "}";
    }
}
