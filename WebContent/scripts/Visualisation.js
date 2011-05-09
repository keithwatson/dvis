if (typeof (Visualisation) == "undefined") {
	var Visualisation = {};
};

if (typeof (Visualisation.Utils) == "undefined") {
	Visualisation.Utils = {};
};

function $(id) {
	return document.getElementById(id);
}

/**
 * pixel length of the longest string in array of strings
 */
Visualisation.Utils.visualLength = function(arrayOfStrings) {
	var longest = 0;
	var ruler = document.getElementById("ruler");
	for ( var i = 0; i <  arrayOfStrings.length; i++) {

		ruler.innerHTML = arrayOfStrings[i];
		visualLength = ruler.offsetWidth;
		if (visualLength > longest) {
			longest = visualLength;
		}
	}
	return longest;
};


