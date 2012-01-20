package com.movies.codetest.moviedatabase.classification;

import java.util.List;
import java.util.Map;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This class is part of the strategy pattern implemented to select the
 * different strategies to sort the parsed movies.
 * 
 * The instantiated objects from this class are used by the client (the main
 * program in this case) to specify a concrete strategy to use in classifying
 * movies.
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public class ClassificationContext {

	private ClassifierStrategy strategy;

	public ClassificationContext(ClassifierStrategy strategy) {
		this.strategy = strategy;
	}

	public List<Movie> executeStrategy(Map<String, Movie> data) {
		return strategy.classify(data);
	}

}
