package org.atwjsw.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by wenda on 9/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {
    @Mock
    private RegistrationService registrationService;
    private RegistrationController controller;
    @Before
    public void setup(){
        controller = new RegistrationController();
        controller.setRegistrationService(registrationService);
    }
    @Test
    public void when_invalid_user_id_geneartes_error_message() {
        when(registrationService.hasError()).thenReturn("error");
        ModelMap model = new ModelMap();
        ModelAndView modelAndView = controller.onRegistration(model);
        String message = (String)modelAndView.getModel().get("message");
        assertNotNull(message);
        assertTrue(message.contains(RegistrationController.ERROR));
    }
    @Test
    public void when_valid_user_id_creates_user() throws Exception {
        when(registrationService.hasError()).thenReturn(null);
        ModelMap model = new ModelMap();
        ModelAndView modelAndView = controller.onRegistration(model);
        String message = (String)modelAndView.getModel().get("message");
        assertNotNull(message);
        assertTrue(message.contains(RegistrationController.SUCCESS));
    }
}
