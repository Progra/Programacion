package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class uFecha {

	public String fechaActual(){
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = new Date();		
		String fecha = formateador.format(fechaDate);
		
		return fecha;
	}
}
