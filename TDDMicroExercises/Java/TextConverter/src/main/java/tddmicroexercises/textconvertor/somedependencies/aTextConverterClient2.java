package tddmicroexercises.textconvertor.somedependencies;

import tddmicroexercises.textconvertor.UnicodeFileToHtmlTextConverter;

import java.io.IOException;

public class aTextConverterClient2
{
    // A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
    // that has impact on the refactoring.


    UnicodeFileToHtmlTextConverter _textConverter;

    public aTextConverterClient2() throws IOException
    {
        _textConverter = new UnicodeFileToHtmlTextConverter("anotherFilename.txt");

        String html = _textConverter.convertToHtml();
    }

}

