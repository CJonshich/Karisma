package pe.AA.com.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.AA.com.Bean.*;

import com.google.gson.Gson;

import pe.AA.com.Bean.BeanUsuario;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.I_Usuario;
import pe.AA.com.Util.ResponseObject;

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
		
		ResponseObject responseObj = new ResponseObject();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String pagina="";
		
		BeanUsuario usuario = new BeanUsuario();
		I_Usuario usuarioDao = DaoFactory.getFactory(DaoFactory.MYSQL).getUsuarioDao();
		
		//Comprobar que el usuario y clave existan
		boolean rpta=usuarioDao.validar(user, pass);
		
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
			
			responseObj.setUrl(pagina);
			responseObj.setSuccess(true);
		}else{
			responseObj.setSuccess(false);
		}
		response.getWriter().write(new Gson().toJson(responseObj));
	} //fin del accederd
}
