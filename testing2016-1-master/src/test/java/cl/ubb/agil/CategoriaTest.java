package cl.ubb.agil;
import org.junit.Before;
import org.junit.Test;


public class CategoriaTest {
	@Test
	public void pruebaCambioNombrePorGibson(){
		Categoria cat;
		cat = new Categoria("bajo","gibson");
		
		cat.setNombre("Gibson");
	}
	@Test
	public void pruebaGetNombreVacio(){
		Categoria cat;
		cat = new Categoria(" ","Gibson");
		
		cat.getNombre();
	}
	@Test
	public void pruebaGetCodigoVacio(){
		Categoria cat;
		cat = new Categoria("bajo","");
		
		cat.getCodigo();
	}

}
