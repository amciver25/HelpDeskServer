package com.anthony.helpdeskserver.domain.helprequest.repos;

import com.anthony.helpdeskserver.domain.helprequest.models.HelpRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelpRequestRepo extends JpaRepository<HelpRequest, Long> {

}
