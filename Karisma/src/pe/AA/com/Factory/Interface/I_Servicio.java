package pe.AA.com.Factory.Interface;
import java.util.List;
import pe.AA.com.Bean.*;

public interface I_Servicio {

	public List<BeanServicio> listar();
	public boolean eliminarServicio(int idservicio);
	public BeanServicio buscarxId(int id);
	public int agregar(BeanServicio servicio);
	public boolean editar(BeanServicio servicio);
}
