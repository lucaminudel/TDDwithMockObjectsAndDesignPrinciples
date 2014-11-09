package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import junit.framework.Assert;

import org.junit.Test;

public class UnicodeFileToHtmlTextConverterTest {
	
	@Test public void
	should_convert_empty_input() throws IOException {
		UnicodeFileToHtmlTextConverter con = new TestableUnicodeFileToHtmlTextConverter("");
		Assert.assertEquals("", con.convertToHtml());
	}
	
	@Test public void
	should_convert_non_empty_input() throws IOException {
		UnicodeFileToHtmlTextConverter con = new TestableUnicodeFileToHtmlTextConverter(" ");
		Assert.assertEquals(" <br />", con.convertToHtml());
	}
	
	@Test public void
	should_escape_when_converting() throws IOException {
		UnicodeFileToHtmlTextConverter con = new TestableUnicodeFileToHtmlTextConverter("\"test\"");
		Assert.assertEquals("&quot;test&quot;<br />", con.convertToHtml());
	}
	
	@Test public void
	should_convert_multi_line_correctly() throws IOException {
		UnicodeFileToHtmlTextConverter con = new TestableUnicodeFileToHtmlTextConverter("\n\n");
		Assert.assertEquals("<br /><br />", con.convertToHtml());
	}
	
	static class TestableUnicodeFileToHtmlTextConverter extends UnicodeFileToHtmlTextConverter {
		private String inp;
		
		public TestableUnicodeFileToHtmlTextConverter(String inp) {
			this.inp = inp;
		}
		
		@Override
		protected Reader getReader() {
			return new StringReader(inp);
		}
	}

}
