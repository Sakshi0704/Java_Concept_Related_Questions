package com.entities;

import javax.persistence.Entity;

@Entity
public class DayScholar extends Student {

	private double transportFee;
	
	public double getTransportFee() {
		return transportFee;
	}

	public void setTransportFee(double transportFee) {
		this.transportFee = transportFee;
	}



	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		super.displayDetails();
		System.out.print(" studentTrnasportFee : " + this.getTransportFee());
	}

	@Override
	public double payFee() {
		return this.getTransportFee() + this.getExamFee();
	}

}
