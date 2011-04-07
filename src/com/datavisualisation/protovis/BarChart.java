package com.datavisualisation.protovis;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.datavisualisation.Server;

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

	public String generateChartJavascript(String[] labels, String[] data) {

		VelocityEngine engine = new VelocityEngine();
		engine.setProperty("file.resource.loader.path", Server.getTemplatesDirectory());

		engine.init();
		VelocityContext context = new VelocityContext();
		context.put("test", "test");

		Template template = engine.getTemplate("barchart.js");
		StringWriter writer = new StringWriter();
		template.merge(context, writer);

		String output = writer.getBuffer().toString();

		return output;
	}

}
