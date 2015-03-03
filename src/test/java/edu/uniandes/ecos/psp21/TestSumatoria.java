package edu.uniandes.ecos.psp21;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.ecos.psp21.modelo.Sumatoria;

/**
 * TestCase para la clase edu.uniandes.ecos.psp2.modelo.Sumatoria
 * @author Aleja Chica
 *
 */
public class TestSumatoria {

	/**
	 * Lista de numero de prueba
	 */
	private List<Double> numeros;
	
	/**
	 * Objeto que se va a probar
	 */
	private Sumatoria sumatoria;

	/**
	 * Metodo que permite configurar los datos de prueba
	 */
	@Before
	public void configurarDatos() {
		
		sumatoria = new Sumatoria();

		numeros = new ArrayList<Double>();
		numeros.add(1.0);
		numeros.add(2.0);
		numeros.add(3.0);
		numeros.add(4.0);
		numeros.add(5.0);
	}

	/**
	 * Test method for
	 * {@link edu.uniandes.ecos.psp2.modelo.Sumatoria#calcularSumatoria(java.util.List)}
	 * .
	 */
	@Test
	public void testCalcularSumatoria() {
		double resultado = sumatoria.calcularSumatoria(numeros);
		Assert.assertEquals(15.0, resultado);
	}
}
