<?php

namespace TDDMicroExercises\PHP\UnicodeFileToHtmlTextConverter;

class UnicodeFileToHtmlTextConverter 
{
    private $_fullFilenameWithPath;

    public function __construct($fullFilenameWithPath)
    {
        $this->_fullFilenameWithPath = $fullFilenameWithPath;
    }

    public function convertToHtml()
    {
        $unicodeFileStrem = fopen($this->_fullFilenameWithPath, 'r+');
        $html = '';

        while ( $line = fgets($unicodeFileStrem)) 
        {
            $html .= htmlentities($line);
            $html .= "<br />";
        }

        fclose($unicodeFileStrem);

        return $html;
    }
}
