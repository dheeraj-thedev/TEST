package com.trainingbasket.runner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.trainingbasket.beans.SalesData;

public class Runner {
	private static Map<Integer, SalesData> loadData() {
		Map<Integer, SalesData> salesMap = null;
		try {
			salesMap = new HashMap<Integer, SalesData>();
			List<String> lines = Files.readAllLines(Paths.get("e:\\sales_data_sample.csv"));
			for (String line : lines) {
				String columns[] = line.split(",");
				SalesData data = new SalesData();
				data.setORDERNUMBER(columns[0]);
				data.setQUANTITYORDERED(columns[1]);
				data.setPRICEEACH(columns[2]);
				data.setORDERLINENUMBER(columns[3]);
				data.setSALES(columns[4]);
				data.setORDERDATE(columns[5]);
				data.setSTATUS(columns[6]);
				data.setQTR_ID(columns[7]);
				data.setMONTH_ID(columns[8]);
				salesMap.put(data.getId(), data);
			}

		} catch (Exception e) {
System.out.println(e.getMessage());
		}
		return salesMap;

	}

	public static void main(String[] args) {

		Map<Integer, SalesData> dataMap = loadData();

		SalesData data = dataMap.get(1045);
		System.out.println(data);
		

	}

}
