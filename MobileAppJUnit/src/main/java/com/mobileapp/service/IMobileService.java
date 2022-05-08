package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface IMobileService {
	Mobile getById(int mobileId) throws MobileNotFoundException;
	List<Mobile> getByBrand(String brand)throws MobileNotFoundException;
}
