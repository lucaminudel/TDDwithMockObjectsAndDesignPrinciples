package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.lang3.StringEscapeUtils;

public class TextConverter {
	
	public static String convert(Reader source) throws IOException {
		BufferedReader br = new BufferedReader(source);
		
	    String line = br.readLine();
	    StringBuilder html = new StringBuilder();
	    while (line != null)
	    {
	            html.append(StringEscapeUtils.escapeHtml4(line));
	            html.append("<br />");
	            line = br.readLine();
	    }
	    return html.toString();
	}

}
