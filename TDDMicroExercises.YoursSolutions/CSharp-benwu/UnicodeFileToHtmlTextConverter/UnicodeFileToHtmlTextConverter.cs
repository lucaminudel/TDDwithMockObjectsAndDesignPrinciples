using System.IO;
using System.Web;

namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter
{
    public class UnicodeFileToHtmlTextConverter
    {
        protected readonly string FullFilenameWithPath;


        public UnicodeFileToHtmlTextConverter(string fullFilenameWithPath)
        {
            FullFilenameWithPath = fullFilenameWithPath;
        }

        public string ConvertToHtml()
        {
            using (TextReader unicodeFileStream = OpenTextReader())
            {
                string html = string.Empty;

                string line = unicodeFileStream.ReadLine();
                while (line != null)
                {
                    html += HttpUtility.HtmlEncode(line);
                    html += "<br />";
                    line = unicodeFileStream.ReadLine();
                }

                return html;
            }
        }

        protected virtual TextReader OpenTextReader()
        {
            return File.OpenText(FullFilenameWithPath);
        }
    }
}
