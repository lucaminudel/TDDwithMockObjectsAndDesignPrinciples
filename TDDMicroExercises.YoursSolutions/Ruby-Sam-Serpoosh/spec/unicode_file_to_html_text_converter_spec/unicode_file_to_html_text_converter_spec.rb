require_relative "../../code/unicode_file_to_html_text_converter/unicode_file_to_html_text_converter"

class HttpUtility; end

describe UnicodeFileToHtmTextConverter do
  let(:file_path) { stub }
  let(:foobar) { "foobar" }

  before do
    @converter = UnicodeFileToHtmTextConverter.new(file_path)
  end

  it "reads the file content" do
    FileReader.should_receive(:read_content).with(file_path).
      and_return(foobar)
    HttpUtility.stub(:html_encode => foobar) 

    @converter.convert_to_html
  end

  it "converts to html on a line basis" do
    FileReader.stub(:read_content => foobar)
    HttpUtility.should_receive(:html_encode).and_return("<b>foobar</b>")

    html = @converter.convert_to_html
    html.should == "<b>foobar</b><br />"
  end
end

# Another way of doing this which specially more suitable for 
# statically typed languages is inject the FileReader & 
# HttpUtility through the constructor according to 
# Dependency Inversion Principle
