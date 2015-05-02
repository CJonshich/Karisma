package pe.AA.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.AA.com.Bean.BeanOdontologo;
import pe.AA.com.Factory.DaoFactory;

/**
 * Servlet implementation class ServletOdontologo
 */
@WebServlet("/odontologo")
public class ServletOdontologo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOdontologo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		if(opcion.equals("buscar")){
			//Funcionando 100%
			//Lista los elementos a mostrar en el Pop-Up
			List<BeanOdontologo> listaO=DaoFactory.getFactory(DaoFactory.MYSQL).getOdontologoDao().buscarOdontologosLibres();
			if(listaO!=null){
			//Envia los atributos de Odontologo y redirecciona al JSP que hace de Pop-UP
			request.setAttribute("listaO", listaO);
			request.getRequestDispatcher("buscarOdontologo.jsp").forward(request, response);
			}else{
				//En caso de no encontrar odontologo
				String errorO="No hay odontologos disponibles";
				request.getSession().setAttribute("errorbOdontologo", errorO);
				request.getRequestDispatcher("buscarOdontologo.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
