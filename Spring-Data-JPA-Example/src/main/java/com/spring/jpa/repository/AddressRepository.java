package com.spring.jpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.jpa.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

}
