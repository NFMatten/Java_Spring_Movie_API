package com.dcc.movie_api.controller;


import com.dcc.movie_api.data.Movie;
import com.dcc.movie_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> findAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie findMovieById(@PathVariable Integer id){
        return movieService.getById(id);
    }

    @GetMapping("/findByGenre/{genre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> findMovieByGenre(@PathVariable String genre){
        return movieService.getByGenre(genre);
    }

    @GetMapping("/findByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> findMovieByName(@PathVariable String name){
        return movieService.getByName(name);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieById(@PathVariable Integer id){
        movieService.deleteMovieById(id);
    }

    @PutMapping("/updateMovieById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie updateMovieById(@RequestBody Movie movie, @PathVariable Integer id){
        return movieService.updateMovieById(movie, id);
    }

    @PutMapping("/updateMovieByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Movie updateMovieByName(@RequestBody Movie movie, @PathVariable String name){
        return movieService.updateMovieByName(movie, name);
    }
}
