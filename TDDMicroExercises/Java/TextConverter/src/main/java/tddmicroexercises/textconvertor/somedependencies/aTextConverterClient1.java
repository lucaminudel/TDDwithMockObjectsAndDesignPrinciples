package tddmicroexercises.textconvertor.somedependencies;

import tddmicroexercises.textconvertor.UnicodeFileToHtmlTextConverter;

import java.io.IOException;

public class aTextConverterClient1
{
    // A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
    // that has impact on the refactoring.

    public aTextConverterClient1() throws IOException
    {
        String filename = "aFilename.txt";
        UnicodeFileToHtmlTextConverter textConverter = new UnicodeFileToHtmlTextConverter(filename);

        String html = textConverter.convertToHtml();
    }
}
