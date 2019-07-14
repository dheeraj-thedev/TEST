package com.trainingbasket.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

public class GenericCSVParsingUtils {

	String filePath;

	public GenericCSVParsingUtils(String filePath) {
		this.filePath = filePath;
	}

	public void getData() throws IOException {
		int ctr = 0;
		List<String> listOfLines = Files.readAllLines(Paths.get(filePath));
		for (String line : listOfLines) {
			if (ctr == 0) {
				String columns[] = line.split(",");
				for (String column : columns) {
					System.out.println(column.split("-")[1]);
				}
			} else {
				String columns[] = line.split(",");
				for (String column : columns) {
					System.out.print(column);
				}
				System.out.println();
			} 
			
			ctr++;
		}
	}

	public static void main(String[] args) {
		try {
			File f = new File("c:\\test");
			File files[] = f.listFiles();
			for (File file : files) {
				
			
				if (file.getName().split("\\.")[1].contains("csv")) {
					new GenericCSVParsingUtils(file.getPath()).getData();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
