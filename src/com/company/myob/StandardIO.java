package com.company.myob;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StandardIO {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("");
		String parentLoc = f.getAbsoluteFile().getParent();
		String input = parentLoc+"//input//input.csv";
		String output = parentLoc+"//output//output.csv";
		
		//Evaluate PaySlip
		List<Employee> list = new ArrayList<Employee>();
		list=evalPayslip(input);
		
		System.out.println("Writing file to "+output);
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		String outHeader = "#Name, Pay period, Gross income, Income tax, Net income, Super";
		bw.write(outHeader+"\n");
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i).toString()+"\n");
		}
		bw.flush();
		bw.close();
		
		System.out.println("Payslip generated");
		//Employee e = new Employee(firstName, lastName, salary, sureRate);
	}

	public static Employee getEmployee(String inputLine) {
			StringTokenizer s = new StringTokenizer(inputLine , ",");

			String firstName = s.nextToken();
			String lastName = s.nextToken();
			Double salary = Double.parseDouble(s.nextToken());
			 String sureR = s.nextToken().split("%")[0];
			float sureRate = Float.parseFloat(sureR);
			String payPeriod = s.nextToken();
			Employee e = new Employee(firstName, lastName, salary, sureRate, payPeriod);
		return e;
	}
	
	public static List<Employee> evalPayslip(String input) {
		System.out.println("Reading file from "+input);
		List<Employee> list = new ArrayList<Employee>();
		try {
		BufferedReader br = new BufferedReader(new FileReader(input));
		String inputLine = null;
		while ((inputLine = br.readLine()) !=null) {
			if(!"".equals(inputLine) && !inputLine.contains("#")){
				 list.add(getEmployee(inputLine));
			}
		}
		br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
