package cl.ubb.agil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;



public class ProductoTest {
	Producto producto;
	Categoria Gibson;
	@Test
	public void pruebaStockGuitarrasGibson5a10(){
		Gibson= new Categoria("Guitarras Eléctricas","10"); 
		producto = new Producto("Guitarra Gibson Les Paul Studio",5,10, Gibson);
		producto.stock=9;
		boolean vof = producto.isBajoStock();
		
		assertFalse(!vof);
	}
	public void pruebaStoc
}
