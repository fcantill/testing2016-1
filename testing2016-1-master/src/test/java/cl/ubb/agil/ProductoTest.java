package cl.ubb.agil;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;



public class ProductoTest {
	
	
	@Test
	public void pruebaStockMaximo10yStockActual7(){
		Producto producto;
		Categoria Gibson;
		Gibson= new Categoria("Guitarras Eléctricas","10"); 
		producto = new Producto("Guitarra Gibson Les Paul Studio",5,10, Gibson);
		producto.stock=7;
		boolean vof = producto.isBajoStock();
		
		assertFalse(vof);
	}
	
	@Test
	public void PruebaBajoStockVerdadera_Minimo5yActual3(){
		
		/*Arrange*/
		Producto producto=new Producto("Guitarra Fender",5,30);
		producto.stock=3;
		
		/*act*/
		boolean compara = producto.isBajoStock();
		
		/*assert*/
		assertTrue(compara);
	}
	@Test
	public void PruebaBajoStockErronea_Minimo5yActual7(){
		
		/*Arrange*/
		Producto producto=new Producto("Guitarra Fender",5,30);
		producto.stock=7;
		
		/*act*/
		boolean compara = producto.isBajoStock();
		
		/*assert*/
		assertTrue(compara);
	}
	@Test
	public void PruebaStockActual33SobreStockMaximo30(){
		
		/*Arrange*/
		Producto producto=new Producto("Guitarra Fender",5,30);
		producto.stock=33;
		
		/*act*/
		int compara = producto.getStockFaltante();
		
		/*assert*/
		assertThat(compara,is(-3));
	}
	@Test(expected = ExcepcionDeProducto.class)
	public void getProximaExistenciaErroneaLanzaExcepcion() throws Exception{
		
		/*Arrange*/
		Producto producto=new Producto("Bateria Peace",1,5);
		producto.stock=0;
		
		/*act*/
		Existencia existencia = producto.getProximaExistencia();
		
		
	}
	
	@Test
	public void getProximaExistenciaCorrecto() throws Exception{
		
		/*Arrange*/
		Producto producto=new Producto("Bateria Peace",1,5);
		producto.stock=4;
		Existencia existencia= new Existencia("1234");
		producto.addExistencia(existencia);
		
		/*act*/
		Existencia existenciaAComparar = producto.getProximaExistencia();
		
		/*assert*/
		assertEquals(existencia,existenciaAComparar);
	}
	
	
	@Test
	public void PruebaExistenciaAgregadaExistosamente(){
		
		/*Arrange*/
		Existencia existencia= new Existencia("1234"); 
		Producto producto=new Producto("Amplificador marshall",7,15);
		producto.stock=9;
		
		/*act*/
		boolean existenciaAgregada = producto.addExistencia(existencia);
		
		/*assert*/
		assertTrue(existenciaAgregada);
	}
	
	
	@Test
	public void PruebaExistenciaNoPuedeSerAgregada(){
		
		/*Arrange*/
		Existencia existencia= new Existencia("1234"); 
		Producto producto=new Producto("Amplificador marshall",7,15);
		producto.stock=18;
		
		/*act*/
		boolean existenciaAgregada = producto.addExistencia(existencia);
		
		/*assert*/
		assertTrue(existenciaAgregada);
	}
	
	
	@Test
	public void getCodigoProximaExistenciaCorrecto() throws Exception{
		
		/*Arrange*/
		Producto producto=new Producto("Bateria Peace",1,5);
		producto.stock=4;
		Existencia existencia= new Existencia("1234");
		producto.addExistencia(existencia);
		
		/*act*/
		String NumeroExistencia= "XXXXX-" + existencia.getNumero();
		String NumeroexistenciaProducto = producto.getCodigoProximaExistencia();
		
		/*assert*/
		assertEquals(NumeroExistencia, NumeroexistenciaProducto);
	}
	
	@Test(expected = ExcepcionDeProducto.class)
	public void getCodigoProximaExistenciaIncorrectoLanzaExcepcion() throws Exception{
		
		/*Arrange*/
		Producto producto=new Producto("Bateria Peace",1,5);
		producto.stock=0;
		
		/*act*/
		
		producto.getCodigoProximaExistencia();
	}
	
	
}
