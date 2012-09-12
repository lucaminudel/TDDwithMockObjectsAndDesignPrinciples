class UnicodeFileToHtmTextConverter
  def initialize(full_file_name_with_path)
    @full_file_name_with_path = full_file_name_with_path 
  end

  def convert_to_html 
    html = "" 

    text = File.open(@full_file_name_with_path).read # Not exactly the same code in CSharp but same functionality!
    text.gsub!(/\r\n?/, "\n")
    text.each_line do |line|
      html += HttpUtility.html_encode(line)
      html += "<br />"
    end

    return html
  end
end
