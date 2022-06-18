package com.anthony.helpdeskserver.domain.helprequest.services;

import com.anthony.helpdeskserver.domain.helprequest.exceptions.RequestNotFoundException;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpType;
import com.anthony.helpdeskserver.domain.helprequest.repos.HelpRequestRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
//Sending in the instructions on how to create the class
@ExtendWith(SpringExtension.class)
public class HelpRequestServiceTest {

    @Autowired
    //The Spring framework
    private HelpRequestService helpRequestService;

/**Tests should be FIRST - Fast, Independent, Repeatable, Self Validating, Timely*/

    @MockBean
    //Whenever a request goes to the repo we are going to make a fake one.(Independent)
    private HelpRequestRepo helpRequestRepo;

    private HelpRequest request;

    @BeforeEach
    public void setUp(){
        request = new HelpRequest("Anthony", "McIver", "anthony.am66@gmail.com", HelpType.PASSWORD, "Password reset");
        request.setId(1L);

    }
    @Test
    @DisplayName("Test for getById")
    public void getByIdTest() throws RequestNotFoundException {
        //Behavior
        BDDMockito.doReturn(Optional.of(request)).when(helpRequestRepo).findById(1L);
        HelpRequest helpRequest = helpRequestService.getById(1L);
        Assertions.assertEquals(request, helpRequest);


    }
}
