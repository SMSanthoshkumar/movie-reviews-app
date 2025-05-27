package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }


    public Optional<Movie> singleMovie(ObjectId id){ //optional is used avoid NullPointerException ,if the movie is not present optional will return null
        return movieRepository.findById(id);
    }



    public Optional<Movie> singleMovieByImdb(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
