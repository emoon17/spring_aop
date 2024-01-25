package com.in28minutes.learnspringaop.aop.data;

import org.springframework.stereotype.Repository; 

import com.in28minutes.learnspringaop.aop.annotations.TrackTime;

@Repository
public class DataServicce1 {
	
	
	
	@TrackTime
	public int[] retrieveData() {
		return new int [] {11,22,33,44,55};
	}

}
