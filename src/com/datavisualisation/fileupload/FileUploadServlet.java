package com.datavisualisation.fileupload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.datavisualisation.parsers.CsvParser;

@WebServlet(urlPatterns = "/fileUpload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 4507877741171768330L;


	public FileUploadServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		for (Part part : request.getParts()) {

			InputStream inputStream = request.getPart(part.getName()).getInputStream();

			int bytesAvailable = inputStream.available();
			byte[] byteArray = new byte[bytesAvailable];

			inputStream.read(byteArray);

			String fileName = getFileName(part);
			String outputFileName = "/tmp" + fileName;

			FileOutputStream outputStream = new FileOutputStream(outputFileName);
			outputStream.write(byteArray);
			inputStream.close();

			CsvParser.parse(outputFileName);

		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}


	private String getFileName(Part part) {
		part.getHeader("content-disposition");
		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
