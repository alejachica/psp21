package edu.uniandes.ecos.psp21;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.ecos.psp21.modelo.IntegracionNumerica;

/**
 * TestCase para la clase edu.uniandes.ecos.psp2.modelo.IntegracionNumerica
 * @author Aleja Chica
 *
 */
public class TestIntegracionNumerica {
	
	/**
	 * Objeto que se va a probar
	 */
	private IntegracionNumerica integracionNumerica;
	
	/**
	 * Metodo que permite configurar los datos de prueba
	 */
	@Before
	public void configurarDatos(){
		
		integracionNumerica = new IntegracionNumerica(9, 10, 1.1);
	}

	/**
	 * Test method for {@link edu.uniandes.ecos.psp2.modelo.IntegracionNumerica#calcularIntegral()}.
	 */
	@Test
	public void testCalcularIntegral() {
		
		double resultado = integracionNumerica.calcularIntegral();
		Assert.assertEquals(0.3500589042865572, resultado);
	}

	/**
	 * Test method for {@link edu.uniandes.ecos.psp2.modelo.IntegracionNumerica#calcularMultiplicador(int)}.
	 */
	@Test
	public void testCalcularMultiplicador() {
		
		double multiplicador = integracionNumerica.calcularMultiplicador(2);
		Assert.assertEquals(2.0, multiplicador);
	}

	/**
	 * Test method for {@link edu.uniandes.ecos.psp2.modelo.IntegracionNumerica#calcularFx(double)}.
	 */
	@Test
	public void testCalcularFx() {
		
		double resultado = integracionNumerica.calcularFx(1.1);
		Assert.assertEquals(0.20651644224485102, resultado);
	}

}
