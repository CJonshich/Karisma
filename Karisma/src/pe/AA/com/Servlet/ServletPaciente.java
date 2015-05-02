package pe.AA.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.AA.com.Bean.*;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.I_Paciente;

/**
 * Servlet implementation class ServletPaciente
 */
@WebServlet("/paciente")
public class ServletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		
		if(opcion.equals("listar")){
			List<BeanPaciente> lista =DaoFactory.getFactory(DaoFactory.MYSQL).getPacienteDao().listar();
			request.setAttribute("mantePac", lista);
			request.getRequestDispatcher("mantenerPaciente.jsp").forward(request, response);
		}else if(opcion.equals("agregar")){
			List<BeanDistrito> lista = DaoFactory.getFactory(DaoFactory.MYSQL).getDistritoDao().listar();
			request.setAttribute("listadistrito", lista);
			request.getRequestDispatcher("agregarPaciente.jsp").forward(request, response);
		}else if(opcion.equals("editar")){
			
			int id = Integer.parseInt(request.getParameter("id"));
			I_Paciente pacienteDao = DaoFactory.getFactory(DaoFactory.MYSQL).getPacienteDao();
			BeanPaciente paciente = pacienteDao.buscarPacientexId(id);
			List<BeanDistrito> lista = DaoFactory.getFactory(DaoFactory.MYSQL).getDistritoDao().listar();
			request.setAttribute("listadistrito", lista);
			request.setAttribute("pacienteEdit", paciente);
			request.getRequestDispatcher("/editarPaciente.jsp").forward(request, response);
		
		}else if(opcion.equals("eliminar")){
			int id = Integer.parseInt(request.getParameter("id"));
			I_Paciente pacienteDao = DaoFactory.getFactory(DaoFactory.MYSQL).getPacienteDao();
			boolean flag = pacienteDao.eliminarPaciente(id);
				
			if(flag){
				request.getRequestDispatcher("paciente?opcion=listar").forward(request, response);	
			}else{
				String mensaje="Hubo un error al eliminar el paciente";
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
		
		if(opcion.equalsIgnoreCase("buscar")){
			String dni=request.getParameter("txtdni");
			
			BeanPersona persona = new BeanPersona();
			persona.setDni(dni);
			
			BeanPaciente paciente=new BeanPaciente();
			paciente.setPersona(persona);
			
			I_Paciente pacienteDao = DaoFactory.getFactory(DaoFactory.MYSQL).getPacienteDao();
			paciente=pacienteDao.buscarPaciente(paciente.getPersona().getDni());
			if(paciente==null){
				System.out.println("No hay cadena en Buscar Paciente");
				request.getSession().setAttribute("errobPaciente", "Paciente no encontrado");
				request.getRequestDispatcher("buscarPacienteError.jsp").forward(request, response);
			
			}else{
				request.setAttribute("BPacienteobj", paciente);
				request.getRequestDispatcher("buscarPaciente.jsp").forward(request, response);
			}
			
			
		}else if(opcion.equalsIgnoreCase("agregar")){
			
			String dni = request.getParameter("txtdni");
			I_Paciente pacienteDao = DaoFactory.getFactory(DaoFactory.MYSQL).getPacienteDao();
			BeanPaciente objrespuesta = pacienteDao.buscarPaciente(dni);
			//Validar si el paciente existe o no
			if(objrespuesta!=null){
				request.setAttribute("mensaje","Ya existe un paciente con el DNI ingresado");
				request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
			}else{
				//Obtener valores de persona
				BeanPersona persona = new BeanPersona();
			
				persona.setNom(request.getParameter("txtnombres"));
				persona.setApePat(request.getParameter("txtapePat"));
				persona.setApeMat(request.getParameter("txtapeMat"));
				persona.setDni(request.getParameter("txtdni"));
				persona.setDomicilio(request.getParameter("txtdomicilio"));
				persona.setEmail(request.getParameter("txtemail"));
				persona.setSexo(request.getParameter("rdbsexo"));
				persona.setTelefono(request.getParameter("txttelefono"));
				persona.setFecNac(request.getParameter("txtfecha"));
	
//			if(persona.getDni().length()<8){
//				
//				List<BeanDistrito> lista = DaoFactory.getFactory(DaoFactory.MYSQL).getDistritoDao().listar();
//				request.setAttribute("listadistrito", lista);
//				request.getRequestDispatcher("agregarPaciente.jsp").forward(request, response);
//			}
//			
				//Obtener valores para distrito
				BeanDistrito distrito = new BeanDistrito();
				distrito.setIddistrito(Integer.parseInt(request.getParameter("sel_distrito")));
			
				persona.setDistrito(distrito);

				BeanPaciente paciente=new BeanPaciente();
				
				paciente.setTalla(Double.parseDouble(request.getParameter("txttalla")));
				paciente.setPeso(Double.parseDouble(request.getParameter("txtpeso")));
				paciente.setTipoSangre(request.getParameter("sel_GSangre"));
				paciente.setPersona(persona);
				//Dao
		
				int codPac=pacienteDao.ingresarPaciente(paciente);
				
				//Muestra del codigo a la consola
				System.out.println("Código del paciente generado: "+codPac);
				//Envio de mensajes segun el resultado de la operación
					if(codPac>0){
						request.setAttribute("mensaje","Se ingreso un nuevo paciente");
						request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
					}else{
						request.setAttribute("mensaje", "Hubo un error al ingresar el paciente");
						request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
				}
				
			}	
			}else if(opcion.equals("editar")){
				
				BeanPersona persona = new BeanPersona();
				persona.setIdpersona(Integer.parseInt(request.getParameter("id")));
				persona.setNom(request.getParameter("txtnombres"));
				persona.setApePat(request.getParameter("txtapePat"));
				persona.setApeMat(request.getParameter("txtapeMat"));
				persona.setDni(request.getParameter("txtdni"));
				persona.setDomicilio(request.getParameter("txtdomicilio"));
				persona.setEmail(request.getParameter("txtemail"));
				persona.setSexo(request.getParameter("rdbsexo"));
				persona.setTelefono(request.getParameter("txttelefono"));
				persona.setFecNac(request.getParameter("txtfecha"));
	
				//Obtener valores para distrito
				BeanDistrito distrito = new BeanDistrito();
				distrito.setIddistrito(Integer.parseInt(request.getParameter("sel_distrito")));
			
				persona.setDistrito(distrito);

				BeanPaciente paciente=new BeanPaciente();
				paciente.setIdpaciente(Integer.parseInt(request.getParameter("id")));
				paciente.setTalla(Double.parseDouble(request.getParameter("txttalla")));
				paciente.setPeso(Double.parseDouble(request.getParameter("txtpeso")));
				paciente.setTipoSangre(request.getParameter("sel_GSangre"));
				paciente.setPersona(persona);
				
				//DAO
				I_Paciente pacienteDao = DaoFactory.getFactory(DaoFactory.MYSQL).getPacienteDao();
				boolean flag=pacienteDao.actualizarPaciente(paciente);
				
				if(flag){
					response.sendRedirect("paciente?opcion=listar");
				}else{
					request.setAttribute("mensaje", "No se pudo editar el paciente");
					request.getRequestDispatcher("mensaje.jsp").forward(request, response);
				}
			}
			
		}
		
	}


