package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }


    /*
    //this will find by objectid but not used by user they only know the imdb id of the movie,so we will not use this
    @GetMapping("/objectid/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }

     */

    //this will find by imdbid ,so user will find movie based on imdbid
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByImdb(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdb(imdbId), HttpStatus.OK);
    }



}
