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
            return new StringReader(FullFilenameWithPath);
        }
    }
}