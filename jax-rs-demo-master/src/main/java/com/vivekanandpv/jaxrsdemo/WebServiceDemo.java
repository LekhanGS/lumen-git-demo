package com.vivekanandpv.jaxrsdemo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebServiceDemo {
    @WebMethod
    String getMessage(String name);
}
