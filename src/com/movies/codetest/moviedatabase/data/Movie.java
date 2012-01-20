package com.movies.codetest.moviedatabase.data;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will contain the relevant information for each movie present in
 * the XML file.
 * 
 * It implements the Builder pattern to avoid having telescoping constructors if
 * new optional elements/attributes are added to movies in the future.
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public class Movie {

	private String id;
	private String genre;
	private List<String> tags; // Implementation agnostic
	private String title;
	private String year;
	private String director;
	private int popularity;

	public static class Builder {
		// Require at least these attributes
		private String id;
		private String title;
		private String director; // Required to sort by director
		private String genre; // Required to sort by genre
		private int popularity; // Required to sort by popularity

		// Optional attributes
		// They may not be present or new ones may be added to the xml file
		// Default values are inserted if they are not specified
		private List<String> tags = new ArrayList<String>();
		private String year = "N/A";

		public Builder(String id, String title, String director, String genre,
				int popularity) {
			this.id = id;
			this.title = title;
			this.director = director;
			this.popularity = popularity;
			this.genre = genre;
		}

		public Builder tags(List<String> tags) {
			this.tags = tags;
			return this;
		}

		public Builder year(String year) {
			this.year = year;
			return this;
		}

		public Movie build() {
			return new Movie(this);
		}

	}

	// Private constructor to create the object
	private Movie(Builder builder) {
		this.id = builder.id;
		this.genre = builder.genre;
		this.tags = builder.tags;
		this.title = builder.title;
		this.year = builder.year;
		this.director = builder.director;
		this.popularity = builder.popularity;
	}

	// Getters & setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	// Visualize properly a movie object
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Movie Details - ");
		sb.append("Id:" + id);
		sb.append(", ");
		sb.append("Title:" + title);
		sb.append(", ");
		sb.append("Director:" + director);
		sb.append(", ");
		sb.append("Popularity:" + popularity);
		sb.append(", ");
		sb.append("Tags: (");
		for (String tag : tags) {
			sb.append(tag);
			sb.append(",");
		}
		sb.append("), Genre:" + genre);
		sb.append(", ");
		sb.append("Year:" + year);
		sb.append(".");
		return sb.toString();
	}

}
