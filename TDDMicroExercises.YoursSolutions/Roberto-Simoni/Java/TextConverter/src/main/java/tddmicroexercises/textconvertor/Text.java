package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.lang.StringEscapeUtils;

public class Text {

	private final Reader reader;

	public Text(String text) {
		this(new StringReader(text));
	}

	public Text(Reader reader) {
		this.reader = reader;
	}

	public String toHtml() {
		try {
			StringBuilder builder = new StringBuilder();
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (builder.length() > 0)
					builder.append("<br/>");
				builder.append(StringEscapeUtils.escapeHtml(line));
			}
			return builder.toString();
		} catch (IOException e) {
			throw new RuntimeException("Unable to convert text to HTML due to a " + e.getClass().getName() + " with message '" + e.getMessage() + "'", e);
		}
	}

}
