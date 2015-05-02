package pe.AA.com.Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.AA.com.Bean.BeanDetalleHClinico;
import pe.AA.com.Bean.BeanHistorialClinico;
import pe.AA.com.Bean.BeanOdontologo;
import pe.AA.com.Bean.BeanPaciente;
import pe.AA.com.Bean.BeanPersona;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.I_DetalleHClinico;
import pe.AA.com.Bean.BeanServicio;

/**
 * Servlet implementation class ServletHistorialClinico
 */
@WebServlet("/historialC")
public class ServletHistorialClinico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHistorialClinico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		if(opcion.equals("generar")){
			response.sendRedirect("generarHClinico.jsp");
		}else if(opcion.equals("mostrar")){
			response.sendRedirect("agregarDHClinico.jsp");
		}else if(opcion.equals("agregar")){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		if(opcion.equals("generar")){
			
			//Getting these bitches
			
			int idpaciente=Integer.parseInt(request.getParameter("idpaciente"));

			//Validating/Searching
			
			int valida=0;
			valida=DaoFactory.getFactory(DaoFactory.MYSQL).getHistorialClinicoDao().buscarHClinicoxid(idpaciente);
			if(valida!=0){
				//If the result of the search is possitive, then I'll display a message
				request.setAttribute("mensaje","El paciente ya posee un Historial Clinico");
				request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
				
			}else{//In other case
				
				String contra=request.getParameter("txaObservacion");
				String alergias=request.getParameter("txaAlergia");
				
				//Setting BeanPaciente
				
				BeanPaciente paciente = new BeanPaciente();
				paciente.setIdpaciente(idpaciente);
				
				//Setting BeanHistorialClinico
				
				BeanHistorialClinico objHC=new BeanHistorialClinico();
				objHC.setPaciente(paciente);
				objHC.setObservaciones(contra);
				objHC.setAlergias(alergias);

				//DAO
			
				int id=0;
				id=DaoFactory.getFactory(DaoFactory.MYSQL).getHistorialClinicoDao().generarHClinico(objHC);
			
				//Validating code
			
					if(id!=0){
						request.setAttribute("mensaje", "Historial Clinico generado satisfactoriamente");
						request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
					}else{
						request.setAttribute("mensaje", "Historial Clinico no generado, Intente de Nuevo");
						request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
					}
			
		}//Fin Else
		}else if(opcion.equals("mostrar")){
			
			int idodontologo=Integer.parseInt(request.getParameter("idodontologo"));
			int idpaciente=Integer.parseInt(request.getParameter("idpaciente"));
			
			//Valido que el paciente tenga historial clinico
			int rpta=DaoFactory.getFactory(DaoFactory.MYSQL).getHistorialClinicoDao().buscarHClinicoxid(idpaciente);
			if(rpta!=0){
				//Listo los servicios a añadir al historial, para así mostrarlos en la siguiente página
				List<BeanServicio> listaS = DaoFactory.getFactory(DaoFactory.MYSQL).getServicioDao().listar();
				//Mando como atributo la lista anterior
				request.setAttribute("listaS", listaS);
				
				//Recojo los datos del odontologo
				String odontologo = DaoFactory.getFactory(DaoFactory.MYSQL).getOdontologoDao().buscarOdontologo(idodontologo);
				BeanOdontologo objodontologo = new BeanOdontologo();
				objodontologo.setIdodontologo(idodontologo);
				objodontologo.setNombreOdontologo(odontologo);
				//Mando como atributo los datos del odontologo
				request.setAttribute("odontologoDHC", objodontologo);
				
				request.getRequestDispatcher("/añadirServicio.jsp").forward(request, response);
			}else{
				//Si no contase con Historial se envia el mensaje de error correspondiente
				request.setAttribute("mensaje", "El paciente no cuenta con Historial Clínico");
				request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
			}
		}
	}

}
