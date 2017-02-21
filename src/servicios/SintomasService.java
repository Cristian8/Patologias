package servicios;

import java.util.ArrayList;
import java.util.List;

import dao.SintomasDAO;

public class SintomasService {
	
	public List<String> buscarSintomasPorInicial(String inicial){
		
		List<String> lista_sintomas = new ArrayList<String>() ;
		SintomasDAO sintoDao = new SintomasDAO();
			
		lista_sintomas = sintoDao.buscarSintomasPorInicial(inicial);
		
		return lista_sintomas;
	}
}
