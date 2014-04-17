using System.IO;

namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter.Tests
{
    public class TestingUnicodeFileToHtmlTextConverter : UnicodeFileToHtmlTextConverter
    {
        public TestingUnicodeFileToHtmlTextConverter(string strToBeConverted) : base (strToBeConverted)
        {
        }

        protected override TextReader OpenTextReader()
        {
            return OpenStringReader();
        }

        private StringReader OpenStringReader()
        {
            return new StringReader(FullFilenameWithPath);
        }
    }
}