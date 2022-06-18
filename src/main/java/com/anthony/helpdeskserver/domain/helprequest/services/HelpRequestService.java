package com.anthony.helpdeskserver.domain.helprequest.services;

import com.anthony.helpdeskserver.domain.helprequest.exceptions.RequestNotFoundException;
import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;

import java.util.List;

public interface HelpRequestService {
    HelpRequest create(HelpRequest helpRequest);
    HelpRequest getById(Long id) throws RequestNotFoundException;
    List<HelpRequest> getAll();
    HelpRequest update(HelpRequest helpRequest) throws RequestNotFoundException;
    void delete(Long id) throws RequestNotFoundException;
}
