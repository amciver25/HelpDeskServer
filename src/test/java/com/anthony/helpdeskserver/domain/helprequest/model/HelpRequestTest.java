package com.anthony.helpdeskserver.domain.helprequest.model;

import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelpRequestTest {
    @Test
    public void constructorTest(){
        HelpRequest helpRequest = new HelpRequest("Anthony", "McIver", "anthony.am66@gmail.com", HelpType.PASSWORD, "Password reset");
        Assertions.assertEquals("anthony.am66@gmail.com", helpRequest.getEmail());
    }
}
