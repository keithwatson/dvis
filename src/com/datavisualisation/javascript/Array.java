package com.datavisualisation.javascript;

import java.util.ArrayList;
import java.util.Collections;
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


	public static List<Integer> toIntList(List<String> stringArray) {

		List<Integer> list = new ArrayList<Integer>(stringArray.size());

		for (String item : stringArray) {
			list.add(Integer.parseInt(item));
		}

		return list;

	}


	public static int getMaximumIntegerFromStringArray(List<String> data) {
		return Collections.max(toIntList(data));
	}


	public static int getMaximumInteger(List<Integer> data) {
		return Collections.max(data);
	}

}
