package pe.qc.com.validator.presentacion.form;

import java.util.ArrayList;
import java.util.List;


public class FSubTabla {
	private String rutaW;
	private String descripcionW;
	private String permisosNTFSW;
	private String permisosExtendidosW;
	
	private String rutaAL;
	private String descripcionAL;
	private String permisosExtendidosAIX;
	
	private String rutaFisicaShyNF;
	private String nombreCarpetaComShyNF;
	private String descripcionShyNF;
	private String usuarioAutorizadorShyNF;
	private String permisosShyNF;
	
	private String usuarioCL;
	private String decripcionCL;
	private String grupoPrimarioCL;
	private String grupoSecundarioCL;
	private String sentenciaCL;
	
	private String puertoApliBL;
	private String persistenciaBL;
	private String tiempoPersBL;
	private String nombreDes;
	private String direccionDes;
	private String urlDes;
	private List<FBalanceCarga> listaBalanceDes;
	private String nombreCer;
	private String direccionCer;
	private String urlCer;
	private List<FBalanceCarga> listaBalanceCer;
	private String nombrePro;
	private String direccionPro;
	private String urlPro;
	private List<FBalanceCarga> listaBalancePro;
	
	private String numeroOT;
	private String ordenTrabajoOT;
	private String descripcionOT;
	private String tipoOrdenOT;
	
	private String ambienteEjecutarBD;
	private String baseDatosBD;
	private String usuarioBD;
	private String comandoBD;
	private String adecuacionesBD;
	
	private String nombreWwbSite;
	private String accionWebSite;
	
	private String nombreAppPol;
	private String accionAppPol;
	
	private String comandoIIS;
	
	private String nombreServicioIA;
	private String usuarioIA;
	private String estadoIA;
	
	private String nombreServicioRA;
	private String accionRA;
		
	public FSubTabla(){
		listaBalanceCer = new ArrayList<>();
		listaBalanceDes = new ArrayList<>();
		listaBalancePro = new ArrayList<>();
	}

	public String getRutaW() {
		return rutaW;
	}

	public void setRutaW(String rutaW) {
		this.rutaW = rutaW;
	}

	public String getDescripcionW() {
		return descripcionW;
	}

	public void setDescripcionW(String descripcionW) {
		this.descripcionW = descripcionW;
	}

	public String getPermisosNTFSW() {
		return permisosNTFSW;
	}

	public void setPermisosNTFSW(String permisosNTFSW) {
		this.permisosNTFSW = permisosNTFSW;
	}

	public String getPermisosExtendidosW() {
		return permisosExtendidosW;
	}

	public void setPermisosExtendidosW(String permisosExtendidosW) {
		this.permisosExtendidosW = permisosExtendidosW;
	}

	public String getRutaAL() {
		return rutaAL;
	}

	public void setRutaAL(String rutaAL) {
		this.rutaAL = rutaAL;
	}

	public String getDescripcionAL() {
		return descripcionAL;
	}

	public void setDescripcionAL(String descripcionAL) {
		this.descripcionAL = descripcionAL;
	}

	public String getPermisosExtendidosAIX() {
		return permisosExtendidosAIX;
	}

	public void setPermisosExtendidosAIX(String permisosExtendidosAIX) {
		this.permisosExtendidosAIX = permisosExtendidosAIX;
	}

	public String getRutaFisicaShyNF() {
		return rutaFisicaShyNF;
	}

	public void setRutaFisicaShyNF(String rutaFisicaShyNF) {
		this.rutaFisicaShyNF = rutaFisicaShyNF;
	}

	public String getNombreCarpetaComShyNF() {
		return nombreCarpetaComShyNF;
	}

	public void setNombreCarpetaComShyNF(String nombreCarpetaComShyNF) {
		this.nombreCarpetaComShyNF = nombreCarpetaComShyNF;
	}

	public String getDescripcionShyNF() {
		return descripcionShyNF;
	}

	public void setDescripcionShyNF(String descripcionShyNF) {
		this.descripcionShyNF = descripcionShyNF;
	}

	public String getUsuarioAutorizadorShyNF() {
		return usuarioAutorizadorShyNF;
	}

	public void setUsuarioAutorizadorShyNF(String usuarioAutorizadorShyNF) {
		this.usuarioAutorizadorShyNF = usuarioAutorizadorShyNF;
	}

	public String getPermisosShyNF() {
		return permisosShyNF;
	}

	public void setPermisosShyNF(String permisosShyNF) {
		this.permisosShyNF = permisosShyNF;
	}

	public String getUsuarioCL() {
		return usuarioCL;
	}

	public void setUsuarioCL(String usuarioCL) {
		this.usuarioCL = usuarioCL;
	}

	public String getDecripcionCL() {
		return decripcionCL;
	}

	public void setDecripcionCL(String decripcionCL) {
		this.decripcionCL = decripcionCL;
	}

	public String getGrupoPrimarioCL() {
		return grupoPrimarioCL;
	}

	public void setGrupoPrimarioCL(String grupoPrimarioCL) {
		this.grupoPrimarioCL = grupoPrimarioCL;
	}

	public String getGrupoSecundarioCL() {
		return grupoSecundarioCL;
	}

	public void setGrupoSecundarioCL(String grupoSecundarioCL) {
		this.grupoSecundarioCL = grupoSecundarioCL;
	}

	public String getSentenciaCL() {
		return sentenciaCL;
	}

	public void setSentenciaCL(String sentenciaCL) {
		this.sentenciaCL = sentenciaCL;
	}

	public String getPuertoApliBL() {
		return puertoApliBL;
	}

	public void setPuertoApliBL(String puertoApliBL) {
		this.puertoApliBL = puertoApliBL;
	}

	public String getPersistenciaBL() {
		return persistenciaBL;
	}

	public void setPersistenciaBL(String persistenciaBL) {
		this.persistenciaBL = persistenciaBL;
	}

	public String getTiempoPersBL() {
		return tiempoPersBL;
	}

	public void setTiempoPersBL(String tiempoPersBL) {
		this.tiempoPersBL = tiempoPersBL;
	}

	public String getNombreDes() {
		return nombreDes;
	}

	public void setNombreDes(String nombreDes) {
		this.nombreDes = nombreDes;
	}

	public String getDireccionDes() {
		return direccionDes;
	}

	public void setDireccionDes(String direccionDes) {
		this.direccionDes = direccionDes;
	}

	public String getUrlDes() {
		return urlDes;
	}

	public void setUrlDes(String urlDes) {
		this.urlDes = urlDes;
	}

	public List<FBalanceCarga> getListaBalanceDes() {
		return listaBalanceDes;
	}

	public void setListaBalanceDes(List<FBalanceCarga> listaBalanceDes) {
		this.listaBalanceDes = listaBalanceDes;
	}

	public String getNombreCer() {
		return nombreCer;
	}

	public void setNombreCer(String nombreCer) {
		this.nombreCer = nombreCer;
	}

	public String getDireccionCer() {
		return direccionCer;
	}

	public void setDireccionCer(String direccionCer) {
		this.direccionCer = direccionCer;
	}

	public String getUrlCer() {
		return urlCer;
	}

	public void setUrlCer(String urlCer) {
		this.urlCer = urlCer;
	}

	public List<FBalanceCarga> getListaBalanceCer() {
		return listaBalanceCer;
	}

	public void setListaBalanceCer(List<FBalanceCarga> listaBalanceCer) {
		this.listaBalanceCer = listaBalanceCer;
	}

	public String getNombrePro() {
		return nombrePro;
	}

	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}

	public String getDireccionPro() {
		return direccionPro;
	}

	public void setDireccionPro(String direccionPro) {
		this.direccionPro = direccionPro;
	}

	public String getUrlPro() {
		return urlPro;
	}

	public void setUrlPro(String urlPro) {
		this.urlPro = urlPro;
	}

	public List<FBalanceCarga> getListaBalancePro() {
		return listaBalancePro;
	}

	public void setListaBalancePro(List<FBalanceCarga> listaBalancePro) {
		this.listaBalancePro = listaBalancePro;
	}

	public String getNumeroOT() {
		return numeroOT;
	}

	public void setNumeroOT(String numeroOT) {
		this.numeroOT = numeroOT;
	}

	public String getOrdenTrabajoOT() {
		return ordenTrabajoOT;
	}

	public void setOrdenTrabajoOT(String ordenTrabajoOT) {
		this.ordenTrabajoOT = ordenTrabajoOT;
	}

	public String getDescripcionOT() {
		return descripcionOT;
	}

	public void setDescripcionOT(String descripcionOT) {
		this.descripcionOT = descripcionOT;
	}

	public String getTipoOrdenOT() {
		return tipoOrdenOT;
	}

	public void setTipoOrdenOT(String tipoOrdenOT) {
		this.tipoOrdenOT = tipoOrdenOT;
	}

	public String getAmbienteEjecutarBD() {
		return ambienteEjecutarBD;
	}

	public void setAmbienteEjecutarBD(String ambienteEjecutarBD) {
		this.ambienteEjecutarBD = ambienteEjecutarBD;
	}

	public String getBaseDatosBD() {
		return baseDatosBD;
	}

	public void setBaseDatosBD(String baseDatosBD) {
		this.baseDatosBD = baseDatosBD;
	}

	public String getUsuarioBD() {
		return usuarioBD;
	}

	public void setUsuarioBD(String usuarioBD) {
		this.usuarioBD = usuarioBD;
	}

	public String getComandoBD() {
		return comandoBD;
	}

	public void setComandoBD(String comandoBD) {
		this.comandoBD = comandoBD;
	}

	public String getAdecuacionesBD() {
		return adecuacionesBD;
	}

	public void setAdecuacionesBD(String adecuacionesBD) {
		this.adecuacionesBD = adecuacionesBD;
	}

	public String getNombreWwbSite() {
		return nombreWwbSite;
	}

	public void setNombreWwbSite(String nombreWwbSite) {
		this.nombreWwbSite = nombreWwbSite;
	}

	public String getAccionWebSite() {
		return accionWebSite;
	}

	public void setAccionWebSite(String accionWebSite) {
		this.accionWebSite = accionWebSite;
	}

	public String getNombreAppPol() {
		return nombreAppPol;
	}

	public void setNombreAppPol(String nombreAppPol) {
		this.nombreAppPol = nombreAppPol;
	}

	public String getAccionAppPol() {
		return accionAppPol;
	}

	public void setAccionAppPol(String accionAppPol) {
		this.accionAppPol = accionAppPol;
	}

	public String getComandoIIS() {
		return comandoIIS;
	}

	public void setComandoIIS(String comandoIIS) {
		this.comandoIIS = comandoIIS;
	}

	public String getNombreServicioIA() {
		return nombreServicioIA;
	}

	public void setNombreServicioIA(String nombreServicioIA) {
		this.nombreServicioIA = nombreServicioIA;
	}

	public String getUsuarioIA() {
		return usuarioIA;
	}

	public void setUsuarioIA(String usuarioIA) {
		this.usuarioIA = usuarioIA;
	}

	public String getEstadoIA() {
		return estadoIA;
	}

	public void setEstadoIA(String estadoIA) {
		this.estadoIA = estadoIA;
	}

	public String getNombreServicioRA() {
		return nombreServicioRA;
	}

	public void setNombreServicioRA(String nombreServicioRA) {
		this.nombreServicioRA = nombreServicioRA;
	}

	public String getAccionRA() {
		return accionRA;
	}

	public void setAccionRA(String accionRA) {
		this.accionRA = accionRA;
	}

	@Override
	public String toString() {
		return "\n                                                                           FSubTabla [rutaW=" + rutaW + ", descripcionW=" + descripcionW + ", permisosNTFSW=" + permisosNTFSW
				+ ", permisosExtendidosW=" + permisosExtendidosW + ", rutaAL=" + rutaAL + ", descripcionAL="
				+ descripcionAL + ", permisosExtendidosAIX=" + permisosExtendidosAIX + ", rutaFisicaShyNF="
				+ rutaFisicaShyNF + ", nombreCarpetaComShyNF=" + nombreCarpetaComShyNF + ", descripcionShyNF="
				+ descripcionShyNF + ", usuarioAutorizadorShyNF=" + usuarioAutorizadorShyNF + ", permisosShyNF="
				+ permisosShyNF + ", usuarioCL=" + usuarioCL + ", decripcionCL=" + decripcionCL + ", grupoPrimarioCL="
				+ grupoPrimarioCL + ", grupoSecundarioCL=" + grupoSecundarioCL + ", sentenciaCL=" + sentenciaCL
				+ ", puertoApliBL=" + puertoApliBL + ", persistenciaBL=" + persistenciaBL + ", tiempoPersBL="
				+ tiempoPersBL + ", nombreDes=" + nombreDes + ", direccionDes=" + direccionDes + ", urlDes=" + urlDes
				+ ", listaBalanceDes=" + listaBalanceDes + ", nombreCer=" + nombreCer + ", direccionCer=" + direccionCer
				+ ", urlCer=" + urlCer + ", listaBalanceCer=" + listaBalanceCer + ", nombrePro=" + nombrePro
				+ ", direccionPro=" + direccionPro + ", urlPro=" + urlPro + ", listaBalancePro=" + listaBalancePro
				+ ", numeroOT=" + numeroOT + ", ordenTrabajoOT=" + ordenTrabajoOT + ", descripcionOT=" + descripcionOT
				+ ", tipoOrdenOT=" + tipoOrdenOT + ", ambienteEjecutarBD=" + ambienteEjecutarBD + ", baseDatosBD="
				+ baseDatosBD + ", usuarioBD=" + usuarioBD + ", comandoBD=" + comandoBD + ", adecuacionesBD="
				+ adecuacionesBD + ", nombreWwbSite=" + nombreWwbSite
				+ ", accionWebSite=" + accionWebSite + ", nombreAppPol="
				+ nombreAppPol + ", accionAppPol=" + accionAppPol + ", comandoIIS=" + comandoIIS + ", nombreServicioIA="
				+ nombreServicioIA + ", usuarioIA=" + usuarioIA + ", estadoIA=" + estadoIA + ", nombreServicioRA=" + nombreServicioRA + ", accionRA=" + accionRA + "]";
	}
}
