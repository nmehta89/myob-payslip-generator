package com.company.myob;

public class IncomeTaxUtil {

	public static Double getIncomeTax(Double salary){
		double incomeTax = 0;
		if(salary >=0 && salary <= 18200){
		incomeTax = 0;
		}else if(salary >= 18201 && salary <= 37000){
			incomeTax = (salary - 18201) * 0.19;
		}else if(salary >= 37001 && salary <= 80000){
			incomeTax = 3572 + ((salary - 37001) * 0.325);
		}else if(salary >= 80001 && salary <= 180000){
			incomeTax = 17547 + ((salary - 80001) * 0.37);
		}else if(salary >= 180001){
			incomeTax = 54547 + ((salary -180001) * 0.45);
		}
			
		incomeTax = incomeTax /12;
		return incomeTax;
	}
}
