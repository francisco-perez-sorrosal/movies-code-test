package com.movies.codetest.moviedatabase.classification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This class is part of the strategy pattern implemented to select the
 * different strategies to classify the parsed movies.
 * 
 * It represents a concrete strategy that classifies movies by popularity by
 * implementing the @ClassifierStrategy interface. It uses the specific
 * Comparator to classify the list by popularity: @MoviesSortedByPopularity
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public class PopularityClassifierStrategy implements ClassifierStrategy {

	@Override
	public List<Movie> classify(Map<String, Movie> movies) {
		List<Movie> classifiedListOfMovies = new ArrayList<Movie>(
				movies.values());
		Collections
				.sort(classifiedListOfMovies, new MoviesSortedByPopularity());
		return classifiedListOfMovies;
	}

}
