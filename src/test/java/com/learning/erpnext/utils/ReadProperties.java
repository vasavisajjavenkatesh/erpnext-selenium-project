package com.learning.erpnext.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[]args) throws IOException {
		FileReader file = new FileReader("C:\\Users\\sreen\\OneDrive\\Desktop\\vasavi-eclipse-workspace\\ErpNext\\src\\test\\resources\\configFiles");
		Properties p = new Properties();
		p.load(file);
		
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("erpNextURL"));
	}
}
