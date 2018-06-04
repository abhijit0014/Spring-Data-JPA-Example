package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.jpa.entity.AddressEntity;
import com.spring.jpa.repository.AddressRepository;

@Service
public class AddressService {

	private AddressRepository addressRepository;
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	public AddressEntity add(AddressEntity addressEntity) {
		return addressRepository.save(addressEntity);
	}	
	
	public Optional<AddressEntity> getById(Long id) {
		return addressRepository.findById(id);
	}
	
	public List<AddressEntity> getAll() {
		return addressRepository.findAll();
	}
	
	public void deleteById(Long id) {
		addressRepository.deleteById(id);
	}		
}
