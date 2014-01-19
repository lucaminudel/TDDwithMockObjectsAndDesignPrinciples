

UnicodeFileToHtmTextConverter = function(fileBlob) {
	this._fileBlob = fileBlob;
};

UnicodeFileToHtmTextConverter.prototype = {

	convertToHtml: function (callback) {

		var self = this;
		var fileReader = new FileReader();
		var text;
		fileReader.onload = function(evt) {
			text = evt.target.result;
			var htmlLines = self._basicHtmlEncode(text);
			if (callback) {
				callback(htmlLines);
			}
		};
		fileReader.readAsText(this._fileBlob);

	},
	
	_basicHtmlEncode: function (source) {

		var stashNextCharacterAndAdvanceThePointer = function () {
			var c = source.charAt(i);
			i += 1;
			return c;

		};

		var addANewLine = function () {
			convertedLine = convertedLine.join('');
			result.push(convertedLine);
			convertedLine = [];
		};

		var pushACharacterToTheOutput = function () {
			convertedLine.push(characterToConvert);
		};

		var i = 0;
		var result = [];
		var convertedLine = [];
		var characterToConvert = stashNextCharacterAndAdvanceThePointer();
		while (i <= source.length) {

			switch (characterToConvert) {
				case '<':
					convertedLine.push('&lt;');
					break;
				case '>':
					convertedLine.push('&gt;');
					break;
				case '&':
					convertedLine.push('&amp;');
					break;
				case '\n':
					addANewLine();
					break;
				default:
					pushACharacterToTheOutput();
			}

			characterToConvert = stashNextCharacterAndAdvanceThePointer();
		}

		addANewLine();
		result = result.join('<br />');
		return result;
	}
};
