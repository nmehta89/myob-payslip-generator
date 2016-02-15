package com.company.myob;

public class Employee {
	
	private String firstName;
	private String lastName;
	Double salary ;
	float sureRate;
	private Double grossIncome;
	private Double incomeTax;
	private Double netIncome;
	private Double supper;
	private String payPeriod;
	
	public Employee(String firstName , String lastName, Double salary, float sureRate, String payPeriod){
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.sureRate = sureRate;
		setGrossIncome(this.salary);
		setIncomeTax(IncomeTaxUtil.getIncomeTax(salary));
		this.payPeriod = payPeriod;
	}
	
	private void setGrossIncome(Double salary) {
		grossIncome = salary /12;
		grossIncome = adJustDecimal(grossIncome);
	}

	public Double getGrossIncome(){
		return grossIncome;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public float getSureRate() {
		return sureRate;
	}

	public void setSureRate(float sureRate) {
		this.sureRate = sureRate;
	}

	public Double getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(Double incomeTax) {
		this.incomeTax = incomeTax;
		this.incomeTax = adJustDecimal(incomeTax);
		setNetIncome();
		setSupper();
	}
	
	public Double getNetIncome() {
		return netIncome;
	}

	public void setNetIncome() {
		this.netIncome = grossIncome-incomeTax;
		this.netIncome = adJustDecimal(netIncome);
	}

	public Double getSupper() {
		return supper;
	}

	public void setSupper() {
		this.supper = (grossIncome * sureRate) / 100;
		this.supper = adJustDecimal(supper);
	}

	public String toString(){
		String paySlip = firstName +" "+ lastName +","+payPeriod+","+ grossIncome+", "+incomeTax+", "+netIncome+", "+supper;		
		return paySlip;
	}
	
	public Double adJustDecimal(Double val){
		return (double) Math.round(val);
	}
	

}
