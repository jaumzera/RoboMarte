package br.com.joaomassan.robo;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jaumzera
 */
public class TerrenoTest {

    public TerrenoTest() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoCriarMedidasNegativas() {
        Terreno.retangular(-3, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveNaoCriarTerrenoComMedidasZeradas() {
        Terreno.quadrado(0);
    }

    @Test
    public void deveCriarUmTerrenoXPorY() {
        Terreno terreno = Terreno.retangular(23, 4);
        Assert.assertEquals(23 * 4, terreno.getArea());
    }

    @Test
    public void deveCriarUmTerrenoQuadrado() {
        Terreno terreno = Terreno.quadrado(5);
        Assert.assertEquals(25, terreno.getArea());
    }

    @Test
    public void deveAssegurarPosicoesValidas() {
        Terreno terreno = Terreno.quadrado(5);
        //assertTrue(terreno.podeMoverPara(Posicao.of(0, 0, N)));
    }

}
