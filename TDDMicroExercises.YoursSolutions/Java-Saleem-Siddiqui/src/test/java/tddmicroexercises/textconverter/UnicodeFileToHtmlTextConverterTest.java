package tddmicroexercises.textconverter;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class UnicodeFileToHtmlTextConverterTest {
    private static final String FILE_NAME = "temp";
    private static final String FILE_EXT = "test";
    private File tempInputFile;   

    @Before
    public void setUp() throws Exception {
	tempInputFile = File.createTempFile(FILE_NAME, FILE_EXT);
	BufferedWriter out = new BufferedWriter(new FileWriter(tempInputFile));
	out.write("Hello World");
	out.close();	
    }

    @After
    public void tearDown() throws Exception {
	tempInputFile.delete();
    }

    @Test
    public void convertAppendsLineBreakTagToEndOfSimpleOneLine() throws Exception {
	UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(tempInputFile.getAbsolutePath());
	assertThat(converter.convertToHtml(), is("Hello World<br />"));
    }
}
