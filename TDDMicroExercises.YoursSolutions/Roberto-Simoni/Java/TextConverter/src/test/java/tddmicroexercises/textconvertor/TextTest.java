package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

public class TextTest {

	@Test public void toHtml_returnsEscapedEntities() {
		assertEquals("mum&amp;dad", new Text("mum&dad").toHtml());
		assertEquals("less&lt;than", new Text("less<than").toHtml());
	}

	@Test public void toHtml_useHtmlBreakInPlaceOfNewLines() {
		assertEquals("hello<br/>mum&amp;dad<br/>less&lt;than", new Text("hello\nmum&dad\nless<than").toHtml());
	}

	@Test public void worksOnFilesToo() throws IOException {
		File file = aNewFileContaining("hello\nmum&dad\nless<than");
		
		assertEquals("hello<br/>mum&amp;dad<br/>less&lt;than", new Text(file).toHtml());
	}

	private File aNewFileContaining(String content) throws IOException {
		File file = new File(SystemUtils.JAVA_IO_TMPDIR, "textconverter-data.txt");
		if (file.exists()) file.delete();
		FileUtils.writeStringToFile(file, content);
		return file;
	}

}
