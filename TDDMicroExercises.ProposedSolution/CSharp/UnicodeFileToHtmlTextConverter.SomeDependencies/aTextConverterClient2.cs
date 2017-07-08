namespace TDDMicroExercises.OneSolution.UnicodeFileToHtmlTextConverter.SomeDependencies
{
    public class aTextConverterClient2
    {
		// A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
		// that has impact on the refactoring.

		UnicodeFileToHtmTextConverter.UnicodeFileToHtmTextConverter _textConverter;

        public aTextConverterClient2()
        {
            _textConverter = new TDDMicroExercises.OneSolution.UnicodeFileToHtmTextConverter.UnicodeFileToHtmTextConverter("anotherFilename.txt");

            var html = _textConverter.ConvertToHtml();
        }

    }
}
