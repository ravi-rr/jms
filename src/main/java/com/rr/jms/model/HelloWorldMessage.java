package com.rr.jms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {

    // adding serialVersionUID is a good practice, as per the docs in Serializable.
    // selected the random number suggested by the IDE
    static final long serialVersionUID = 3518307562323624417L;

    private UUID id;
    private String message;
}
