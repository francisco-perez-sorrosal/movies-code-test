package com.movies.codetest.moviedatabase.xmlparsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.movies.codetest.moviedatabase.data.Movie;

/**
 * This stateless static class allows to retrieve the movies contained in an XML
 * file as Java Objects (POJOs) parsing the elements contained in the DOM
 * 
 * In this case, I've decided to put the movies in a @Map container because it
 * allows to access the movies quickly by using the MovieID as key.
 * 
 * However, for the purpose of this specific code test, it would have been more
 * effective to put them in a @List to avoid the transformations between data
 * structures.
 * 
 * @author (C) 2011 - Francisco Perez-Sorrosal
 * 
 */
public class MovieParser {

	// Avoid instantiation
	private MovieParser() {
	}

	/**
	 * This is the single public method to invoke:
	 * 
	 * It gets the DOM from the XML file and parses the content, adding it into
	 * a Map.
	 * 
	 * @param filename
	 *            The file that contains the movies to process
	 * @return a Map <MovieID, Movie> containing the movies. An empty Map is
	 *         returned if there are errors in the parsing phase.
	 */
	public static Map<String, Movie> parseMoviesXmlFile(String filename) {
		Document dom = getDOMDocument(filename);
		return parseMoviesDOM(dom);
	}

	// Private methods
	private static Document getDOMDocument(String filename) {
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory
				.newInstance();
		Document dom = null;
		try {
			DocumentBuilder db = documentFactory.newDocumentBuilder();
			dom = db.parse(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dom;
	}

	private static Map<String, Movie> parseMoviesDOM(Document dom) {
		// The returned implementation of the Map is a HashMap instance
		Map<String, Movie> parsedMovies = new HashMap<String, Movie>();

		try {
			// Get the root element of DOM and then inspect it in order to...
			Element docElement = dom.getDocumentElement();

			// ...get the <Movie> elements
			NodeList nl = docElement.getElementsByTagName("Movie");
			if (nl != null && nl.getLength() > 0) {
				for (int i = 0; i < nl.getLength(); i++) {

					// Get the Movie element and convert it into a Movie object
					// to put it in result
					Element elem = (Element) nl.item(i);
					Movie movie = getMovieObject(elem);
					parsedMovies.put(movie.getId(), movie);
				}
			}
		} catch (NullPointerException e) {
			// If the DOM is null, an empty HashMap will be returned
			// and there will be no need to check for nulls
		}
		return parsedMovies;
	}

	// The next two methods perform the conversion XML Data -> Java Object

	private static Movie getMovieObject(Element elem) {
		// Get all the XML elements to build a Movie object
		String id = getStringValue(elem, "ID");
		String title = getStringValue(elem, "Title");
		String director = getStringValue(elem, "Director");
		String year = getStringValue(elem, "Year");
		String genre = getStringValue(elem, "Genre");
		int popularity = getIntValue(elem, "Popularity");
		// Get the nested Tag elements present in Movie
		List<String> tags = getTagsList(elem);

		// Create a new Movie with the value read from the xml tags
		Movie movie = new Movie.Builder(id, title, director, genre, popularity)
				.tags(tags).year(year).build();

		return movie;
	}

	private static List<String> getTagsList(Element movieElem) {
		List<String> tagsIdentified = new ArrayList<String>();

		NodeList nl = movieElem.getElementsByTagName("Tags");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				// Get the each possible Tag and put it in result list
				Element elem = (Element) nl.item(i);
				String tag = getStringValue(elem, "Tag");
				tagsIdentified.add(tag);
			}
		}
		return tagsIdentified;
	}

	// The next two methods are low level methods to get the text values of
	// XML tags and convert them into String and int Java data types
	// respectively

	private static String getStringValue(Element elem, String tagName) {
		String textValue = null;
		NodeList nl = elem.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element e = (Element) nl.item(0);
			textValue = e.getFirstChild().getNodeValue();
		}

		return textValue;
	}

	private static int getIntValue(Element elem, String tagName) {
		return Integer.parseInt(getStringValue(elem, tagName));
	}
}
