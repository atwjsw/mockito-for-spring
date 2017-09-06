package org.atwjsw.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by wenda on 9/1/2017.
 */
public class HRControllerTest2 {

    @Test
    public void getEmployee() throws Exception {
        HRController controller = new HRController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/employees/1").
                accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.salary").value(100.00))
                .andExpect(jsonPath("$.id").value(1));
    }
}
