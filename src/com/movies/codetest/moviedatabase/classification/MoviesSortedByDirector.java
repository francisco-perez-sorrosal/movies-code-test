package com.movies.codetest.moviedatabase.classification;

import java.util.Comparator;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This class allows to compare movies based on the director
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public class MoviesSortedByDirector implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getDirector().compareTo(m2.getDirector());
	}

}