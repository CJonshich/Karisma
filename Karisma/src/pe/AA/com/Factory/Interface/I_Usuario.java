package pe.AA.com.Factory.Interface;

import pe.AA.com.Bean.BeanUsuario;

public interface I_Usuario {

	public BeanUsuario acceder(String usuario,String clave);
	public boolean validar(String usuario,String clave);
}
