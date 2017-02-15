package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.PatologiaDTO;
import dto.SintomaDTO;



public class PatologiaDAO {

	public PatologiaDTO buscarPorId (int id)
	{
		PatologiaDTO pdto = null;
			
		Pool pool = Pool.getInstance();
		Connection conn = Pool.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(Consulta.CONSULTA_PATOLOGIAS_POR_ID+id);
			while (rset.next())
		    {
				//int id, String nombre, String causa, String tratamiento, String descripcion,
				pdto = new PatologiaDTO(rset.getInt(1), rset.getNString(2), rset.getString(5), rset.getString(4), rset.getNString(3), getSintomasPorPatologiaID(conn, rset.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			Pool.liberarRecursos(conn, stmt, rset);
		}
		return pdto;
	}
	
	public static List<SintomaDTO> getSintomasPorPatologiaID (Connection conn, int id) throws SQLException
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
			
			String descripcion_sintoma = null;
			int id_sintoma = 0;
			SintomaDTO sintoma = null;
			ResultSet rset2 = null;
			Statement stmt2 = null;
			stmt2 = conn.createStatement();
			rset2 = stmt2.executeQuery(Consulta.CONSULTA_SINTOMAS_POR_PATOLOGIA+id+"'))");
			while (rset2.next())
		    {
				id_sintoma = rset2.getInt(1);
				descripcion_sintoma = rset2.getString(2);
				sintoma = new SintomaDTO(id_sintoma, descripcion_sintoma);
				lista_sintomas.add(sintoma);
			}
			if (rset2 != null) 	{ try { rset2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt2 != null)	{ try {	stmt2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			
		return lista_sintomas;
	}
}
