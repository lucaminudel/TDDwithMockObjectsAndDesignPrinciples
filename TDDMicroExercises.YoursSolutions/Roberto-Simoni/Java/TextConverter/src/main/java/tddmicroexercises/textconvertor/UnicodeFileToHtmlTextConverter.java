package tddmicroexercises.textconvertor;

import java.io.FileReader;
import java.io.IOException;

public class UnicodeFileToHtmlTextConverter {
	
	private String fullFilenameWithPath;

	public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
	}

	public String convertToHtml() throws IOException {
		Text text = new Text(new FileReader(fullFilenameWithPath));
		return text.toHtml();
	}
	
}
