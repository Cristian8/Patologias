package dao;

public class Consulta {
	
	public static final String CONSULTA_LISTAR_PATOLOGIAS = "SELECT * FROM Patologias";
	public static final String CONSULTA_PATOLOGIAS_POR_ID = "SELECT * FROM Patologias WHERE id_patol = ";
	public static final String CONSULTA_SINTOMAS_POR_PATOLOGIA = "SELECT * FROM Sintomas WHERE id_sint IN (SELECT id_sint FROM PatolSint WHERE id_patol IN (SELECT id_patol FROM Patologias WHERE id_patol = '";

}
