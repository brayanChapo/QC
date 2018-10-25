package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;
import java.util.List;

public class FArchivoMis {
	private String sn;
	private String codigoAplicativo;
	private String st;
	private String ss;
	private String tk;
	private String ep;
	private String cpt;
	private String opt;
	private final List<String> servidorProduccion;
	private final List<String> servidorCerticacion;
	private final ArrayList<String> servidoresConfiguracion;
	private final ArrayList<String> servidoresNombreBD;
	private final ArrayList<String> servidoresReversion;
	private final ArrayList<String> seccionesConfiguracion;
	private final ArrayList<String> seccionesConfiguracionDescripcion;
	private final ArrayList<String> tareasConfiguracion;
	private final ArrayList<String> tareasConfiguracionDescripcion;
	private final ArrayList<String> subtareasConfiguracionDescripcion;
	private final ArrayList<String> configuracionDepartamentosRealease;
	private final ArrayList<String> seccionesReversion;
	private final ArrayList<String> seccionesReversionDescripcion;
	private final ArrayList<String> tareasReversion;
	private final ArrayList<String> tareasReversionDescripcion;
	private ArrayList<FRutaMis> fRutasMis;
	
	public void setfRutasMis(FRutaMis  fRutasMis) {
		this.fRutasMis.add(fRutasMis);
	}

	public ArrayList<FRutaMis> getfRutasMis() {
		return fRutasMis;
	}

	public FArchivoMis() {
		this.servidorProduccion = new ArrayList<>();
		this.servidorCerticacion = new ArrayList<>();
		this.servidoresConfiguracion = new ArrayList<>();
		this.servidoresReversion = new ArrayList<>();
		this.seccionesConfiguracion = new ArrayList<>();
		this.seccionesConfiguracionDescripcion = new ArrayList<>();
		this.tareasConfiguracion = new ArrayList<>();
		this.tareasConfiguracionDescripcion = new ArrayList<>();
		this.subtareasConfiguracionDescripcion = new ArrayList<>();
		this.configuracionDepartamentosRealease = new ArrayList<>();
		this.seccionesReversion = new ArrayList<>();
		this.seccionesReversionDescripcion = new ArrayList<>();
		this.tareasReversion = new ArrayList<>();
		this.tareasReversionDescripcion = new ArrayList<>();
		this.servidoresNombreBD = new ArrayList<>();
		this.fRutasMis = new ArrayList<>();
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCodigoAplicativo() {
		return codigoAplicativo;
	}

	public void setCodigoAplicativo(String codigoAplicativo) {
		this.codigoAplicativo = codigoAplicativo;
	}

	public ArrayList<String> getServidoresNombreBD() {
		return servidoresNombreBD;
	}

	public void setServidoresNombreBD(String servidoresNombreBD) {
		this.servidoresNombreBD.add(servidoresNombreBD);
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getTk() {
		return tk;
	}

	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getEp() {
		return ep;
	}

	public void setEp(String ep) {
		this.ep = ep;
	}

	public String getCpt() {
		return cpt;
	}

	public void setCpt(String cpt) {
		this.cpt = cpt;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public List<String> getServidorProduccion() {
		return servidorProduccion;
	}

	public List<String> getServidorCerticacion() {
		return servidorCerticacion;
	}

	public void setServidorProduccion(String servidorProduccion) {

		this.servidorProduccion.add(servidorProduccion);

	}

	public void setServidorCerticacion(String ServidorCerticacion) {

		this.servidorCerticacion.add(ServidorCerticacion);
	}

	public ArrayList<String> getServidoresConfiguracion() {
		return servidoresConfiguracion;
	}

	public void setServidoresConfiguracion(String servidoresConfiguracion) {
		this.servidoresConfiguracion.add(servidoresConfiguracion);
	}

	public ArrayList<String> getServidoresReversion() {
		return servidoresReversion;
	}

	public void setServidoresReversion(String ServidoresReversion) {
		this.servidoresReversion.add(ServidoresReversion);
	}

	// segunda validación
	public ArrayList<String> getSeccionesConfiguracion() {
		return seccionesConfiguracion;
	}

	public void setSeccionesConfiguracion(String seccionesConfiguracion) {
		this.seccionesConfiguracion.add(seccionesConfiguracion);
	}

	public ArrayList<String> getSeccionesConfiguracionDescripcion() {
		return seccionesConfiguracionDescripcion;
	}

	public void setSeccionesConfiguracionDescripcion(String seccionesConfiguracionDescripcion) {
		this.seccionesConfiguracionDescripcion.add(seccionesConfiguracionDescripcion);
	}

	public ArrayList<String> getTareasConfiguracion() {
		return tareasConfiguracion;
	}

	public void setTareasConfiguracion(String tareasConfiguracion) {
		this.tareasConfiguracion.add(tareasConfiguracion);
	}

	public ArrayList<String> getTareasConfiguracionDescripcion() {
		return tareasConfiguracionDescripcion;
	}

	public void setTareasConfiguracionDescripcion(String tareasConfiguracionDescripcion) {
		this.tareasConfiguracionDescripcion.add(tareasConfiguracionDescripcion);
	}

	public ArrayList<String> getSubtareasConfiguracionDescripcion() {
		return subtareasConfiguracionDescripcion;
	}

	public void setSubtareasConfiguracionDescripcion(String subtareasConfiguracionDescripcion) {
		this.subtareasConfiguracionDescripcion.add(subtareasConfiguracionDescripcion);
	}

	public ArrayList<String> getConfiguracionDepartamentosRealease() {
		return configuracionDepartamentosRealease;
	}

	public void setConfiguracionDepartamentosRealease(String configuracionDepartamentosRealease) {
		this.configuracionDepartamentosRealease.add(configuracionDepartamentosRealease);
	}

	public ArrayList<String> getSeccionesReversion() {
		return seccionesReversion;
	}

	public void setSeccionesReversion(String seccionesReversion) {
		this.seccionesReversion.add(seccionesReversion);
	}

	public ArrayList<String> getSeccionesReversionDescripcion() {
		return seccionesReversionDescripcion;
	}

	public void setSeccionesReversionDescripcion(String seccionesReversionDescripcion) {
		this.seccionesReversionDescripcion.add(seccionesReversionDescripcion);
	}

	public ArrayList<String> getTareasReversion() {
		return tareasReversion;
	}

	public void setTareasReversion(String tareasReversion) {
		this.tareasReversion.add(tareasReversion);
	}

	public ArrayList<String> getTareasReversionDescripcion() {
		return tareasReversionDescripcion;
	}

	public void setTareasReversionDescripcion(String tareasReversionDescripcion) {
		this.tareasReversionDescripcion.add(tareasReversionDescripcion);
	}

	@Override
	public String toString() {
		return "FArchivoMis [sn=" + sn + ", codigoAplicativo=" + codigoAplicativo + ", st=" + st + ", ss=" + ss
				+ ", tk=" + tk + ", ep=" + ep + ", cpt=" + cpt + ", opt=" + opt + ", servidorProduccion="
				+ servidorProduccion + ", servidorCerticacion=" + servidorCerticacion + ", servidoresConfiguracion="
				+ servidoresConfiguracion + ", servidoresNombreBD=" + servidoresNombreBD + ", servidoresReversion="
				+ servidoresReversion + ", seccionesConfiguracion=" + seccionesConfiguracion
				+ ", seccionesConfiguracionDescripcion=" + seccionesConfiguracionDescripcion + ", tareasConfiguracion="
				+ tareasConfiguracion + ", tareasConfiguracionDescripcion=" + tareasConfiguracionDescripcion
				+ ", subtareasConfiguracionDescripcion=" + subtareasConfiguracionDescripcion
				+ ", configuracionDepartamentosRealease=" + configuracionDepartamentosRealease + ", seccionesReversion="
				+ seccionesReversion + ", seccionesReversionDescripcion=" + seccionesReversionDescripcion
				+ ", tareasReversion=" + tareasReversion + ", tareasReversionDescripcion=" + tareasReversionDescripcion
				+ ", fRutasMis=" + fRutasMis + "]";
	}

}
