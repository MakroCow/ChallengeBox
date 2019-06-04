package controller;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) {
        String originHeader = containerRequestContext.getHeaderString("Origin");
        if(originHeader != null && originHeader.equals("http://localhost:8100")) {
            containerResponseContext.getHeaders().add("Access-Control-Allow-Origin", originHeader);
            containerResponseContext.getHeaders().add("Access-Control-Allow-Credentials","true");
            containerResponseContext.getHeaders().add("Access-Control-Allow-Headers","origin, content-type, accept, authorization");
            containerResponseContext.getHeaders().add("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD");
        }
    }
}