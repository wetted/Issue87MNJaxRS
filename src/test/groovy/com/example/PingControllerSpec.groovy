package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class PingControllerSpec extends Specification {

    @Inject
    @Client("/")
    RxHttpClient client;

    void 'test jax-rs endpoint'() {
        when:
        HttpRequest<String> request = HttpRequest.GET('/v1/ping')
        String response = client.toBlocking().retrieve(request)

        then:
        response == "JAX-RS"
    }

    void 'test micronaut endpoint'() {
        when:
        HttpRequest<String> request = HttpRequest.GET('/v2/ping')
        String response = client.toBlocking().retrieve(request)

        then:
        response == "Micronaut"
    }
}
