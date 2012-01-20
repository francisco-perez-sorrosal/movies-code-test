package com.movies.codetest.moviedatabase.classification;

import java.util.Comparator;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This class allows to compare movies based on the popularity
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public class MoviesSortedByPopularity implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		// To sort descending put first m2 and then m1 in the comparison
		// or negate the result of: (m1.getPopularity() - m2.getPopularity())
		return m2.getPopularity() - m1.getPopularity();
	}

}