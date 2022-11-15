package com.dcc.movie_api.service;

import com.dcc.movie_api.data.Movie;
import com.dcc.movie_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getById(Integer id){
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getByName(String name){
        return movieRepository.findByName(name);
    }

    public void deleteMovieById(Integer id){
        movieRepository.deleteById(id);
    }

    @PutMapping
    public Movie updateMovieById(Movie movie, Integer id){
        Movie movieToUpdate = movieRepository.findById(id).orElse(null);
        movieToUpdate.setDirector(movie.getDirector());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setName(movie.getName());
        return movieRepository.save(movieToUpdate);
    }

    @PutMapping
    public Movie updateMovieByName(Movie movie, String name){
        Movie movieToUpdate = movieRepository.findByName(name).stream().findFirst().orElse(null);
        movieToUpdate.setDirector(movie.getDirector());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setName(movie.getName());
        return movieRepository.save(movieToUpdate);
    }

}
