package com.springboot.restaurantapi.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.restaurantapi.bundel.BundleMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ExceptionResponse {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd hh-mm-ss")
    private LocalDateTime localDateTime;
    private BundleMessage bundleMessage;
    public ExceptionResponse(HttpStatus status, BundleMessage bundleMessage) {
        localDateTime = LocalDateTime.now();
        this.status = status;
        this.bundleMessage = bundleMessage;
    }
}
