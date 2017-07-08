using System;
namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter.SomeDependencies
{
    public class aTextConverterClient2
    {
		// A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
		// that has impact on the refactoring.


		UnicodeFileToHtmlTextConverter _textConverter;

        public aTextConverterClient2()
        {
            _textConverter = new UnicodeFileToHtmlTextConverter("anotherFilename.txt");

            var html = _textConverter.ConvertToHtml();
        }

    }
}
