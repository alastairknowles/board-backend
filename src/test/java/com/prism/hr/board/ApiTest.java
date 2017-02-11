package com.prism.hr.board;

import com.prism.hr.board.rest.dto.RegistrationDTO;
import com.prism.hr.board.util.RegistrationUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {ApplicationConfiguration.class, ApplicationTestConfiguration.class})
public class ApiTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    public ApiTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
    
    @Test
    public void shouldAcceptUserRegistration() {
        RegistrationDTO registrationDTO = RegistrationUtil.getRegistrationDTO();
        String email = registrationDTO.getEmail();
    }
    
}
