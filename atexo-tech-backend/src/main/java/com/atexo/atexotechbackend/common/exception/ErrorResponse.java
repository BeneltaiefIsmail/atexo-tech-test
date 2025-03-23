package com.atexo.atexotechbackend.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private URI uri ;
    private String title ;
    private String message ;
    private String details ;
    private URI instance ;
    private int status ;
    private Instant timestamp ;
    private String traceId ;



}
