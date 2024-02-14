package com.in28minutes.learnspringaop.aop.data;

import org.springframework.stereotype.Repository;

import com.in28minutes.learnspringaop.aop.annotations.TrackTime;

@Repository
public class DataServicce2 {
	
	@TrackTime
	public int[] retrieveData() {
		return new int [] {111,222,333,444,555};
	}

}
