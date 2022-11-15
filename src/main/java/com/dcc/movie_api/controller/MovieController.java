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
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie findMovieById(@PathVariable Integer id){
        return movieService.getById(id);
    }

    @GetMapping("/findByGenre/{genre}")
    public List<Movie> findMovieByGenre(@PathVariable String genre){
        return movieService.getByGenre(genre);
    }

    @GetMapping("/findByName/{name}")
    public List<Movie> findMovieByName(@PathVariable String name){
        return movieService.getByName(name);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieById(@PathVariable Integer id){
        movieService.deleteMovieById(id);
    }

    @PutMapping("/updateMovie/{id}")
    public Movie updateMovieById(@RequestBody Movie movie, @PathVariable Integer id){
        return movieService.updateMovie(movie, id);
    }
}
