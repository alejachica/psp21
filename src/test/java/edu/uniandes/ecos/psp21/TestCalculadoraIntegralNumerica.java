package edu.uniandes.ecos.psp21;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.ecos.psp21.modelo.CalculadoraIntegralNumerica;

/**
 * TestCase para la clase edu.uniandes.ecos.psp21.modelo.CalculadoraIntegralNumerica
 * @author Aleja Chica
 *
 */
public class TestCalculadoraIntegralNumerica {
	
	/**
	 * Objeto que se va a probar
	 */
	private CalculadoraIntegralNumerica calculadoraIntegralNumerica;
	
	/**
	 * Objeto que permite dar formato a los numeros decimales.
	 */
	private DecimalFormat formatoDecimal;
	
	/**
	 * Objeto que da formato de punto decimal, segun el idioma.
	 */
	private DecimalFormatSymbols formatoDecimalSombolo;
	
	
	/**
	 * Metodo que permite configurar los datos de prueba
	 */
	@Before
	public void configurarDatos(){
		
		formatoDecimal = new DecimalFormat("#.###");
		formatoDecimalSombolo = formatoDecimal.getDecimalFormatSymbols();
		formatoDecimalSombolo.setDecimalSeparator('.');
		formatoDecimal.setDecimalFormatSymbols(formatoDecimalSombolo);
		
		calculadoraIntegralNumerica = new CalculadoraIntegralNumerica();
	}

	/**
	 * Test method for {@link edu.uniandes.ecos.psp21.modelo.CalculadoraIntegralNumerica#calcularIntegral(double, int, double)}.
	 */
	@Test
	public void test1CalcularIntegral() {
		
		double resultado = calculadoraIntegralNumerica.calcularIntegralEncontrarX(6, 10, 1.0, 0.20);
		Assert.assertEquals(formatoDecimal.format(0.55338), formatoDecimal.format(resultado));
	}
	
	/**
	 * Test method for {@link edu.uniandes.ecos.psp21.modelo.CalculadoraIntegralNumerica#calcularIntegral(double, int, double)}.
	 */
	@Test
	public void test2CalcularIntegral() {
		
		double resultado = calculadoraIntegralNumerica.calcularIntegralEncontrarX(15, 10, 1.0, 0.45);
		Assert.assertEquals(formatoDecimal.format(1.75305), formatoDecimal.format(resultado));
	}
	
	/**
	 * Test method for {@link edu.uniandes.ecos.psp21.modelo.CalculadoraIntegralNumerica#calcularIntegral(double, int, double)}.
	 */
	@Test
	public void test3CalcularIntegral() {
		
		double resultado = calculadoraIntegralNumerica.calcularIntegralEncontrarX(4, 10, 1.0, 0.495);
		Assert.assertEquals(formatoDecimal.format(4.60409), formatoDecimal.format(resultado));
	}

}
