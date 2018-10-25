package pe.qc.com.validator.presentacion.form;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class Reporte implements Serializable {

	private static final long serialVersionUID = 1L;
    private PieChartModel pieModel1;
    
 
    @PostConstruct
    public void init(int valor1, int valor2) {
        createPieModels(valor1,valor2);
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    
    
    private void createPieModels(int valor1, int valor2) {
        createPieModel1(valor1,valor2);
    }
 
    private void createPieModel1(int valor1, int valor2) {
        pieModel1 = new PieChartModel();
        pieModel1.set("Validaciones Correctas", valor1);
        pieModel1.set("Validaciones Incorrectas", valor2);
        
    }
}
