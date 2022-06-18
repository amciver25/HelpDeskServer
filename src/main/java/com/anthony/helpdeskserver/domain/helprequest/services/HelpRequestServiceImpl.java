package com.anthony.helpdeskserver.domain.helprequest.services;

import com.anthony.helpdeskserver.domain.helprequest.exceptions.RequestNotFoundException;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;
import com.anthony.helpdeskserver.domain.helprequest.repos.HelpRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelpRequestServiceImpl implements HelpRequestService{

    private HelpRequestRepo helpRequestRepo;

    @Autowired
    public HelpRequestServiceImpl(HelpRequestRepo helpRequestRepo) {
        this.helpRequestRepo = helpRequestRepo;
    }


    public HelpRequest create(HelpRequest helpRequest) {
        return helpRequestRepo.save(helpRequest);
    }

    public HelpRequest getById(Long id) throws RequestNotFoundException {
        Optional<HelpRequest> optional = helpRequestRepo.findById(id);
        if(optional.isEmpty())
            throw new RequestNotFoundException("Id not found");
        return optional.get();
    }

    public List<HelpRequest> getAll() {
        return helpRequestRepo.findAll();
    }

    public HelpRequest update(HelpRequest helpRequest) throws RequestNotFoundException {
        Long id = helpRequest.getId();
        getById(id);
        return helpRequestRepo.save(helpRequest);
    }

    public void delete(Long id) throws RequestNotFoundException {
        HelpRequest helpRequest = getById(id);
        helpRequestRepo.delete(helpRequest);
    }
}
