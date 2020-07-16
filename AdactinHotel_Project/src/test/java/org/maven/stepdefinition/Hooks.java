package org.maven.stepdefinition;

import java.io.File;
import java.io.IOException;

import org.maven.test.BaseClass;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void beforeHooks() {
		Reporter.assignAuthor("Author - ABC");
	}
	
	
	@After
	public void afterHooks(Scenario sceanrario) throws IOException {
		
		if (sceanrario.isFailed()) {
			File takeScreenShot = BaseClass.takeScreenShot(sceanrario.getName().toString());
			Reporter.addScreenCaptureFromPath(takeScreenShot.getAbsolutePath());
		}

	}
}
