package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/v2")
public class PingControllerMicronaut {

    @Get("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Micronaut";
    }
}
