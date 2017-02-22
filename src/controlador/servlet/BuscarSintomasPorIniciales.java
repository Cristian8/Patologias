package controlador.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.SintomasDTO;
import servicios.SintomasService;

/**
 * Servlet implementation class BuscarSimtomasPorIniciales
 */
@WebServlet("/BuscarSintomasPorIniciales")
public class BuscarSintomasPorIniciales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSintomasPorIniciales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SintomasService ss = new SintomasService();
		
		
		long tinicial = System.currentTimeMillis();
		
		
		
		List<SintomasDTO> lista_sintomas = new ArrayList<SintomasDTO>();
		
			lista_sintomas = ss.buscarSintomasPorInicial(request.getParameter("intro"));
		
			
			
			/*for(SintomasDTO sintoma: lista_sintomaDTO)
			{
				valorSintoma = sintoma.getDescripcion();
				System.out.println(valorSintoma);
			}*/
		Gson gson = new Gson();
		Type tipoListaSintomas = new TypeToken<List<SintomasDTO>>(){}.getType();
		String s = gson.toJson(lista_sintomas, tipoListaSintomas);
//		System.out.println(s);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(s);
			
		
		
		
		
		long tfinal =System.currentTimeMillis();
		long ttotal = tfinal-tinicial;
		//PrintWriter pw = response.getWriter().append( sintoDto.getDescripcion();
		
		System.out.println("tardo = "+ ttotal +" milliseconds");
		//response.getWriter().write(valor);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String json = request.getReader().readLine();
		Gson gson = new Gson();
		SintomasDTO s = gson.fromJson(json, SintomasDTO.class);
		System.out.println("Id = " + s.getId()+ "Descripcion" + s.getDescripcion());*/
		
		//System.out.println("El usuario ha buscado sintoma: " + s.getDescripcion());
		doGet(request, response);
	}

}
