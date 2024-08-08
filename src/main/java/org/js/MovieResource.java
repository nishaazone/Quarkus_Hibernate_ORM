package org.js;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Movie;

import java.net.URI;
import java.util.List;

@Path("/movies")
public class MovieResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
       List<Movie> movies =  Movie.listAll();
       return Response.ok(movies).build();
   }

   @GET
   @Path("{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getById(@PathParam("id") Long id){
       return Movie.findByIdOptional(id)
               .map(movie -> Response.ok(movie).build())
               .orElse(Response.status(Response.Status.NOT_FOUND).build());
   }

    @GET
    @Path("country/{country}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCountry(@PathParam("country") String country){
     List<Movie> moviesCountry = Movie.list("SELECT m FROM Movie m WHERE m.country = ?1 ORDER BY id DESC", country);
     return Response.ok(moviesCountry).build();
   }

    @GET
    @Path("title/{title}")
    public Response getByTitle(@PathParam("title") String title){
        return Movie.find("title", title)
                .singleResultOptional()
                .map(movie -> Response.ok(movie).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Movie movie){
        Movie.persist(movie);
        if(movie.isPersistent()){
            return Response.created(URI.create("/movies" + movie.id)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id){
        boolean deleted = Movie.deleteById(id);
        if(deleted){
            return Response.noContent().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Movie movie) {
        Movie existingMovie = Movie.findById(id);
        if (existingMovie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        existingMovie.title = movie.title;
        existingMovie.description = movie.description;
        existingMovie.director = movie.director;
        existingMovie.country = movie.country;

        existingMovie.persist();

        return Response.ok(existingMovie).build();
    }


}
