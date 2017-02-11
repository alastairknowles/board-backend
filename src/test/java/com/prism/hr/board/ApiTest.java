package com.prism.hr.board;

import com.prism.hr.board.rest.dto.RegistrationDTO;
import com.prism.hr.board.util.RegistrationUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ApplicationConfiguration.class, ApplicationTestConfiguration.class})
public class ApiTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ApplicationTestConfiguration applicationTestConfiguration;
    
    @Test
    public void shouldAcceptUserRegistration() throws Exception {
        RegistrationDTO registrationDTO = RegistrationUtil.getRegistrationDTO();
        
        String response = mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .param("givenName", registrationDTO.getGivenName())
                .param("surname", registrationDTO.getSurname())
                .param("email", registrationDTO.getEmail())
                .param("password", registrationDTO.getPassword())
                .accept(MediaType.TEXT_HTML)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        
        Map<String, RegistrationDTO> userCache = applicationTestConfiguration.getUserCache();
        Assert.assertEquals(1, userCache.size());
        
        RegistrationDTO registrationDTOProcessed = userCache.get(registrationDTO.getEmail());
        Assert.assertNotNull(registrationDTOProcessed);
    }
    
}
