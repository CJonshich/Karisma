package pe.AA.com.Factory.Interface;

import pe.AA.com.Bean.BeanPersona;

public interface I_Persona {

	public boolean validarPersona(String dni);
	
	public int insert(BeanPersona objpersona);
}
