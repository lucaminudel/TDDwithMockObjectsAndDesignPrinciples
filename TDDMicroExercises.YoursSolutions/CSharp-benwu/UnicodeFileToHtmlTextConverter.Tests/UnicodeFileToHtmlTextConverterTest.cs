using NUnit.Framework;

namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter.Tests
{
    [TestFixture]
    public class UnicodeFileToHtmlTextConverterTest
    {
        [Test]
        public void should_convert_ampersand()
        {
            TestingUnicodeFileToHtmlTextConverter testingUnicodeFileToHtmlTextConverter = new TestingUnicodeFileToHtmlTextConverter("Copy & Paste");
            Assert.AreEqual("Copy &amp; Paste<br />", testingUnicodeFileToHtmlTextConverter.ConvertToHtml());
        }
    }
}
