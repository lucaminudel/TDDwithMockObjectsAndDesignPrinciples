using System;
namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter.SomeDependencies
{
    public class aTextConverterClient1
    {
		// A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
		// that has impact on the refactoring.

		public aTextConverterClient1()
        {
            var filename = "aFilename.txt";
            var textConverter = new UnicodeFileToHtmlTextConverter(filename);
            var html = textConverter.ConvertToHtml();
        }
    }
}
