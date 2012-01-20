package com.movies.codetest.moviedatabase.classification;

import java.util.List;
import java.util.Map;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This class is part of the strategy pattern implemented to select the different
 * strategies to sort the parsed movies. You can implement as many strategies
 * as you want for classifying the movies.
 * 
 * In this case, three strategies have been implemented taking into account the
 * code test instructions:
 * 
 * @PopularityClassifierStrategy
 * @DirectorClassifierStrategy
 * @GenreClassifierStrategy
 * 
 * This interface is used by the @ClassificationContext class to call a concrete 
 * classification strategy
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 *
 */
public interface ClassifierStrategy {
	List<Movie> classify(Map<String, Movie> data);
}
