package com.entities;

import javax.persistence.Entity;

@Entity
public class Hosteller extends Student {

	private double hostelFee;

	public double getHostelFee() {
		return hostelFee;
	}

	public void setHostelFee(double hostelFee) {
		this.hostelFee = hostelFee;
	}

	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		super.displayDetails();
		System.out.print(" studentHostelFee : " + this.getHostelFee());

	}

	@Override
	public double payFee() {
		// TODO Auto-generated method stub
		return this.getHostelFee() + this.getExamFee();
	}

}
