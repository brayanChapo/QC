package pe.qc.com.validator.presentacion.form;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.negocio.bo.BOTipoSolicitud;
import pe.qc.com.validator.negocio.bo.BOVob;

public class FInformacionTk {

	private String tk;
	private String sn;
	private String st;
	private String ss;
	private String inc;
	private String crq;
	private String tipoSolicitud;
	private String dominio;
	private String codigoApp;
	private String vob;

	public FInformacionTk(){
		
	}
	
	public void cargarInformacion(BOSolicitud boSolicitud, BODetalleSolicitud boDetalleSolicitud, BOAplicativo boAplicativo, BOTipoSolicitud boTipoSolicitud, BODominio boDominio, BOVob boVob){
		tk = boSolicitud.getTkSolicitud();
		crq = boSolicitud.getCrqSolicitud();
		sn = boDetalleSolicitud.getSnDetalleSolicitud();
		st = boDetalleSolicitud.getStDetalleSolicitud();
		ss = boDetalleSolicitud.getSsDetalleSolicitud();
		inc = boDetalleSolicitud.getIncDetalleSolicitud();
		tipoSolicitud = boTipoSolicitud.getNombreTipoSolicitud();
		codigoApp = boAplicativo.getNombreAplicativo();
		vob = boVob.getNombreVob();
		dominio = boDominio.getNombreDominio();
	}

	public String getTk() {
		return tk;
	}

	public void setTk(String tk) {
		this.tk = tk;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
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

	public String getInc() {
		return inc;
	}

	public void setInc(String inc) {
		this.inc = inc;
	}

	public String getCrq() {
		return crq;
	}

	public void setCrq(String crq) {
		this.crq = crq;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getCodigoApp() {
		return codigoApp;
	}

	public void setCodigoApp(String codigoApp) {
		this.codigoApp = codigoApp;
	}

	public String getVob() {
		return vob;
	}

	public void setVob(String vob) {
		this.vob = vob;
	}

//	public BOSolicitud getBoSolicitud() {
//		return boSolicitud;
//	}
//
//	public void setBoSolicitud(BOSolicitud boSolicitud) {
//		this.boSolicitud = boSolicitud;
//	}
//
//	public BODetalleSolicitud getBoDetalleSolicitud() {
//		return boDetalleSolicitud;
//	}
//
//	public void setBoDetalleSolicitud(BODetalleSolicitud boDetalleSolicitud) {
//		this.boDetalleSolicitud = boDetalleSolicitud;
//	}
	
}
