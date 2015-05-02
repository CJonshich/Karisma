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

import pe.AA.com.Bean.BeanCita;
import pe.AA.com.Bean.BeanOdontologo;
import pe.AA.com.Bean.BeanPaciente;
import pe.AA.com.Factory.DaoFactory;
import pe.AA.com.Factory.Interface.I_Cita;
import pe.AA.com.Factory.Interface.I_Odontologo;
import pe.AA.com.Factory.Interface.I_Paciente;

/**
 * Servlet implementation class ServletCita
 */
@WebServlet("/cita")
public class ServletCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCita() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		if(opcion.equalsIgnoreCase("agregar")){
			response.sendRedirect("generarCita.jsp");
		}else if (opcion.equals("actualizar")){
			response.sendRedirect("actualizarCita.jsp");
		}else if(opcion.equalsIgnoreCase("buscar")){
			//Buscar citas activas
			//Funciona 100%
			List<BeanCita> listaC = DaoFactory.getFactory(DaoFactory.MYSQL).getCitaDao().buscarCitasA();
			
			//Comprobar más de un elemento en la lista
			if(listaC.size()>0){
				//Creo variable que almacena temporalmente el valor del nombre del odontologo
				String odontologo="";
				//Lista que contendrá los nombres de los odontologos durante el for
				List<String> listaO=new ArrayList<String>();
				//Interfaz DAO
				I_Odontologo odontologoDao=DaoFactory.getFactory(DaoFactory.MYSQL).getOdontologoDao();
				//FOR
				for(int i=0;i<listaC.size();i++){
					odontologo="";
					odontologo=odontologoDao.buscarOdontologosxCita(listaC.get(i));
					listaO.add(odontologo);
				} //FIN FOR
				
				//Odontologo
				request.setAttribute("BCitaodontologo", listaO);
				//Mando atributos de la cita
				request.setAttribute("BCita", listaC);
				//Finalmente redirecciono al JSP que mostrará la busqueda
				request.getRequestDispatcher("buscarCita.jsp").forward(request, response);
			}else{
				request.setAttribute("mensaje", "No se encuentra citas activas en este momento");
				request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Según la opción enviada se procederá a utilizar ciertas funciones
		String opcion=request.getParameter("opcion");
		//Escoge función
		if(opcion.equalsIgnoreCase("registrar")){
			BeanCita objcita = new BeanCita();
			objcita.setIdpaciente(Integer.parseInt(request.getParameter("idpaciente")));
			objcita.setIdodontologo(Integer.parseInt(request.getParameter("idodontologo")));
			objcita.setMotivo(request.getParameter("txtmotivo"));
			objcita.setHoraIni(request.getParameter("tm_Hinicio"));
			objcita.setFecha(request.getParameter("txtfecha"));
			String estadoCita="A";
			objcita.setEstadoCita(estadoCita);
			//DAO
			I_Cita citaDao=DaoFactory.getFactory(DaoFactory.MYSQL).getCitaDao();
			
			//Devolución y muestra de mensajes de resultado
			int id=0;
			id=citaDao.registrarCita(objcita);
			if(id!=0){
				I_Odontologo odontologoDao=DaoFactory.getFactory(DaoFactory.MYSQL).getOdontologoDao();
				odontologoDao.actualizarEstado(objcita.getIdodontologo(),"O");
				request.setAttribute("mensaje", "Cita generada satisfactoriamente");
				request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
		
			}else{
				
				request.setAttribute("mensaje", "Cita no grabada, Intente de nuevo");
				request.getRequestDispatcher("mensaje.jsp").forward(request, response);
			}
			//Mostrar el codigo de cita a la consola
			System.out.println("Id de la Cita: "+id);
			
		}else if (opcion.equals("actualizar")){
			
			//Captura de datos
			int idcita=Integer.parseInt(request.getParameter("ncita"));
			String diagnostico=request.getParameter("txadiagnostico");
			String recomendacion = request.getParameter("txarecomendacion");
//			String hFin= request.getParameter("tm_Hfin");
			int idodontologo=Integer.parseInt(request.getParameter("idodontologo"));
			String estadoCita= "F";
			
			//Bean de Cita
			BeanCita objcita=new BeanCita();
			objcita.setIdcita(idcita);
			objcita.setDiagnostico(diagnostico);
//			objcita.setHoraFin(hFin);
			objcita.setRecomendacion(recomendacion);
			objcita.setEstadoCita(estadoCita);
			
			int rpta=-1;
			I_Cita citaDao=DaoFactory.getFactory(DaoFactory.MYSQL).getCitaDao();
			rpta=citaDao.actualizar(objcita);
				if(rpta!=-1){
					I_Odontologo odontologoDao=DaoFactory.getFactory(DaoFactory.MYSQL).getOdontologoDao();
					odontologoDao.actualizarEstado(idodontologo,"L");
					request.setAttribute("mensaje", "Cita actualizada satisfactoriamente");
					request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
				}else{
					request.setAttribute("mensaje", "Cita no actualizada, Intente de nuevo");
					request.getRequestDispatcher("mensaje.jsp").forward(request, response);
				}
				
		}else if(opcion.equals("buscar")){/**
			
			//Variable  de mensaje para retornos
			String mensaje="";
			
			//Buscar Cita
			List<BeanCita> listaC = DaoFactory.getFactory(DaoFactory.MYSQL).getCitaDao().buscarCitasA();
			
			//Comprobar que haya mas de un elemento en la lista.
			
			if(listaC.size()>0){
			
				
				//Recuperar datos de los odontologos
				//Creo objeto que almacenará los datos de cada recorrido por tupla para odontologo
				String odontologo="";
				//Creo array que contendrá todos los objetos almacenados durante el for
				List<String> listaO=new ArrayList<String>();
				//Interfaz DAO
				I_Odontologo odontologoDao=DaoFactory.getFactory(DaoFactory.MYSQL).getOdontologoDao();
				//Comienzo el for
				for(int i=0;i<listaC.size();i++){
					odontologo="";
					odontologo=odontologoDao.buscarOdontologosxCita(listaC.get(i));
					listaO.add(odontologo);
				}
				//Odontologo
				request.setAttribute("BCitaodontologo", listaO);
				//CITA
				//Mando atributos de la cita, para hacerlo sencillo mando los IDs en una lista en esta sentencia
				request.setAttribute("BCita", listaC);
				
				//Finalmente redirecciono al JSP que mostrará la busqueda
				request.getRequestDispatcher("buscarCita.jsp").forward(request, response);
				
			}else{
				mensaje="No se encuentra citas activas en este momento";
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/mensaje.jsp").forward(request, response);
			}
				
			**/
		}
		
	}

}
