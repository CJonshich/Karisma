package pe.AA.com.Bean;


public class BeanCita {

	public BeanCita() {
		// TODO Auto-generated constructor stub
	}

	private int idcita;
	private String motivo;
	private String diagnostico;
	private String observacion;
	private String fecha;
	private String horaIni;
	private String horaFin;
	private String recomendacion;
	private String medicamento;
	private int idodontologo;
	private int idpaciente;
	private String estadoCita;
	
	//prueba con datos del paciente y odontologo
	
	private String nom;
	private String apePat;
	private String apeMat;
	private String dniPac;
	//
	private BeanPaciente paciente;
	private BeanOdontologo odontologo;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public String getDniPac() {
		return dniPac;
	}
	public void setDniPac(String dniPac) {
		this.dniPac = dniPac;
	}

	
	//
	
	public int getIdcita() {
		return idcita;
	}
	
	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getIdodontologo() {
		return idodontologo;
	}
	public void setIdodontologo(int idodontologo) {
		this.idodontologo = idodontologo;
	}
	public int getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}
	public String getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public String getEstadoCita() {
		return estadoCita;
	}
	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}
	public BeanOdontologo getOdontologo() {
		return odontologo;
	}
	public void setOdontologo(BeanOdontologo odontologo) {
		this.odontologo = odontologo;
	}
	public BeanPaciente getPaciente() {
		return paciente;
	}
	public void setPaciente(BeanPaciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	
}
