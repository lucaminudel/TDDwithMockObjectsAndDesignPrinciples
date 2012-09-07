package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextTest {

	@Test public void toHtml_returnsEscapedEntities() {
		assertEquals("mum&amp;dad", new Text("mum&dad").toHtml());
		assertEquals("less&lt;than", new Text("less<than").toHtml());
	}

	@Test public void toHtml_useHtmlBreakInPlaceOfNewLines() {
		assertEquals("hello<br/>mum&amp;dad<br/>less&lt;than", new Text("hello\nmum&dad\nless<than").toHtml());
	}

}
