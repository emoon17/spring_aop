package com.in28minutes.learnspringaop.aop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28minutes.learnspringaop.aop.annotations.TrackTime;
import com.in28minutes.learnspringaop.aop.data.DataServicce1;


@Service
public class BusinessService1 {
	
	private DataServicce1 dataService1;
	public BusinessService1 (DataServicce1 dataService1) {
		this.dataService1 = dataService1;
	}
	
	
	@TrackTime
	public int calculateMax() {
		int[] data =dataService1.retrieveData();
		
		//throw new RuntimeException("Something Went Wrong!");
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//최댓값
		return Arrays.stream(data).max().orElse(0);
	}
	
	
	
	//Basic Logic

}
