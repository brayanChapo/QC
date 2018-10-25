package pe.qc.com.validator.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.qc.com.validator.util.Constantes;

public class FDatosMis implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String tkMis;
	private String snMIS;
	private String stMIS;
	private String ssMIS;
	private String codMIS;
	private String tipoCambio;
	private int cantTot;
	private int cantVal;
	private int cantValCor;
	private int cantValInc;
	private List<FValidacion> listaValidacion;
	private FValidacion fValidacion;
	
	private boolean mostrarTk;
	private boolean mostrarSn;
	private boolean mostrarSs;
	private boolean mostrarSt;
	private boolean mostrarCodMis;
	private boolean mostrarTipoCambio;
	private boolean mostrarPanel;
	
	
	public FDatosMis() {

	}

	public void calcularCantidadValidaciones() {
		mostrarPanel=false;
		cantTot = 6;
		int cant = 0;
		mostrarTk =false;
		mostrarSn =false;
		mostrarSs =false;
		mostrarSt =false;
		mostrarCodMis=false;
		mostrarTipoCambio=false;
		if (tkMis != null) {
			cant++;
			mostrarTk =true;
		}
		if (snMIS != null) {
			cant++;
			mostrarSn =true;
		}
		if (stMIS != null) {
			cant++;
			mostrarSt =true;
		}
		if (ssMIS != null) {
			cant++;
			mostrarSs =true;
		}
		if (codMIS != null) {
			cant++;
			mostrarCodMis=true;
		}
		if (tipoCambio != null) {
			cant++;
			mostrarTipoCambio=true;
		}
		cantVal = cant;
		System.out.println("CAntidad de validaciones: " + cantVal);
	}

	public void validarInformacionTK(FInformacionTk fInformacionTk){
		int cantC =0;
		int cantI =0;
		listaValidacion=new ArrayList<FValidacion>();
		if(tkMis != null){
			fValidacion = new FValidacion();
			fValidacion.setValidacion(Constantes.VALIDACION_TK);
			if(tkMis.equals(fInformacionTk.getTk())){
				fValidacion.setEstado(Constantes.VALIDACION_OK);
				fValidacion.setComentario(Constantes.VALIDACION_OK);
				cantC++;
			}else{
				fValidacion.setEstado(Constantes.VALIDACION_ERROR);
				fValidacion.setComentario(Constantes.VALIDACION_TK_INCORRECTO);
				cantI++;
			}
			listaValidacion.add(fValidacion);
		}
		if(snMIS != null){
			fValidacion = new FValidacion();
			fValidacion.setValidacion(Constantes.VALIDACION_SN);
			if(snMIS.equals(fInformacionTk.getSn())){
				fValidacion.setEstado(Constantes.VALIDACION_OK);
				fValidacion.setComentario(Constantes.VALIDACION_OK);
				cantC++;
			}else{
				fValidacion.setEstado(Constantes.VALIDACION_ERROR);
				fValidacion.setComentario(Constantes.VALIDACION_SN_INCORRECTO);
				cantI++;
			}
			listaValidacion.add(fValidacion);
		}
		if(stMIS != null){
			fValidacion = new FValidacion();
			fValidacion.setValidacion(Constantes.VALIDACION_ST);
			if(stMIS.equals(fInformacionTk.getSt())){
				fValidacion.setEstado(Constantes.VALIDACION_OK);
				fValidacion.setComentario(Constantes.VALIDACION_OK);
				cantC++;
			}else{
				fValidacion.setEstado(Constantes.VALIDACION_ERROR);
				fValidacion.setComentario(Constantes.VALIDACION_ST_INCORRECTO);
				cantI++;
			}
			listaValidacion.add(fValidacion);
		}
		if(ssMIS != null){
			fValidacion = new FValidacion();
			fValidacion.setValidacion(Constantes.VALIDACION_SS);
			if(ssMIS.equals(fInformacionTk.getSs())){
				fValidacion.setEstado(Constantes.VALIDACION_OK);
				fValidacion.setComentario(Constantes.VALIDACION_OK);
				cantC++;
			}else{
				fValidacion.setEstado(Constantes.VALIDACION_ERROR);
				fValidacion.setComentario(Constantes.VALIDACION_SS_INCORRECTO);
				cantI++;
			}
			listaValidacion.add(fValidacion);
		}
		if(codMIS != null){
			fValidacion = new FValidacion();
			fValidacion.setValidacion(Constantes.VALIDACION_COD);
			if(codMIS.equals(fInformacionTk.getCodigoApp())){
				fValidacion.setEstado(Constantes.VALIDACION_OK);
				fValidacion.setComentario(Constantes.VALIDACION_OK);
				cantC++;
			}else{
				fValidacion.setEstado(Constantes.VALIDACION_ERROR);
				fValidacion.setComentario(Constantes.VALIDACION_COD_INCORRECTO);
				cantI++;
			}
			listaValidacion.add(fValidacion);
		}
		if(tipoCambio != null){
			fValidacion = new FValidacion();
			fValidacion.setValidacion(Constantes.VALIDACION_TIPO_CAMBIO);
			if(tipoCambio.equals(fInformacionTk.getTipoSolicitud())){
				fValidacion.setEstado(Constantes.VALIDACION_OK);
				fValidacion.setComentario(Constantes.VALIDACION_OK);
				cantC++;
			}else{
				fValidacion.setEstado(Constantes.VALIDACION_ERROR);
				fValidacion.setComentario(Constantes.VALIDACION_TIPO_CAMBIO_INCORRECTO);
				cantI++;
			}
			listaValidacion.add(fValidacion);
		}
		cantValCor = cantC;
		cantValInc = cantI;
	}

	public String getTkMis() {
		return tkMis;
	}

	public void setTkMis(String tkMis) {
		this.tkMis = tkMis;
	}

	public String getSnMIS() {
		return snMIS;
	}

	public void setSnMIS(String snMIS) {
		this.snMIS = snMIS;
	}

	public String getStMIS() {
		return stMIS;
	}

	public void setStMIS(String stMIS) {
		this.stMIS = stMIS;
	}

	public String getSsMIS() {
		return ssMIS;
	}

	public void setSsMIS(String ssMIS) {
		this.ssMIS = ssMIS;
	}

	public String getCodMIS() {
		return codMIS;
	}

	public void setCodMIS(String codMIS) {
		this.codMIS = codMIS;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public int getCantTot() {
		return cantTot;
	}

	public void setCantTot(int cantTot) {
		this.cantTot = cantTot;
	}

	public int getCantVal() {
		return cantVal;
	}

	public void setCantVal(int cantVal) {
		this.cantVal = cantVal;
	}

	public int getCantValCor() {
		return cantValCor;
	}

	public void setCantValCor(int cantValCor) {
		this.cantValCor = cantValCor;
	}

	public int getCantValInc() {
		return cantValInc;
	}

	public void setCantValInc(int cantValInc) {
		this.cantValInc = cantValInc;
	}

	public List<FValidacion> getListaValidacion() {
		return listaValidacion;
	}

	public void setListaValidacion(List<FValidacion> listaValidacion) {
		this.listaValidacion = listaValidacion;
	}

	public FValidacion getfValidacion() {
		return fValidacion;
	}

	public void setfValidacion(FValidacion fValidacion) {
		this.fValidacion = fValidacion;
	}

	public boolean isMostrarTk() {
		return mostrarTk;
	}

	public void setMostrarTk(boolean mostrarTk) {
		this.mostrarTk = mostrarTk;
	}

	public boolean isMostrarSn() {
		return mostrarSn;
	}

	public void setMostrarSn(boolean mostrarSn) {
		this.mostrarSn = mostrarSn;
	}

	public boolean isMostrarSs() {
		return mostrarSs;
	}

	public void setMostrarSs(boolean mostrarSs) {
		this.mostrarSs = mostrarSs;
	}

	public boolean isMostrarSt() {
		return mostrarSt;
	}

	public void setMostrarSt(boolean mostrarSt) {
		this.mostrarSt = mostrarSt;
	}

	public boolean isMostrarCodMis() {
		return mostrarCodMis;
	}

	public void setMostrarCodMis(boolean mostrarCodMis) {
		this.mostrarCodMis = mostrarCodMis;
	}

	public boolean isMostrarTipoCambio() {
		return mostrarTipoCambio;
	}

	public void setMostrarTipoCambio(boolean mostrarTipoCambio) {
		this.mostrarTipoCambio = mostrarTipoCambio;
	}
	
	public boolean isMostrarPanel() {
		return mostrarPanel;
	}

	public void setMostrarPanel(boolean mostrarPanel) {
		this.mostrarPanel = mostrarPanel;
	}

	@Override
	public String toString() {
		return "FDatosMis [tkMis=" + tkMis + ", snMIS=" + snMIS + ", stMIS=" + stMIS + ", ssMIS=" + ssMIS + ", codMIS="
				+ codMIS + ", tipoCambio=" + tipoCambio + ", cantTot=" + cantTot + ", cantVal=" + cantVal
				+ ", cantValCor=" + cantValCor + ", cantValInc=" + cantValInc + "]";
	}
}
