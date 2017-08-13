package tddmicroexercises.textconvertor.somedependencies;


import java.lang.reflect.InvocationTargetException;

public class aTextConverterClient3
{
    // A class with the only goal of simulating a dependency on UnicodeFileToHtmTextConverter
    // that has impact on the refactoring.

    public aTextConverterClient3() throws Exception
    {

        Object[] args = { "jetAnotherFilename.txt" };
        Class<?> c = Class.forName("tddmicroexercises.textconvertor.UnicodeFileToHtmlTextConverter");
        Object x = c.getConstructor(String.class).newInstance(args);

        String html = (String) c.getDeclaredMethod("convertToHtml").invoke(x);
    }
}
