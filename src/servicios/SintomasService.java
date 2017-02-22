package servicios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SintomasDAO;
import dto.SintomasDTO;

public class SintomasService {
	
	public static List<SintomasDTO>  buscarSintomasPorInicial (String inicial) throws SQLException
	{
		List<SintomasDTO> lista_sintomas= null;
		
		lista_sintomas = SintomasDAO.getSintomasPorInicial(inicial);
		
		
		return lista_sintomas;
		
	}
}
