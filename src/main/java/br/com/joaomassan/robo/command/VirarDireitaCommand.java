package br.com.joaomassan.robo.command;

import br.com.joaomassan.robo.Posicao;
import br.com.joaomassan.robo.Robo;

/**
 *
 * @author jaumzera
 */
public class VirarDireitaCommand implements Command {

    public static final VirarDireitaCommand criarPara(Robo robo) {
        return new VirarDireitaCommand(robo);
    }

    private final Robo target;

    private VirarDireitaCommand(Robo target) {
        this.target = target;
    }

    @Override
    public void execute() {
        target.virarParaDireita();
    }

}
