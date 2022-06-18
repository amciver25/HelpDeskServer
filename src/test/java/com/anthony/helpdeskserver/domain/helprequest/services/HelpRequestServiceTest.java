package com.anthony.helpdeskserver.domain.helprequest.services;

import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpType;
import com.anthony.helpdeskserver.domain.helprequest.repos.HelpRequestRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class HelpRequestServiceTest {

    @Autowired
    private HelpRequestService helpRequestService;

    @MockBean
    private HelpRequestRepo helpRequestRepo;

    private HelpRequest helpRequest;

    @BeforeEach
    public void setUp(){
        helpRequest = new HelpRequest("Anthony", "McIver", "anthony.am66@gmail.com", HelpType.PASSWORD, "Password reset");
    }



}
