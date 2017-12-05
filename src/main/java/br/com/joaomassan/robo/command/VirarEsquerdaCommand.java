package br.com.joaomassan.robo.command;

import br.com.joaomassan.robo.Posicao;
import br.com.joaomassan.robo.Robo;

/**
 *
 * @author jaumzera
 */
public class VirarEsquerdaCommand implements Command {

    public static final VirarEsquerdaCommand criarPara(Robo robo) {
        return new VirarEsquerdaCommand(robo);
    }

    private final Robo target;

    private VirarEsquerdaCommand(Robo target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.virarParaEsquerda();
    }

}
