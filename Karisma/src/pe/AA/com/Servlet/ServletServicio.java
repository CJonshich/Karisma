package pe.AA.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.AA.com.Bean.BeanServicio;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.I_Servicio;

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
			
			//Dao
			I_Servicio servicioDao=DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao();
			BeanServicio servicio = servicioDao.buscarxId(id);
			
			request.setAttribute("servicioEdit",servicio);
			request.getRequestDispatcher("editarServicio.jsp").forward(request, response);
			
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
		
		String opcion=request.getParameter("opcion");
		System.out.println("Selecciono: "+opcion);
		if(opcion.equals("agregar")){
			BeanServicio servicio=new BeanServicio();
			servicio.setNomservicio(request.getParameter("txtNombre"));
			servicio.setDescripcion(request.getParameter("txaDescripcion"));
			servicio.setCosto(Double.parseDouble(request.getParameter("txtCosto")));
			System.out.println("Selecciono guardar");
			//DAO
			I_Servicio servicioDao = DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao();
			int id=servicioDao.agregar(servicio);
			
			if(id!=0){
				response.sendRedirect("servicio?opcion=listar");
			}else{
				request.setAttribute("mensaje", "No se pudo agregar el servicio");
				request.getRequestDispatcher("mensaje.jsp").forward(request, response);
			}
			
		}else if(opcion.equals("editar")){
			
			BeanServicio servicio=new BeanServicio();
			servicio.setIdservicio(Integer.parseInt(request.getParameter("txtCodServicio")));
			servicio.setNomservicio(request.getParameter("txtNombre"));
			servicio.setDescripcion(request.getParameter("txaDescripcion"));
			servicio.setCosto(Double.parseDouble(request.getParameter("txtCosto")));
			
			//Dao
			I_Servicio servicioDao = DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao();
			boolean flag = servicioDao.editar(servicio);
			
			
			if(flag){
				response.sendRedirect("servicio?opcion=listar");
			}else{
				request.setAttribute("mensaje", "No se pudo editar el servicio");
				request.getRequestDispatcher("mensaje.jsp").forward(request, response);
			}
		}
	}

}
