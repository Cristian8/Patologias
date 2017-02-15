package servicios;

import dao.PatologiaDAO;
import dto.PatologiaDTO;

public class PatologiaService {
	
	public PatologiaDTO buscarPatologiaPorId (int id)
	{
		PatologiaDTO pdto = null;
		PatologiaDAO pdao = new PatologiaDAO();
		
			pdto = pdao.buscarPorId(id);
		
		return pdto;
	}

}