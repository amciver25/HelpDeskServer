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
@ExtendWith(SpringExtension.class)
public class HelpRequestServiceTest {

    @Autowired
    private HelpRequestService helpRequestService;

    @MockBean
    private HelpRequestRepo helpRequestRepo;

    private HelpRequest unsavedHelpRequest;
    private HelpRequest savedHelpRequest;

    @BeforeEach
    public void setUp(){
        unsavedHelpRequest = new HelpRequest("Anthony", "McIver", "anthony.am66@gmail.com", HelpType.PASSWORD, "Password reset");
        savedHelpRequest = new HelpRequest("Anthony", "McIver", "anthony.am66@gmail.com", HelpType.PASSWORD, "Password reset");
        savedHelpRequest.setId(1l);
    }

    @Test
    @DisplayName("Create Help Desk Request")
    public void createRequestTest01(){
        BDDMockito.doReturn(savedHelpRequest).when(helpRequestRepo).save(unsavedHelpRequest);
        HelpRequest expected = savedHelpRequest;
        HelpRequest actual = helpRequestRepo.save(unsavedHelpRequest);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get Help Request By Id - success")
    public void getHelpRequestById01() throws RequestNotFoundException {
        BDDMockito.doReturn(Optional.of(savedHelpRequest)).when(helpRequestRepo).findById(1l);
        HelpRequest expected = savedHelpRequest;
        HelpRequest actual = helpRequestService.getById(1l);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get Help Request By Id - failed")
    public void getHelpRequestById02() {
        BDDMockito.doReturn(Optional.empty()).when(helpRequestRepo).findById(1l);
        Assertions.assertThrows(RequestNotFoundException.class, ()-> {
            HelpRequest actual = helpRequestService.getById(1l);
        });
    }

    @Test
    @DisplayName("Update Request - success")
    public void updateTest01() throws RequestNotFoundException {
        HelpRequest updatedHelpRequest = new HelpRequest("Anthony", "Updated Lastname", "anthony.am66@gmail.com", HelpType.PASSWORD, "Password reset");
        updatedHelpRequest.setId(1l);
        BDDMockito.doReturn(Optional.of(savedHelpRequest)).when(helpRequestRepo).findById(1l);
        BDDMockito.doReturn(updatedHelpRequest).when(helpRequestRepo).save(savedHelpRequest);
        HelpRequest actual = helpRequestService.update(updatedHelpRequest);
        Assertions.assertEquals(updatedHelpRequest, actual);
    }
}
