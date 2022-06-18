package com.anthony.helpdeskserver.domain.helprequest.controller;


import com.anthony.helpdeskserver.domain.helprequest.exceptions.RequestNotFoundException;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;
import com.anthony.helpdeskserver.domain.helprequest.services.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("helpdesk")
public class HelpRequestController {

    private HelpRequestService helpRequestService;

    @Autowired
    public HelpRequestController(HelpRequestService helpRequestService) {
        this.helpRequestService = helpRequestService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> requestById(@PathVariable("id") Long id)  {
        try{
            HelpRequest request = helpRequestService.getById(id);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }catch (RequestNotFoundException ex){
            return new ResponseEntity<>("not found", HttpStatus.OK);
        }

    }

    @PostMapping("")
    public ResponseEntity<HelpRequest> createRequest(@RequestBody HelpRequest helpRequest){
        helpRequest = helpRequestService.create(helpRequest);
        return new ResponseEntity<>(helpRequest, HttpStatus.CREATED);
    }
}
