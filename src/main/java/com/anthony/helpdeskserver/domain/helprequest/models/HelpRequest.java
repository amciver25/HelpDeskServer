package com.anthony.helpdeskserver.domain.helprequest.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class HelpRequest {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private HelpType type;
    @NonNull
    private String description;
}


