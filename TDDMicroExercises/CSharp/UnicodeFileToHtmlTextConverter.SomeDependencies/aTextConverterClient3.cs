using System;
namespace TDDMicroExercises.UnicodeFileToHtmlTextConverter.SomeDependencies
{
    public class aTextConverterClient3
    {
		// A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
		// that has impact on the refactoring.

		public aTextConverterClient3()
        {
			object[] args = { "jetAnotherFilename.txt" };
			dynamic x = Activator.CreateInstance(Type.GetType("TDDMicroExercises.UnicodeFileToHtmTextConverter.UnicodeFileToHtmTextConverter"), args);

			string html = x.ConvertToHtml();

        }
    }
}
