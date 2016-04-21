package cl.ubb.agil;
import org.junit.Before;
import org.junit.Test;

public class ExistenciaTest {
	@Test
	public void pruebaIngresaExistenciaVacia(){
		Existencia existencia;
		existencia = new Existencia("");
		existencia.getNumero();
	}
	@Test
	public void pruebaIngresaExistenciaConLetras(){
		Existencia existencia;
		existencia = new Existencia("abc");
		existencia.getNumero();
	}
}
