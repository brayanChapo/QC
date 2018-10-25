package springdb;

import org.primefaces.model.chart.PieChartModel;

public class Bean {
	private PieChartModel pieModel1;
	
	public Bean() {
		
	}
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    
    public void createPieModels() {
        createPieModel1();
    }
 
    public void createPieModel1() {
        pieModel1 = new PieChartModel();
     
        pieModel1.set("Brand 1", 540);
        pieModel1.set("Brand 2", 325);
        pieModel1.set("Brand 3", 702);
        pieModel1.set("Brand 4", 421);
          
    }
     
   
}
