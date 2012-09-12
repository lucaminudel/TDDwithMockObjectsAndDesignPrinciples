class UnicodeFileToHtmTextConverter
  def initialize(full_file_name_with_path)
    @full_file_name_with_path = full_file_name_with_path 
    @html = ""
  end

  def convert_to_html 
    text = read_content 
    text.each_line { |line| @html += to_html(line) }

    @html
  end

  private
  def read_content
    FileReader.read_content(@full_file_name_with_path)
  end

  def to_html(text)
      converted = HttpUtility.html_encode(text)
      converted += "<br />"
  end
end

class FileReader
  def self.read_content(file_path)
    text = File.open(file_path).read # Not exactly the same thing as the                              # CShapr code but same functionality!
    text.gsub!(/\r\n?/, "\n")
  end
end
