package com.datavisualisation.protovis;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.datavisualisation.Server;
import com.datavisualisation.javascript.Array;

/** 
 * Class to create a basic bar chart, using the Protovis Javascript library.
 * 
 * Uses the Apache Velocity template engine to generate a Javascript file that can be included in the JSP as part of a <script> tag.
 * Velocity is only used to generate the Javascript file and not the page itself. 
 * 
 * @author Keith Watson
 *
 */

public class BarChart {

	public String generateChartJavascript(List<String[]> csvData) {

		/* Shift columns into lists */

		List<String> labels = new ArrayList<String>(csvData.size());
		List<String> data = new ArrayList<String>(csvData.size());

		for (String[] row : csvData) {
			labels.add(row[0]);
			data.add(row[1]);
		}

		String labelsString = Array.generateJavaScriptArray("labels", labels);
		String dataString = Array.generateJavaScriptArray("data", data);

		VelocityEngine engine = new VelocityEngine();
		engine.setProperty("file.resource.loader.path", Server.getTemplatesDirectory());

		engine.init();
		VelocityContext context = new VelocityContext();
		context.put("labels", labelsString);
		context.put("data", dataString);

		Template template = engine.getTemplate("barchart.js");
		StringWriter writer = new StringWriter();
		template.merge(context, writer);

		String output = writer.getBuffer().toString();

		return output;
	}

}
