package pe.AA.com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.AA.com.Bean.BeanUsuario;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.I_Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/empleado")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		session.removeAttribute("usuario");
		session.invalidate();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Captura de la Opción
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("acceder")){
		//PrintWriter para AJAX
		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out = response.getWriter();	
			
			
		//Captura de Datos del FORM
			
		String user=request.getParameter("txtUsuario");
		String pass=request.getParameter("txtClave");
		System.out.println("User y Clave "+user+" "+pass);
	
		//Creo Bean
		BeanUsuario usuario = new BeanUsuario();
		I_Usuario usuarioDao = DaoFactory.getFactory(DaoFactory.MYSQL).getUsuarioDao();
		//Comprobar que el usuario y clave existan
		boolean rpta=usuarioDao.validar(user, pass);
		String pagina="";
		
		
		
		if(rpta){
			//Obtener datos del Usuario
			usuario=usuarioDao.acceder(user, pass);
			String rol=usuario.getRol();
			if(rol.equals("A")){
				pagina="/menuAuxiliar.jsp";
			}else if(rol.equals("C")){
				pagina="/menuCajero.jsp";
			}
			HttpSession session=request.getSession(true);
			session.setAttribute("usuario", usuario);
			
			
			
		}else{
			pagina="/index.jsp";
			out.println("<p>");
			out.println("Hola");
			out.println("</p>");
			
		}
		request.getRequestDispatcher(pagina).forward(request, response);
		
		
	}
	}
	//fin del acceder
}
