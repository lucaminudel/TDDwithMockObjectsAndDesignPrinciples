package tddmicroexercises.textconvertor;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class UnicodeFileToHtmlTextConverter
{
    private String fullFilenameWithPath;
    
    UnicodeFileToHtmlTextConverter() {
    	
    }
    
    public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath)
    {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }
    
    public String convertToHtml() throws IOException {
	    return TextConverter.convert(getReader());
    }
    
    Reader getReader() throws IOException {
    	return new FileReader(fullFilenameWithPath);
    }
}
