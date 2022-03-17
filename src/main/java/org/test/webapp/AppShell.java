package org.test.webapp;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.server.PWA;


@PWA(name = "Cool Vaadin App", shortName = "my-app")
public class AppShell implements AppShellConfigurator {

	  @Override
	  public void configurePage(AppShellSettings settings) {
	    settings.setViewport("width=device-width, initial-scale=1");
	    settings.setPageTitle("A cool vaadin app");
	    settings.setBodySize("100vw", "100vh");
	    settings.addMetaTag("author", "bunny");
	    settings.addFavIcon("icon", "icons/icon-192.png", "192x192");
	    settings.addLink("shortcut icon", "icons/favicon.ico");

//	    settings.addInlineFromFile(
//	            TargetElement.BODY,
//	            Position.APPEND,
//	            "custom.html",
//	            Wrapping.AUTOMATIC);
//	    settings.addInlineWithContents(Position.PREPEND,
//	            "console.log(\"foo\");", Wrapping.JAVASCRIPT);
//
//	    settings.getLoadingIndicatorConfiguration()
//	            .ifPresent(indicator -> indicator.setApplyDefaultTheme(false));
//	    settings.getLoadingIndicatorConfiguration()
//	            .ifPresent(indicator -> indicator.setSecondDelay(700000));
//	    settings.getPushConfiguration()
//	            .ifPresent(push -> push.setPushMode(PushMode.AUTOMATIC));
//	    settings.getReconnectDialogConfiguration()
//	            .ifPresent(dialog -> dialog.setDialogModal(true));
	  }
	}
