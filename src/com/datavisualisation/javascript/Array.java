package com.datavisualisation.javascript;

import java.util.List;

public class Array {

	public static String generateJavaScriptArray(String arrayName, List<String> data) {

		StringBuilder labelBuffer = new StringBuilder();

		labelBuffer.append("var " + arrayName + " = [");

		for (String item : data) {
			labelBuffer.append(item);
			labelBuffer.append(", ");
		}

		labelBuffer = new StringBuilder(labelBuffer.substring(0, labelBuffer.length() - 2));
		labelBuffer.append("];");

		return labelBuffer.toString();
	}

}
