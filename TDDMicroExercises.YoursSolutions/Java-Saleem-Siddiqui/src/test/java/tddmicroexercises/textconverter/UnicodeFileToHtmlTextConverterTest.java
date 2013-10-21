package tddmicroexercises.textconverter;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.commons.lang3.StringEscapeUtils;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.anyString;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({UnicodeFileToHtmlTextConverter.class, StringEscapeUtils.class})
public class UnicodeFileToHtmlTextConverterTest {
    private static final String FILE_NAME = "temp";
    private static final String FILE_EXT = "test";
    private File tempInputFile;   

    @Before
    public void setUp() throws Exception {
	tempInputFile = File.createTempFile(FILE_NAME, FILE_EXT);
    }

    @After
    public void tearDown() throws Exception {
	tempInputFile.delete();
    }

    private void writeToTempInputFile(String contents) throws Exception {
	BufferedWriter out = new BufferedWriter(new FileWriter(tempInputFile));
	out.write(contents);
	out.close();
    }

    @Test
    public void convertAppendsLineBreakTagToEndOfSimpleOneLine() throws Exception {
	writeToTempInputFile("Hello World");
	UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(tempInputFile.getAbsolutePath());
	assertThat(converter.convertToHtml(), is("Hello World<br />"));
    }

    @Test
    public void converterReturnsEmptyStringForEmptyFile() throws Exception {
	UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(tempInputFile.getAbsolutePath());
	assertThat(converter.convertToHtml(), is(""));
    }

    @Test
    public void converterShouldCallStaticMethodInLibraryForEachLineInInputFile() throws Exception {
	// Arrange
	mockStatic(StringEscapeUtils.class);
	when(StringEscapeUtils.escapeHtml4(anyString())).thenReturn("return value does not matter");
	writeToTempInputFile("Hello World");
	UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter(tempInputFile.getAbsolutePath());
	// Act
	converter.convertToHtml();
	// Assert
	verifyStatic();
	StringEscapeUtils.escapeHtml4("Hello World");
    }
}
