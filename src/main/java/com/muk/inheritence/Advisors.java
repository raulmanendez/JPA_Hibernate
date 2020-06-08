package com.muk.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
//Needed for Single Table Strategy
//@DiscriminatorValue("DirectSeller")
public class Advisors extends Users {

	private double commission;
	private String isPayable;
	
	public Advisors(double commission, String isPayable) {
		super();
		this.commission = commission;
		this.isPayable = isPayable;
	}
	
	
}
