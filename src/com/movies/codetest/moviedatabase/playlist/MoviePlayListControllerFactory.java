package com.movies.codetest.moviedatabase.playlist;

import java.util.List;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This class acts as a factory for getting PlayList controllers that implement
 * the interface required by the code test (See @PlayListController).
 * 
 * It contains a Factory Method to create new PlayList controllers when
 * required, and provides a basic Iterator pattern through the @PlayListController
 * interface.
 * 
 * It also implements the NULL Object pattern to return an empty movie when
 * required.
 * 
 * The iteration on the list has been implemented by moving forward and
 * backwards on a @List of Movies. If the beginning or the end of the @List is
 * reached, and the client tries to get the previous or next element, the first
 * or the last movie is returned respectively.
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public class MoviePlayListControllerFactory implements PlayListController {

	// A default empty movie to avoid to return null movies that should be
	// checked
	// by the client. Implementation of the NULL Object pattern.
	private static final Movie EMPTY_MOVIE = new Movie.Builder("N/A", "N/A",
			"N/A", "N/A", 0).build();

	// PlayListController required data
	List<Movie> playList;
	int currentMovie = -1;

	// Avoid instantiation
	private MoviePlayListControllerFactory(List<Movie> moviesPlayList) {
		playList = moviesPlayList;
	}

	// Factory Method
	public static PlayListController getPlayListController(
			List<Movie> moviesPlayList) {
		return (PlayListController) new MoviePlayListControllerFactory(
				moviesPlayList);
	}

	// PlayListController interface implementation

	@Override
	public Movie nextMovie() {
		if (playList.isEmpty())
			return EMPTY_MOVIE;
		int nextMovie = currentMovie + 1;
		if (nextMovie < playList.size()) {
			currentMovie++;
		}
		return playList.get(currentMovie);
	}

	@Override
	public Movie previousMovie() {
		if (playList.isEmpty())
			return EMPTY_MOVIE;
		// The next sentence initializes the PlayList from the tail of the list
		// , just in case it is the first invocation on the PlayList
		if (currentMovie == -1)
			currentMovie = playList.size();
		int previousMovie = currentMovie - 1;
		if (previousMovie >= 0) {
			currentMovie--;
		}
		return playList.get(currentMovie);
	}

	@Override
	public Movie currentMovie() {
		if (playList.isEmpty() || (currentMovie == -1))
			return EMPTY_MOVIE;
		else
			return playList.get(currentMovie);
	}

	@Override
	public int numberOfMovies() {
		return playList.size();
	}
}
