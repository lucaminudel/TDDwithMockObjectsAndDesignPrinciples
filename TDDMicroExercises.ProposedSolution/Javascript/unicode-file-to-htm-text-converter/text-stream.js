TextStream = function (fileBlob) {
	this._fileBlob = fileBlob;
};

TextStream.prototype = {

	getText: function (callback) {

		var fileReader = new FileReader();
		var text;
		fileReader.onload = function (evt) {
			text = evt.target.result;
			if (callback) {
				callback(text);
			}
		};
		fileReader.readAsText(this._fileBlob);

	}

};
