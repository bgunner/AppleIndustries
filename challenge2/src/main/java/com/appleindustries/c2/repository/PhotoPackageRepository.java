package com.appleindustries.c2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appleindustries.c2.model.PhotoPackage;

@Repository("photoPackageRepository")
public interface PhotoPackageRepository extends JpaRepository<PhotoPackage, Long> {

	Optional<PhotoPackage> findById(Long id);
	
	List<PhotoPackage> findAll();
}
