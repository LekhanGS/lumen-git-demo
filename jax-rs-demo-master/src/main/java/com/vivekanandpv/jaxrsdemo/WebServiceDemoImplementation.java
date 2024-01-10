package com.vivekanandpv.jaxrsdemo;

import jakarta.jws.WebService;
import jakarta.xml.ws.soap.Addressing;

@WebService(
        serviceName = "WebServiceDemo",
        endpointInterface = "com.vivekanandpv.jaxrsdemo.WebServiceDemo"
)
@Addressing(enabled=true, required=true)
public class WebServiceDemoImplementation implements WebServiceDemo {
    @Override
    public String getMessage(String name) {
        return String.format("Hello, %s, this is from JAX-WS", name);
    }
}
