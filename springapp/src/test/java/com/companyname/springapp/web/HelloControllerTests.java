package com.companyname.springapp.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTests {
	
	@Test
	public void testHandleRequestView() throws Exception {
		HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        // Que vsean iguales
        assertEquals("hello", modelAndView.getViewName());
        // Que no sea nulo
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        // Que no sea nulo
        assertNotNull(nowValue);
	}
}
