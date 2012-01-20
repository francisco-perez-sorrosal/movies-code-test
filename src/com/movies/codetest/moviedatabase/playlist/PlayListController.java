package com.movies.codetest.moviedatabase.playlist;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This is the interface to control the PlayLists with the methods required by
 * the code test: nextMovie() and previousMovie()
 * 
 * Additionally, I have added the currentMovie method to return the current
 * movie in the PlayLists and the numberOfMovies to return the number of movies
 * in the PlayLists
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public interface PlayListController {

	Movie nextMovie();

	Movie previousMovie();

	Movie currentMovie();

	int numberOfMovies();

}
