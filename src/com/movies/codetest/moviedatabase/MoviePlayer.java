package com.movies.codetest.moviedatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.movies.codetest.moviedatabase.classification.ClassificationContext;
import com.movies.codetest.moviedatabase.classification.DirectorClassifierStrategy;
import com.movies.codetest.moviedatabase.classification.GenreClassifierStrategy;
import com.movies.codetest.moviedatabase.classification.PopularityClassifierStrategy;
import com.movies.codetest.moviedatabase.data.Movie;
import com.movies.codetest.moviedatabase.playlist.MoviePlayListControllerFactory;
import com.movies.codetest.moviedatabase.playlist.PlayListController;
import com.movies.codetest.moviedatabase.xmlparsing.MovieParser;

public class MoviePlayer {

	/**
	 * (C) Francisco Perez-Sorrosal (10/08/2011)
	 * 
	 * Main program to test the MoviePlayer "Code Test"
	 * 
	 * @param args
	 *            NOT USED
	 */
	public static void main(String[] args) {

		// First of all, parse the XML file into Movie Java Objects (POJOs)
		Map<String, Movie> movies = MovieParser
				.parseMoviesXmlFile(("MoviesDB.xml"));

		// Then, get a PlayList from the raw data parsed from XML (WO any
		// classification) and get a PlayListController to control it
		List<Movie> returnedPlayList = new ArrayList<Movie>(movies.values());

		PlayListController playListController = MoviePlayListControllerFactory
				.getPlayListController(returnedPlayList);

		System.out
				.println("The next sentence must print the NULL movie because"
						+ " the play list has been not initialized");

		// The next sentence has to return the EMPTY_MOVIE because initially the
		// play list does not points to a current movie. It points to specific
		// movie in the list the first time the nextMovie() or previousMovie()
		// methods are invoked
		System.out.println(playListController.currentMovie());

		System.out.println("\nForward in the list of Movies >>>\n");
		traverseListForward(playListController);

		printSeparator();

		System.out.println("<<< Backwards in the list of Movies\n");
		traverseListBackwards(playListController);

		printSeparator();

		System.out.println("Moving backwards but beginning of the list found. "
				+ "This should return the same data as in the previous line:");
		playListController.previousMovie();

		// The next sentences must print the first movie again because the list
		// hasn't been implemented as circular
		System.out.println(playListController.currentMovie());

		printSeparator();

		/**
		 * Selecting strategies for movie classification
		 */

		ClassificationContext classificationContext;

		// Movies by Popularity
		classificationContext = new ClassificationContext(
				new PopularityClassifierStrategy());
		List<Movie> playListOfMoviesByPopularity = classificationContext
				.executeStrategy(movies);

		// Movies by Director
		classificationContext = new ClassificationContext(
				new DirectorClassifierStrategy());
		List<Movie> playListOfMoviesByDirector = classificationContext
				.executeStrategy(movies);

		// Movies by Genre
		classificationContext = new ClassificationContext(
				new GenreClassifierStrategy());
		List<Movie> playListOfMoviesByGenre = classificationContext
				.executeStrategy(movies);

		/**
		 * Controlling playlists on previously classified lists
		 */

		// Example of how to control playlist movies by classified by popularity
		playListController = MoviePlayListControllerFactory
				.getPlayListController(playListOfMoviesByPopularity);
		System.out.println("Classified by Popularity (Descending)\n");
		traverseListForward(playListController);

		printSeparator();

		// Example of how to control playlist movies by classified by director
		playListController = MoviePlayListControllerFactory
				.getPlayListController(playListOfMoviesByDirector);
		System.out
				.println("Classified by Director (Francis F. Copula first, then Frank F. Dick)\n");
		traverseListForward(playListController);

		printSeparator();

		// Example of how to control playlist movies by classified by genre
		playListController = MoviePlayListControllerFactory
				.getPlayListController(playListOfMoviesByGenre);
		System.out.println("Classified by Genre (Comedy first, then War)\n");
		traverseListForward(playListController);

		printSeparator();

		//
		//
		// Try more stuff in the following lines...
		//
		//
	}

	// Helper methods

	private static void traverseListForward(PlayListController playList) {
		for (int i = 0; i < playList.numberOfMovies(); i++) {
			playList.nextMovie();
			System.out.println(playList.currentMovie());
		}
	}

	private static void traverseListBackwards(PlayListController playList) {
		for (int i = 0; i < playList.numberOfMovies(); i++) {
			System.out.println(playList.currentMovie());
			playList.previousMovie();
		}
	}

	private static void printSeparator() {
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println();
	}

}
