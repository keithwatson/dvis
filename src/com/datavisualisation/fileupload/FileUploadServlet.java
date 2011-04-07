package com.datavisualisation.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.datavisualisation.parsers.CsvParser;
import com.datavisualisation.protovis.BarChart;

@WebServlet(urlPatterns = "/fileUpload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 4507877741171768330L;


	public FileUploadServlet() {
		super();
	}


	/** Reads the CSV file into a byte array, converts that into a String and then passes it to the CSV parser for parsing.
	 *  Now avoids temporary files so that it works multi-platform. */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String script = "";

		for (Part part : request.getParts()) {

			InputStream inputStream = request.getPart(part.getName()).getInputStream();

			int bytesAvailable = inputStream.available();
			byte[] byteArray = new byte[bytesAvailable];

			inputStream.read(byteArray);
			String contents = new String(byteArray);
			inputStream.close();

			List<String[]> data = CsvParser.parse(contents);

			BarChart barChart = new BarChart();
			script = barChart.generateChartJavascript(data);

		}

		request.setAttribute("script", script);
		request.getRequestDispatcher("/pages/barchart.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
