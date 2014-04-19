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
            return OpenStringReader(new StringReader(FullFilenameWithPath));
        }

        private StringReader OpenStringReader(StringReader strToBeConverted)
        {
            return strToBeConverted;
        }
    }
}