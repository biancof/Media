package com.m2i.poe.media.rest;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.m2i.poe.media.Author;
import com.m2i.poe.media.Book;
import com.m2i.poe.media.BookSqlRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/book")
public class OldBookRest {

    private BookSqlRepository bsr = new BookSqlRepository();

    private Book createNewBook(String name,
                              String surname,
                              int id,
                              String title,
                              double price){
        Book b = new Book(id, title, price);
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(1, "" + name, "" + surname));
        b.setAuthorList(authorList);
        return b;
    }

    @GET
    @Path("/{name}/{surname}/{id}/{title}/{price}")
    @Produces(MediaType.TEXT_HTML)
    public String showNewBook(@PathParam("name") String name,
                              @PathParam("surname") String surname,
                              @PathParam("id") int id,
                              @PathParam("title") String title,
                              @PathParam("price") double price){
        Book b = createNewBook(name, surname, id, title, price);
        return "<h1>Book # " + b.getId() + ", " + b.getAuthorList().get(0).getFirstName() +
                " " + b.getAuthorList().get(0).getLastName() +
                ", <i>" + b.getTitle() +
                "</i>, " + b.getNetPrice() + " Euro</h1>";
    }

    @DELETE
    @Path("/del/{id}")
    public String deleteBook(@PathParam("id") int id){
        try {
            Book b = bsr.getById(id);
            bsr.remove(b);
        } catch(SQLException e){
            e.getMessage();
        }
        return "Book # " + id + " removed";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getById(@PathParam("id") int id){
        String res = "";
        try {
            bsr.load("jdbc:postgresql://localhost:5432/postgres");
            res = this.bsr.getById(id).toString();
        } catch(SQLException e){
            e.getMessage();
        } catch(ClassNotFoundException e){
            e.getMessage();
        } catch(IOException e){
            e.getMessage();
        } catch(Exception e){
        }
        return res;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll(){
        String res = "";
        try {
            bsr.load("jdbc:postgresql://localhost:5432/postgres");

            for(Book b : this.bsr.getAll()){
                res += b.toString() + "\n";
            }
        } catch(SQLException e){
            e.getMessage();
        } catch(ClassNotFoundException e){
            e.getMessage();
        } catch(IOException e){
            e.getMessage();
        }
        return res;
    }


}
