package com.m2i.poe.media.rest;

import com.m2i.poe.media.Book;

import javax.ws.rs.core.*;

import javax.ws.rs.*;

@Path("/hello")
public class HelloWorldRest {

    @GET
    @Path("/world")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "Hello World!";
    }

    @GET
    @Path("/{person}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getName(@PathParam("person") String person) {
        return "Hello " + person + "!";
    }

    @GET
    @Path("/fb")
    @Produces(MediaType.TEXT_HTML)
    public String redirect() {
        return "<html>\n" +
                "  <head>\n" +
                "    <meta http-equiv=\"refresh\" content=\"0;URL=http://www.francescobianco.net\">\n" +
                "  </head>\n" +
                "  <body>\n" +
                "  </body>\n" +
                "</html>";
    }

    @GET
    @Path("/book")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook() {
        Book b = new Book();
        b.setTitle("JSON");
        b.setId(12);
        b.setPrice(99);
        return b;
    }
}