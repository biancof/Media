package com.m2i.poe.media.rest;

import com.m2i.poe.media.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.*;

@Path("/bookrest")
public class BookRest {

    private BookJPARepository repository = new BookJPARepository();

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getById(@PathParam("id") int id) throws SQLException {
        return repository.getById(id);
    }

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() throws SQLException {
        return repository.getAll();
    }

    @GET
    @Path("title/{str}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getByTitle(@PathParam("str") String str) throws SQLException{
        return repository.getByTitle(str);
    }

    @GET
    @Path("price/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getByPrice(@PathParam("price") double price) throws SQLException {
        return repository.getByPrice(price);
    }

    @GET
    @Path("publisher/{publisher}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getByPublisher(@PathParam("publisher") String publisher) throws SQLException {
        return repository.getByPublisher(publisher);
    }

    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book add(Book b)throws SQLException{
        repository.add(b);
        return b;
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Book book) throws SQLException {
        Book b = repository.getById(book.getId());
        if (b == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        repository.update(b);
        return Response.ok().build();
    }

    @DELETE
    @Path("/id/{id}/del")
    public Response delete(@PathParam("id") int id) throws SQLException {
        Book b = repository.getById(id);
        if (b == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        repository.remove(b);
        return Response.ok().build();
    }






}
