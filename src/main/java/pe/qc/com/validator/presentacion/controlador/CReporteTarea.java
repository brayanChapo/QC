package pe.qc.com.validator.presentacion.controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.qc.com.validator.negocio.bo.BOTarea;
import pe.qc.com.validator.negocio.servicio.NTarea;
import pe.qc.com.validator.presentacion.form.FReporteTareas;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.PaginaUtil;

@Controller("cReporteTarea")

public class CReporteTarea {

	@Autowired
	NTarea nTarea;
	
	BOTarea boTarea;
	
	private Date fechaInicio;
	private Date fechaFin;
	
	FReporteTareas fReporteTareas;
	
	List<Map<String, Object>> listaMapTareaxFecha;
	Map<String, Object> mapTarea;
	List<Map<String, Object>> listaMapReporte;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listaMapTareaxFecha = new ArrayList<>();
			fechaFin = null;
			fechaInicio = null;
			boTarea = new BOTarea();
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}	
	}
	
	public void buscarTarea() {
		listaMapTareaxFecha = nTarea.listarMapTareaxFecha(fechaInicio, fechaFin);
	}
	
	public void iniciarDescargarCorreo(int idTarea) {
		boTarea = nTarea.obtenerTareaXId(idTarea);
	}
	
	public void generarExcel() throws IOException{	
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition", "attachment; filename=\"reporteTarea.xls\"");
		response.setContentType("application/vnd.ms-excel");
		
		try {
			
			int cantidadInicial = 1;
			
			HSSFWorkbook wb = new HSSFWorkbook(); // crea libro de excel
			HSSFSheet sheet = wb.createSheet("Tarea Rechazadas"); // crea hoja
			
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
			
			a1.setCellValue("Tarea");
			b1.setCellValue("N° TK");
			c1.setCellValue("CRQ");
			d1.setCellValue("Codigo Aplicativo");
			e1.setCellValue("Dominio");
			f1.setCellValue("Descripcion");
			g1.setCellValue("WO");
			h1.setCellValue("Tipo de Tarea");
			i1.setCellValue("Etapa donde se debio detectar el rechazo");
			j1.setCellValue("Equipo que genero el rechazo");
			k1.setCellValue("Fecha de registro");
			
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
			
			
			for (Map<String, Object> map : listaMapTareaxFecha) {
				HSSFRow row = sheet.createRow((short) cantidadInicial); // crea filan
				HSSFCell a=row.createCell((short) 0);
				sheet.autoSizeColumn((short) 0);
				a.setCellValue(String.valueOf(map.get("nombreTarea")));
				a.setCellStyle(cellStyle1);// A2
				
				HSSFCell b=row.createCell((short) 1);
				sheet.autoSizeColumn((short) 1);
				b.setCellValue(String.valueOf(map.get("tkSolicitud")));
				b.setCellStyle(cellStyle1);// B2
				
				HSSFCell c=row.createCell((short) 2);
				sheet.autoSizeColumn((short) 2);
				c.setCellValue(String.valueOf(map.get("crqTarea")));
				c.setCellStyle(cellStyle1);// C2
				
				HSSFCell d=row.createCell((short) 3);
				sheet.autoSizeColumn((short) 3);
				d.setCellValue(String.valueOf(map.get("codAplicativo")));
				d.setCellStyle(cellStyle1);// D2
				
				HSSFCell e=row.createCell((short) 4);
				sheet.autoSizeColumn((short) 4);
				e.setCellValue(String.valueOf(map.get("nombreDominio")));
				e.setCellStyle(cellStyle1);// E2
				
				HSSFCell f=row.createCell((short) 5);
				sheet.autoSizeColumn((short) 5);
				f.setCellValue(String.valueOf(map.get("descripcionTarea")));
				f.setCellStyle(cellStyle1);// F2
				
				HSSFCell g=row.createCell((short) 6);
				sheet.autoSizeColumn((short) 6);
				g.setCellValue(String.valueOf(map.get("woTarea")));
				g.setCellStyle(cellStyle1);// G2
				
				HSSFCell h=row.createCell((short) 7);
				sheet.autoSizeColumn((short) 7);
				h.setCellValue(String.valueOf(map.get("nombreTipoTarea")));
				h.setCellStyle(cellStyle1);// H2
				
				HSSFCell i=row.createCell((short) 8);
				sheet.autoSizeColumn((short) 8);
				i.setCellValue(String.valueOf(map.get("nombreEtapaTarea")));
				i.setCellStyle(cellStyle1);// I2
				
				HSSFCell j=row.createCell((short) 9);
				sheet.autoSizeColumn((short) 9);
				j.setCellValue(String.valueOf(map.get("nombreEquipoTarea")));
				j.setCellStyle(cellStyle1);// J2
				
				HSSFCell k=row.createCell((short) 10);
				sheet.autoSizeColumn((short) 10);
				k.setCellValue(String.valueOf(map.get("fechaTarea")));
				k.setCellStyle(cellStyle1);// K2
				
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
	

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Map<String, Object>> getListaMapTareaxFecha() {
		return listaMapTareaxFecha;
	}

	public void setListaMapTareaxFecha(List<Map<String, Object>> listaMapTareaxFecha) {
		this.listaMapTareaxFecha = listaMapTareaxFecha;
	}

	public Map<String, Object> getMapTarea() {
		return mapTarea;
	}

	public void setMapTarea(Map<String, Object> mapTarea) {
		this.mapTarea = mapTarea;
	}

	public List<Map<String, Object>> getListaMapReporte() {
		return listaMapReporte;
	}

	public void setListaMapReporte(List<Map<String, Object>> listaMapReporte) {
		this.listaMapReporte = listaMapReporte;
	}

	public BOTarea getBoTarea() {
		return boTarea;
	}

	public void setBoTarea(BOTarea boTarea) {
		this.boTarea = boTarea;
	}

	public FReporteTareas getfReporteTareas() {
		return fReporteTareas;
	}

	public void setfReporteTareas(FReporteTareas fReporteTareas) {
		this.fReporteTareas = fReporteTareas;
	}
	
	
}
