package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.PatologiaDTO;
import dto.SintomasDTO;

public class SintomasDAO {

	public  List<SintomasDTO> buscarSintomasPorInicial (String inicial)
	{
		List<SintomasDTO> lista_sintomas = new ArrayList<SintomasDTO>();
		
			SintomasDTO sintoma = null;
			Pool pool = null;
			pool = Pool.getInstance();
			Connection conn = Pool.getConnection();
			ResultSet rset = null;
			Statement stmt = null;
			try
			{
				stmt = conn.createStatement();
				rset = stmt.executeQuery(Consulta.CONSUTA_SINTOMAS_POR_NOMBRE+inicial+"%'");
				while (rset.next())
			    {
					sintoma = new SintomasDTO(rset.getInt(1), rset.getString(2));
					lista_sintomas.add(sintoma);
			    }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				Pool.liberarRecursos(conn, stmt, rset);
			}
		
		return lista_sintomas;
	}
}
