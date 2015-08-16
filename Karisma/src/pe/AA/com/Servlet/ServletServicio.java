package pe.AA.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.AA.com.Bean.BeanServicio;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.I_Servicio;
import pe.AA.com.Util.ResponseObject;

/**
 * Servlet implementation class ServletServicio
 */
@WebServlet("/servicio")
public class ServletServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletServicio() {
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
			List<BeanServicio> lista = DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao().listar();
			if(lista!=null){
				request.setAttribute("listaServicios", lista);
				request.getRequestDispatcher("buscarServicio.jsp").forward(request, response);
			}
		}else if(opcion.equals("listar")){
			List<BeanServicio> lista = DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao().listar();
			request.setAttribute("listaServicios", lista);
			request.getRequestDispatcher("mantenerServicios.jsp").forward(request, response);
			
		}else if(opcion.equals("agregar")){
			request.getRequestDispatcher("agregarServicio.jsp").forward(request, response);
		}else if(opcion.equals("editar")){
			//Capturar el id
			int id = Integer.parseInt(request.getParameter("id"));
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			//Dao
			I_Servicio servicioDao=DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao();
			BeanServicio servicio = servicioDao.buscarxId(id);
			
			response.getWriter().write(new Gson().toJson(servicio));
			
		}else if(opcion.equals("eliminar")){
			int idservicio=Integer.parseInt(request.getParameter("id"));
			I_Servicio servicioDao=DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao();
			boolean flag = servicioDao.eliminarServicio(idservicio);
			if(flag){
			request.getRequestDispatcher("servicio?opcion=listar").forward(request, response);
			}else{
			String mensaje="Hubo un error al eliminar el servicio";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			HttpSession session=request.getSession(true);
			
			String opcion=request.getParameter("opcion");
		
			String errorMessage = "";
			String successMessage = "";
			int id = 0;
			boolean flag = false;	
			
			BeanServicio servicio=new BeanServicio();
			servicio.setNomservicio(request.getParameter("nombre"));
			servicio.setDescripcion(request.getParameter("descripcion"));
			servicio.setCosto(Double.parseDouble(request.getParameter("costo")));
			
			I_Servicio servicioDao = DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao();
			
			if(opcion.equals("agregar")){
				id=servicioDao.agregar(servicio);
				if(id<1){
					errorMessage="No se pudo agregar el servicio";
				}
			}else if(opcion.equals("editar")){
				servicio.setIdservicio(Integer.parseInt(request.getParameter("codservicio")));
				flag = servicioDao.editar(servicio);
				if(!flag){
					errorMessage="No se pudo editar el servicio";
				}
			}
			
			if(id!=0||flag){
				if(id!=0){
					successMessage="Se registró el servicio";
				}else if(flag){
					successMessage="Se modificó el servicio";
				}
				session.setAttribute("servicioOk", successMessage);
				response.sendRedirect("servicio?opcion=listar");
			}else{
				session.setAttribute("servicioError", errorMessage);
			}

	}

}
