package org.atwjsw.service;

import org.atwjsw.controller.RegistrationService;
import org.atwjsw.dao.RegistrationDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.atwjsw.controller.RegistrationService.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * Created by wenda on 9/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {
    private RegistrationService registrationService;
    @Mock
    private RegistrationDao registrationDao;

    @Before
    public void setup(){
        registrationService = new RegistrationService();
        registrationService.setRegistrationDao(registrationDao);
    }

    @Test
    public void when_empty_inputs_raises_error() {
        String error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(PLEASE_ENTER_USER_ID, error);
        registrationService.setUserId("john123");
        error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(PLEASE_ENTER_PASSWORD, error);
        registrationService.setPassword("Passw@rd");
        error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(PLEASE_ENTER_FIRST_NAME, error);
        registrationService.setFirstName("john");
        error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(PLEASE_ENTER_LAST_NAME, error);
        registrationService.setLastName("doe");
        error = registrationService.hasError();
        assertNull(error);
    }

    @Test
    public void when_name_contains_number_raises_error() {
        registrationService.setFirstName("john1");
        registrationService.setLastName("doe");
        registrationService.setUserId("john123");
        registrationService.setPassword("Passw@rd");
        String error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(NAME_CONTAINS_NUMBER, error);
    }

    @Test
    public void when_name_contains_special_chars_raises_error() {
        registrationService.setFirstName("john@");
        registrationService.setLastName("doe");
        registrationService.setUserId("john123");
        registrationService.setPassword("Passw@rd");
        String error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(NAME_CONTAINS_SPECIAL_CHAR, error);
    }

    @Test
    public void when_user_exists_raises_error(){
        when(registrationDao.isExistingUserId(anyString())).thenReturn(true);
        registrationService.setFirstName("john");
        registrationService.setLastName("doe");
        registrationService.setUserId("john123");
        registrationService.setPassword("Passw@rd");
        String error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(USER_ID_EXISTS, error);
    }

    @Test
    public void when_user_creation_fails_then_raises_error() {
        doThrow(new RuntimeException("save failed")).
                when(registrationDao).create(anyString(), anyString(),
                anyString(), anyString());
        registrationService.setFirstName("john");
        registrationService.setLastName("doe");
        registrationService.setUserId("john123");
        registrationService.setPassword("Passw@rd");
        String error = registrationService.hasError();
        assertNotNull(error);
        assertEquals(COULD_NOT_CREATE_USER, error);
    }

    @Test
    public void when_no_validation_error_then_creates_user(){
        registrationService.setFirstName("john");
        registrationService.setLastName("doe");
        registrationService.setUserId("john123");
        registrationService.setPassword("Passw@rd");
        assertNull(registrationService.hasError());
    }

}
