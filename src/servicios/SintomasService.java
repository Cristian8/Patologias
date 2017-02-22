package servicios;


import java.util.ArrayList;
import java.util.List;

import dao.SintomasDAO;
import dto.SintomasDTO;

public class SintomasService {
	
	public List<SintomasDTO> buscarSintomasPorInicial (String inicial)
	{
		List<SintomasDTO> lista_sintomas = new ArrayList<SintomasDTO>();
		SintomasDAO sintdao = new SintomasDAO();
		
			lista_sintomas = sintdao.buscarSintomasPorInicial(inicial);
		
		return lista_sintomas;
	}
}
