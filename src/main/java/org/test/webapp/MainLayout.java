package org.test.webapp;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout{
	
	
	public MainLayout() {
		
		createHeader();
		
		createDrawer();
	}


	private void createHeader() {
		H1 logo = new H1("Gustavo");
		logo.addClassName("logo");
		
		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
		header.addClassName("header");
		header.setWidth("100%");
		header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
		
		addToNavbar(header);
	}
	
	private void createDrawer() {
		
		RouterLink listLink = new RouterLink("List", ListView.class);
		listLink.setHighlightCondition(HighlightConditions.sameLocation());
		
		RouterLink routerLink = new RouterLink("DashBoard", DashBoardView.class);
		routerLink.setHighlightCondition(HighlightConditions.sameLocation());
		
		addToDrawer(new VerticalLayout(
				listLink,
				routerLink)
			);
		
	}
	
	
}
