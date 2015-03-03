package edu.uniandes.ecos.psp21;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.ecos.psp21.modelo.DistribucionT;

/**
 * TestCase para la clase edu.uniandes.ecos.psp2.modelo.DistribucionT
 * @author Aleja Chica
 *
 */
public class TestDistribucionT {
	
	/**
	 * Objeto que se va a probar
	 */
	private DistribucionT dt;

	/**
	 * Metodo que permite configurar los datos de prueba
	 */
	@Before
	public void configurarDatos(){
		
		dt = new DistribucionT();
	}

	/**
	 * Test method for {@link edu.uniandes.ecos.psp2.modelo.DistribucionT#calcularDistribucionT()}.
	 */
	@Test
	public void testCalcularDistribucionT() {

		double gamma = dt.calcularDistribucionT(9, 0.11);
		Assert.assertEquals(0.38543693984483196, gamma);
	}

	/**
	 * Test method for {@link edu.uniandes.ecos.psp2.modelo.DistribucionT#funcionGammaEnteros()}.
	 */
	@Test
	public void testFuncionGammaEnteros() {
		
		long gamma = dt.funcionGammaEnteros(5);
		Assert.assertEquals(24, gamma);
	}

	/**
	 * Test method for {@link edu.uniandes.ecos.psp2.modelo.DistribucionT#funcionGammaNoEnteros()}.
	 */
	@Test
	public void testFuncionGammaNoEnteros() {

		double gamma = dt.funcionGammaNoEnteros(4.5);
		Assert.assertEquals(11.631728396567448, gamma);
	}

}
