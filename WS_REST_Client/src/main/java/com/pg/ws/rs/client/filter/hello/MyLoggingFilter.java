package com.pg.ws.rs.client.filter.hello;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class MyLoggingFilter implements ClientRequestFilter, 
        ClientResponseFilter {
    static final Logger logger = Logger.getLogger("MyLoggingFilter");

    // implement the ClientRequestFilter.filter method
    @Override
    public void filter(ClientRequestContext requestContext) 
            throws IOException {
        System.out.println("loggg");
    }

    // implement the ClientResponseFilter.filter method
    @Override
    public void filter(ClientRequestContext requestContext, 
           ClientResponseContext responseContext) throws IOException {
    	System.out.println("loggg");
    }
}
