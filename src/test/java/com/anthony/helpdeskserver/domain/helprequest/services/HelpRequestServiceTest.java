package com.anthony.helpdeskserver.domain.helprequest.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
//Sending in the instructions on how to create the class
@ExtendWith(SpringExtension.class)
public class HelpRequestServiceTest {

    @Autowired
    //The Spring framework
    private HelpRequestService helpRequestService;




}
