package pe.qc.com.validator.presentacion.form;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class FReporteTareas {
	
	public void generarExcel(List<Map<String, Object>> listaMapReporte) throws IOException{
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition", "attachment; filename=reporteAlumno.xls");
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
			h1.setCellValue("Tipo de Requerimiento");
			i1.setCellValue("Etapa donde se debio detectar el rechazo");
			j1.setCellValue("Equipo que genero el rechazo");
			k1.setCellValue("Fecha de registro");
			
			HSSFCellStyle cellStyle = wb.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
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
			
			for (Map<String, Object> map : listaMapReporte) {
				HSSFRow row = sheet.createRow((short) cantidadInicial); // crea filan
				row.createCell((short) 0).setCellValue(String.valueOf(map.get("nombreTarea"))); // A2
				row.createCell((short) 1).setCellValue(String.valueOf(map.get("tkSolicitud"))); // B2
				row.createCell((short) 2).setCellValue(String.valueOf(map.get("crqTarea"))); // C2
				row.createCell((short) 3).setCellValue(String.valueOf(map.get("codAplicativo"))); // D2
				row.createCell((short) 4).setCellValue(String.valueOf(map.get("nombreDominio"))); // E2
				row.createCell((short) 5).setCellValue(String.valueOf(map.get("descripcionTarea"))); // F2
				row.createCell((short) 6).setCellValue(String.valueOf(map.get("woTarea"))); // G2
				row.createCell((short) 7).setCellValue(String.valueOf(map.get("nombreTipoTarea"))); // H2
				row.createCell((short) 8).setCellValue(String.valueOf(map.get("nombreEtapaTarea"))); // I2
				row.createCell((short) 9).setCellValue(String.valueOf(map.get("nombreEquipoTarea"))); // J2
				row.createCell((short) 10).setCellValue(String.valueOf(map.get("fechaTarea"))); // K2
				cantidadInicial++;
			}
			
			OutputStream out = response.getOutputStream();
			wb.write(out);
			
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		response.getOutputStream().flush();
		FacesContext.getCurrentInstance().responseComplete();
		
	}
	
}
