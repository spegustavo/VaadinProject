package org.test.webapp;

import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("DashBoard | Gustavo")
@Route(value = "dashboard", layout = MainLayout.class)
public class DashBoardView extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -418200390418119597L;
	private final CustomerService customerService;
	private final CompanyService companyService;
	
	
	public DashBoardView() {
		
		this.customerService = new CustomerService();
		this.companyService = new CompanyService();
		
		
//		addClassName("DashBoard view ");
		
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);

		add(getContactStats(), getCompaniesChart());
		
	}
	



	private Component getCompaniesChart() {
		Chart chart = new Chart(ChartType.PIE);
		
		DataSeries dataSeries = new DataSeries();
		Map<String, Integer> stats = companyService.getStats();
		stats.forEach((name, number) -> dataSeries.add( new DataSeriesItem(name , number)));
		
		chart.getConfiguration().setSeries(dataSeries);
		
		return chart;
	}



	private Span getContactStats() {
		
		Span stats = new Span("Marcas");
		stats.addClassName("Monster");
		
		return stats;
	}
	
}
	

