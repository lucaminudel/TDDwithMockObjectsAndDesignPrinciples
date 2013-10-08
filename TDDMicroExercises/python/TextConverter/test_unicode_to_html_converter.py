import unittest

from unicode_to_html_converter import UnicodeFileToHtmlTextConverter

class UnicodeFileToHtmlTextConverterTest(unittest.TestCase):

    def test_do_something(self):
        x = UnicodeFileToHtmlTextConverter("unicode_to_html_converter.py")
        print x.convert_to_html()

if __name__ == "__main__":
	unittest.main()