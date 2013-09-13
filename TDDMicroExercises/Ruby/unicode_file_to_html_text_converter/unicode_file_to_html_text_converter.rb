require 'cgi'

class UnicodeFileToHtmTextConverter

  def initialize(file_path)
    @full_file_name_with_path = file_path
  end

  def convert_to_html
    text = File.open(@full_file_name_with_path).read

    html = ''
    text.each_line do |line|
      html += CGI::escapeHTML(line)
      html += '<br />'
    end

    html
  end
end
