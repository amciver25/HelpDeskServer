package com.anthony.helpdeskserver.domain.helprequest.services;

import com.anthony.helpdeskserver.domain.helprequest.exceptions.RequestNotFoundException;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;
import com.anthony.helpdeskserver.domain.helprequest.repos.HelpRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpRequestServiceImpl implements HelpRequestService{

    private HelpRequestRepo helpRequestRepo;

    @Autowired
    public HelpRequestServiceImpl(HelpRequestRepo helpRequestRepo) {
        this.helpRequestRepo = helpRequestRepo;
    }


    public HelpRequest create(HelpRequest helpRequest) {
        return null;
    }

    public HelpRequest getById(Long id) throws RequestNotFoundException {
        return null;
    }

    public List<HelpRequest> getAll() {
        return null;
    }

    public HelpRequest update(HelpRequest helpRequest) throws RequestNotFoundException {
        return null;
    }

    public void delete(Long id) throws RequestNotFoundException {

    }
}
