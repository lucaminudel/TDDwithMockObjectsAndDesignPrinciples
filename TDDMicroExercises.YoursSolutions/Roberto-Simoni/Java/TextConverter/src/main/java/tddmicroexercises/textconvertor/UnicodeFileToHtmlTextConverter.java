package tddmicroexercises.textconvertor;

import java.io.FileReader;
import java.io.IOException;

/**
 * @deprecated Please use {@link Text#Text(java.io.File)} and {@link Text#toHtml()}
 */
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
