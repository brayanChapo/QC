package pe.qc.com.validator.presentacion.controlador;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOAplicativo;
import pe.qc.com.validator.negocio.bo.BODetalleSolicitud;
import pe.qc.com.validator.negocio.bo.BODominio;
import pe.qc.com.validator.negocio.bo.BOEstadoSolicitud;
import pe.qc.com.validator.negocio.bo.BOPlataforma;
import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.negocio.bo.BOTipoSolicitud;
import pe.qc.com.validator.negocio.bo.BOUsuario;
import pe.qc.com.validator.negocio.bo.BOVob;
import pe.qc.com.validator.negocio.servicio.NAplicativo;
import pe.qc.com.validator.negocio.servicio.NDetalleSolicitud;
import pe.qc.com.validator.negocio.servicio.NDominio;
import pe.qc.com.validator.negocio.servicio.NEstadoSolicitud;
import pe.qc.com.validator.negocio.servicio.NPlataforma;
import pe.qc.com.validator.negocio.servicio.NSolicitud;
import pe.qc.com.validator.negocio.servicio.NTipoSolicitud;
import pe.qc.com.validator.negocio.servicio.NUsuario;
import pe.qc.com.validator.negocio.servicio.NVob;
import pe.qc.com.validator.presentacion.form.FLogin;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;
import pe.qc.com.validator.util.excepcion.BusinessLogicException;
import pe.qc.com.validator.util.excepcion.DataAccessException;

@Controller("cRevisarSolicitud")
public class CRevisarSolicitud {
	
	@Autowired
	NVob nVob;
	@Autowired
	NDominio nDominio;
	@Autowired
	NAplicativo nAplicativo;
	@Autowired
	NTipoSolicitud nTipoSolicitud;
	@Autowired
	NPlataforma nPlataforma;
	@Autowired
	NDetalleSolicitud nDetalleSolicitud;
	@Autowired
	NSolicitud nSolicitud;
	@Autowired
	NUsuario nUsuario;
	@Autowired
	NEstadoSolicitud nEstadoSolicitud;
	
	BOUsuario boUsuario;
	BOVob boVob;
	BODominio boDominio;
	BOAplicativo boAplicativo;
	BOTipoSolicitud boTipoSolicitud;
	BOPlataforma boPlataforma;
	BOEstadoSolicitud boEstadoSolicitud;
	BOSolicitud boSolicitud;
	BODetalleSolicitud boDetalleSolicitud;
	
	
	List<Map<String, Object>> listaMapsolicitud;
	List<Map<String, Object>> listaMapsolicitudHistorica;
	List<Map<String, Object>> listaMapsolicitudReporteQC;
	
	Map<String, Object> Mapsolicitud;
	
	
	FLogin fLogin;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			fLogin = new FLogin();
			fLogin = (FLogin)SecurityContextHolder.getContext().getAuthentication().getDetails();
			listaMapsolicitud = nSolicitud.listarMapSolicitud();
//			listaMapsolicitudReporteQC = nSolicitud.listarMapSolicitudReporteQc();
//			System.out.println(listaMapsolicitudReporteQC);
			listaMapsolicitudReporteQC = new ArrayList<>();
		}catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void consultarDatos(Map<String, Object> mapSolicitudSeleccionado) {
		System.out.println(mapSolicitudSeleccionado.toString());
		Integer idSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idSolicitud")));
		Integer idDetalleSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idDetalleSolicitud")));
		Integer idTipoSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idTipoSolicitud")));
		Integer idCodigoApp = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idCodigoApp")));
		Integer idUsuario = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idUsuario")));
		Integer idPlataforma = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idPlataforma")));
		Integer idEstadoSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idEstadoSolicitud")));
		
		boUsuario = new BOUsuario();
		boAplicativo = new BOAplicativo();
		boVob = new BOVob();
		boDominio = new BODominio();
		boEstadoSolicitud = new BOEstadoSolicitud();
		boPlataforma = new BOPlataforma();
		boTipoSolicitud = new BOTipoSolicitud();
		boSolicitud = new BOSolicitud();
		boDetalleSolicitud = new BODetalleSolicitud();
		
		boUsuario = nUsuario.obtenerUsuarioXId(idUsuario);
		boAplicativo = nAplicativo.obtenerAplicativoXId(idCodigoApp);
		boVob = nVob.obtenerVobXId(boAplicativo.getIdVob());
		boDominio = nDominio.obtenerDominioXId(boAplicativo.getIdDominio());
		boEstadoSolicitud = nEstadoSolicitud.obtenerEstadoSolicitudXId(idEstadoSolicitud);
		boPlataforma = nPlataforma.obtenerPlataformaXId(idPlataforma);
		boTipoSolicitud = nTipoSolicitud.obtenerTipoSolicitudXId(idTipoSolicitud);
		boSolicitud = nSolicitud.obtenerSolicitudXId(idSolicitud);
		boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(idDetalleSolicitud);
		
		mostrarDialogConsultar();
		
		PaginaUtil.ejecutar("PF('wgvConsultarSolicitud').show()");
	}
	
	public void atenderSolicitud(Map<String, Object> mapSolicitudSeleccionado) {
		
		Integer idSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idSolicitud")));
		Integer idDetalleSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idDetalleSolicitud")));
		Integer idTipoSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idTipoSolicitud")));
		Integer idCodigoApp = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idCodigoApp")));
		Integer idUsuario = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idUsuario")));
		Integer idPlataforma = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idPlataforma")));
		Integer idEstadoSolicitud = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idEstadoSolicitud")));
		
		boUsuario = new BOUsuario();
		boAplicativo = new BOAplicativo();
		boVob = new BOVob();
		boDominio = new BODominio();
		boEstadoSolicitud = new BOEstadoSolicitud();
		boPlataforma = new BOPlataforma();
		boTipoSolicitud = new BOTipoSolicitud();
		boSolicitud = new BOSolicitud();
		boDetalleSolicitud = new BODetalleSolicitud();
		
		boUsuario = nUsuario.obtenerUsuarioXId(idUsuario);
		boAplicativo = nAplicativo.obtenerAplicativoXId(idCodigoApp);
		boVob = nVob.obtenerVobXId(boAplicativo.getIdVob());
		boDominio = nDominio.obtenerDominioXId(boAplicativo.getIdDominio());
		boEstadoSolicitud = nEstadoSolicitud.obtenerEstadoSolicitudXId(idEstadoSolicitud);
		boPlataforma = nPlataforma.obtenerPlataformaXId(idPlataforma);
		boTipoSolicitud = nTipoSolicitud.obtenerTipoSolicitudXId(idTipoSolicitud);
		boSolicitud = nSolicitud.obtenerSolicitudXId(idSolicitud);
		boDetalleSolicitud = nDetalleSolicitud.obtenerDetalleSolicitudXId(idDetalleSolicitud);
		
		mostrarDialogConsultar();
		obtenerSelectItemEstadoSolicitud();
		
		PaginaUtil.ejecutar("PF('wgvAtenderSolicitud').show()");
	}
	
	public void congelamientoAtendido() {
		try {
			Integer idHistorico = boSolicitud.getIdSolicitud();
			boSolicitud.setIdSolicitud(null);
			boSolicitud.setIdRevisor(nUsuario.obtenerUsuarioXCodigo(fLogin.getUsuario()).getIdUsuario());
			nSolicitud.modificarSolicitud(boSolicitud, idHistorico);
			listaMapsolicitud = nSolicitud.listarMapSolicitud();
			PaginaUtil.ejecutar("PF('wgvAtenderSolicitud').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Estado actualizado Correctamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
		
	}
	
	public void listarHistoricoSolicitud(Map<String, Object> mapSolicitudSeleccionado) {
		Integer idSolicitudHistorico = Integer.parseInt(String.valueOf(mapSolicitudSeleccionado.get("idSolicitud")));
		try {
			listaMapsolicitudHistorica = nSolicitud.listarMapHistoricaSolicitud(idSolicitudHistorico);
			PaginaUtil.ejecutar("PF('wgvHistoricoSolicitud').show()");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
		System.out.println(listaMapsolicitudHistorica.toString());
	}
	
	public void mostrarDialogConsultar(){
		if (boSolicitud.getIdTipoSolicitud() != 0) {
			if (boSolicitud.getIdTipoSolicitud() == 1) {
				boSolicitud.setMostrarSolNegocio(true);
				boSolicitud.setMostrarSolTecnico(true);
				boSolicitud.setMostrarSolServicio(false);
				boSolicitud.setMostrarIncidencia(false);
			}
			if (boSolicitud.getIdTipoSolicitud() == 2) {
				boSolicitud.setMostrarSolNegocio(false);
				boSolicitud.setMostrarSolTecnico(false);
				boSolicitud.setMostrarSolServicio(true);
				boSolicitud.setMostrarIncidencia(false);
			}
			if (boSolicitud.getIdTipoSolicitud() == 3) {
				boSolicitud.setMostrarSolNegocio(false);
				boSolicitud.setMostrarSolTecnico(false);
				boSolicitud.setMostrarSolServicio(false);
				boSolicitud.setMostrarIncidencia(true);
			}
		} 
	}
	
	public void generarExcel() throws IOException{
		listaMapsolicitudReporteQC = nSolicitud.listarMapSolicitudReporteQc();
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition", "attachment; filename=reporteCongelamientosQC.xls");
		response.setContentType("application/vnd.ms-excel");
		
		try {
			
			int cantidadInicial = 1;
			
			HSSFWorkbook wb = new HSSFWorkbook(); // crea libro de excel
			HSSFSheet sheet = wb.createSheet("Congelamientos"); // crea hoja
			
			HSSFRow row1 = sheet.createRow((short) 0); // crea fila1
			HSSFCell a1 = row1.createCell((short) 0); // crea A1
			HSSFCell b1 = row1.createCell((short) 1); // crea B1
			HSSFCell c1 = row1.createCell((short) 2); // crea C1
			HSSFCell d1 = row1.createCell((short) 3); // crea D1
			HSSFCell e1 = row1.createCell((short) 4); // crea E1
			HSSFCell f1 = row1.createCell((short) 5); // crea F1
			HSSFCell g1 = row1.createCell((short) 6); // crea G1
			HSSFCell h1 = row1.createCell((short) 7); // crea H1
			HSSFCell i1 = row1.createCell((short) 8); // crea I1
			HSSFCell j1 = row1.createCell((short) 9); // crea J1
			HSSFCell k1 = row1.createCell((short) 10); // crea K1
			HSSFCell l1 = row1.createCell((short) 11); // crea L1
			HSSFCell m1 = row1.createCell((short) 12); // crea M1
			
			a1.setCellValue("N° TK");
			b1.setCellValue("CRQ");
			c1.setCellValue("Codigo Aplicativo");
			d1.setCellValue("Vob");
			e1.setCellValue("Dominio");
			f1.setCellValue("Sol. Negocio");
			g1.setCellValue("Sol. Tecnico");
			h1.setCellValue("Sol. Servicio");
			i1.setCellValue("Inc.");
			j1.setCellValue("Criticidad");
			k1.setCellValue("Fecha de registro");
			l1.setCellValue("Fecha de conforme");
			m1.setCellValue("Usuario Revisor");
			
			HSSFCellStyle cellStyle = wb.createCellStyle();
			HSSFFont font = wb.createFont();
			font.setColor(HSSFColor.WHITE.index);
			font.setBold(true);
			font.setFontName("Arial");
			font.setFontHeightInPoints((short)12);
			cellStyle.setFont(font);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setTopBorderColor(HSSFColor.WHITE.index);
			cellStyle.setLeftBorderColor(HSSFColor.WHITE.index);
			cellStyle.setRightBorderColor(HSSFColor.WHITE.index);
			cellStyle.setBottomBorderColor(HSSFColor.WHITE.index);
			
			a1.setCellStyle(cellStyle);
			b1.setCellStyle(cellStyle);
			c1.setCellStyle(cellStyle);
			d1.setCellStyle(cellStyle);
			e1.setCellStyle(cellStyle);
			f1.setCellStyle(cellStyle);
			g1.setCellStyle(cellStyle);
			h1.setCellStyle(cellStyle);
			i1.setCellStyle(cellStyle);
			j1.setCellStyle(cellStyle);
			k1.setCellStyle(cellStyle);
			l1.setCellStyle(cellStyle);
			m1.setCellStyle(cellStyle);
			
			
			HSSFCellStyle cellStyle1 = wb.createCellStyle();
			HSSFFont font1 = wb.createFont();
			font1.setColor(HSSFColor.BLACK.index);
			font1.setBold(true);
			font1.setFontName("Arial");
			font1.setFontHeightInPoints((short)10);
			cellStyle1.setFont(font1);
			cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle1.setFillForegroundColor(HSSFColor.WHITE.index);
			cellStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cellStyle1.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle1.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle1.setTopBorderColor(HSSFColor.BLACK.index);
			cellStyle1.setLeftBorderColor(HSSFColor.BLACK.index);
			cellStyle1.setRightBorderColor(HSSFColor.BLACK.index);
			cellStyle1.setBottomBorderColor(HSSFColor.BLACK.index);
			
			
			for (Map<String, Object> map : listaMapsolicitudReporteQC) {
				HSSFRow row = sheet.createRow((short) cantidadInicial); // crea filan
				HSSFCell a=row.createCell((short) 0);
				sheet.autoSizeColumn((short) 0);
				a.setCellValue(String.valueOf(map.get("tkSolicitud")));
				a.setCellStyle(cellStyle1);// A2
				
				HSSFCell b=row.createCell((short) 1);
				sheet.autoSizeColumn((short) 1);
				b.setCellValue(String.valueOf(map.get("crqSolicitud")));
				b.setCellStyle(cellStyle1);// B2
				
				HSSFCell c=row.createCell((short) 2);
				sheet.autoSizeColumn((short) 2);
				c.setCellValue(String.valueOf(map.get("codigoAplicativo")));
				c.setCellStyle(cellStyle1);// C2
				
				HSSFCell d=row.createCell((short) 3);
				sheet.autoSizeColumn((short) 3);
				d.setCellValue(String.valueOf(map.get("nombreVob")));
				d.setCellStyle(cellStyle1);// D2
				
				HSSFCell e=row.createCell((short) 4);
				sheet.autoSizeColumn((short) 4);
				e.setCellValue(String.valueOf(map.get("nombreDominio")));
				e.setCellStyle(cellStyle1);// E2
				
				HSSFCell f=row.createCell((short) 5);
				sheet.autoSizeColumn((short) 5);
				f.setCellValue(String.valueOf(map.get("snDetalleSolicitud")));
				f.setCellStyle(cellStyle1);// F2
				
				HSSFCell g=row.createCell((short) 6);
				sheet.autoSizeColumn((short) 6);
				g.setCellValue(String.valueOf(map.get("stDetalleSolicitud")));
				g.setCellStyle(cellStyle1);// G2
				
				HSSFCell h=row.createCell((short) 7);
				sheet.autoSizeColumn((short) 7);
				h.setCellValue(String.valueOf(map.get("ssDetalleSolicitud")));
				h.setCellStyle(cellStyle1);// H2
				
				HSSFCell i=row.createCell((short) 8);
				sheet.autoSizeColumn((short) 8);
				i.setCellValue(String.valueOf(map.get("incDetalleSolicitud")));
				i.setCellStyle(cellStyle1);// I2
				
				HSSFCell j=row.createCell((short) 9);
				sheet.autoSizeColumn((short) 9);
				j.setCellValue(String.valueOf(map.get("criticidadSolicitud")));
				j.setCellStyle(cellStyle1);// J2
				
				HSSFCell k=row.createCell((short) 10);
				sheet.autoSizeColumn((short) 10);
				k.setCellValue(String.valueOf(map.get("fechaSolicitudRegistrada")));
				k.setCellStyle(cellStyle1);// K2
				
				HSSFCell l=row.createCell((short) 11);
				sheet.autoSizeColumn((short) 11);
				l.setCellValue(String.valueOf(map.get("fechaSolicitudFinalizada")));
				l.setCellStyle(cellStyle1);// L2
				
				HSSFCell m=row.createCell((short) 12);
				sheet.autoSizeColumn((short) 12);
				m.setCellValue(String.valueOf(map.get("nombreRevisor")));
				m.setCellStyle(cellStyle1);// M2
				
				cantidadInicial++;
			}
			
			OutputStream out = response.getOutputStream();
			wb.write(out);
			wb.close();
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		response.getOutputStream().flush();
		FacesContext.getCurrentInstance().responseComplete();
		response.getOutputStream().close();
		
	}
	
	
	public void obtenerSelectItemEstadoSolicitud() {
		boSolicitud.obtenerSelectItemsEstadoSolicitudRevisar(nEstadoSolicitud.listarEstadoSolicitud());
	}

	public FLogin getfLogin() {
		return fLogin;
	}

	public void setfLogin(FLogin fLogin) {
		this.fLogin = fLogin;
	}

	public List<Map<String, Object>> getListaMapsolicitud() {
		return listaMapsolicitud;
	}

	public void setListaMapsolicitud(List<Map<String, Object>> listaMapsolicitud) {
		this.listaMapsolicitud = listaMapsolicitud;
	}

	public Map<String, Object> getMapsolicitud() {
		return Mapsolicitud;
	}

	public void setMapsolicitud(Map<String, Object> mapsolicitud) {
		Mapsolicitud = mapsolicitud;
	}

	public BOUsuario getBoUsuario() {
		return boUsuario;
	}

	public void setBoUsuario(BOUsuario boUsuario) {
		this.boUsuario = boUsuario;
	}

	public BOVob getBoVob() {
		return boVob;
	}

	public void setBoVob(BOVob boVob) {
		this.boVob = boVob;
	}

	public BODominio getBoDominio() {
		return boDominio;
	}

	public void setBoDominio(BODominio boDominio) {
		this.boDominio = boDominio;
	}

	public BOAplicativo getBoAplicativo() {
		return boAplicativo;
	}

	public void setBoAplicativo(BOAplicativo boAplicativo) {
		this.boAplicativo = boAplicativo;
	}

	public BOTipoSolicitud getBoTipoSolicitud() {
		return boTipoSolicitud;
	}

	public void setBoTipoSolicitud(BOTipoSolicitud boTipoSolicitud) {
		this.boTipoSolicitud = boTipoSolicitud;
	}

	public BOPlataforma getBoPlataforma() {
		return boPlataforma;
	}

	public void setBoPlataforma(BOPlataforma boPlataforma) {
		this.boPlataforma = boPlataforma;
	}

	public BOEstadoSolicitud getBoEstadoSolicitud() {
		return boEstadoSolicitud;
	}

	public void setBoEstadoSolicitud(BOEstadoSolicitud boEstadoSolicitud) {
		this.boEstadoSolicitud = boEstadoSolicitud;
	}

	public BOSolicitud getBoSolicitud() {
		return boSolicitud;
	}

	public void setBoSolicitud(BOSolicitud boSolicitud) {
		this.boSolicitud = boSolicitud;
	}

	public BODetalleSolicitud getBoDetalleSolicitud() {
		return boDetalleSolicitud;
	}

	public void setBoDetalleSolicitud(BODetalleSolicitud boDetalleSolicitud) {
		this.boDetalleSolicitud = boDetalleSolicitud;
	}

	public List<Map<String, Object>> getListaMapsolicitudHistorica() {
		return listaMapsolicitudHistorica;
	}

	public void setListaMapsolicitudHistorica(List<Map<String, Object>> listaMapsolicitudHistorica) {
		this.listaMapsolicitudHistorica = listaMapsolicitudHistorica;
	}

	public List<Map<String, Object>> getListaMapsolicitudReporteQC() {
		return listaMapsolicitudReporteQC;
	}

	public void setListaMapsolicitudReporteQC(List<Map<String, Object>> listaMapsolicitudReporteQC) {
		this.listaMapsolicitudReporteQC = listaMapsolicitudReporteQC;
	}
	
}
