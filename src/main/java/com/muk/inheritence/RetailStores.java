package com.muk.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
//Needed for Single Table Strategy
//@DiscriminatorValue("RetailStore")
public class RetailStores extends Users{

	private double incentive;
	private String retail_name;
	
	public RetailStores(double incentive, String retail_name) {
		super();
		this.incentive = incentive;
		this.retail_name = retail_name;
	}
	
	
}
