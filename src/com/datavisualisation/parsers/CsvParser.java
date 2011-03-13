package com.datavisualisation.parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvParser {

	public static List<String[]> parse(String fileName) throws FileNotFoundException, IOException {

		CSVReader reader = new CSVReader(new FileReader(fileName));
		List<String[]> rows = reader.readAll();

		debug(rows);

		return rows;
	}


	public static void debug(List<String[]> rows) {

		for (String[] row : rows) {
			for (String cell : row) {
				System.out.print(cell + ",  ");
			}

			System.out.println();
		}

	}

}
