package com.datavisualisation.javascript;

import java.util.List;

public class Array {

	public static String generateJavaScriptArray(String arrayName, List<String> data, boolean inQuotes) {

		StringBuilder labelBuffer = new StringBuilder();

		labelBuffer.append("var " + arrayName + " = [");

		for (String item : data) {
		    if(inQuotes){
		        labelBuffer.append("'").append(item).append("'");
		    } else {
		        labelBuffer.append(item);
		    }
			labelBuffer.append(", ");
		}
		

		labelBuffer = new StringBuilder(labelBuffer.substring(0, labelBuffer.length() - 2));
		labelBuffer.append("];");

		return labelBuffer.toString();
	}

}
