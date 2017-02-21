package controlador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		String valor = request.getParameter("valor");
		
		
		long tinicial = System.currentTimeMillis();
		List<String> sintoDto = ss.buscarSintomasPorInicial("v");
		for (String string : sintoDto) {
			System.out.println(string);
		}
		
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
		doGet(request, response);
	}

}
