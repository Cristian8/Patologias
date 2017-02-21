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

	public List<String> buscarSintomasPorInicial(String inicial){
		
		List<String> lista_sintomas = new ArrayList<String>();
		Pool pool = Pool.getInstance();
		Connection conn = Pool.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(Consulta.CONSUTA_SINTOMAS_POR_NOMBRE+inicial+"%'");
			while (rset.next())
		    {
				//int id, String descripcion,
				//lista_sintomas = new SintomasDTO(rset.getInt(1), rset.getString(2));
				String sintoma = rset.getString(2);
				lista_sintomas.add(sintoma);
				System.out.println(sintoma);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			Pool.liberarRecursos(conn, stmt, rset);
		}
		return lista_sintomas;
	}
	
}
