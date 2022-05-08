package com.mobileapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class MobileServiceImpl implements IMobileService {

	public Mobile getById(int mobileId) throws MobileNotFoundException {
		return showMobiles()
				.stream()
				.filter(mobile->mobile.getMobileId()==mobileId)
				.findFirst()
//		if(mobile1.isPresent())
//			return mobile1.get();
				.orElseThrow(()->new MobileNotFoundException("Mobile Id Not Found"));
//return mobile1;
		//return null;
	}

	public List<Mobile> getByBrand(String brand) throws MobileNotFoundException {
		List<Mobile> mobilesbybrand=showMobiles()
				.stream()
				.filter(mobile->mobile.getBrand().equals(brand))
				.sorted((mobile1,mobile2)->mobile1.getModel().compareTo(mobile2.getModel()))
				.collect(Collectors.toList());
		if(mobilesbybrand.isEmpty())
			throw new MobileNotFoundException("Brand Not found.Try with another brand");
		return mobilesbybrand;
	}
	
	public List<Mobile> showMobiles(){
		return Arrays.asList(
				new Mobile(101,"J7","Samsung",15000),
				new Mobile(102,"Iphone 13","Apple",78000),
				new Mobile(103,"Oppo Reno","Oppo",18000),
				new Mobile(104,"iqoo3","Vivo",20000),
				new Mobile(105,"On Next","Samsung",17000)
				);
	}

}
