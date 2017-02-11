package com.prism.hr.board.util;

import com.prism.hr.board.ApplicationTestConfiguration;
import com.prism.hr.board.rest.dto.RegistrationDTO;

public class RegistrationUtil {
    
    public static RegistrationDTO getRegistrationDTO() {
        Integer userIndex = ApplicationTestConfiguration.getUserIndex();
        String givenName = "GivenName_" + userIndex;
        String surname = "Surname_" + userIndex;
        
        return new RegistrationDTO()
                .setGivenName(givenName)
                .setSurname(surname)
                .setEmail(givenName + "." + surname + "@prism.board.com")
                .setPassword("password");
    }
    
}
