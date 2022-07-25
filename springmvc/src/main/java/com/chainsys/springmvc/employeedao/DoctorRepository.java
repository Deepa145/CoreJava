package com.chainsys.springmvc.employeedao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Doctor;
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    Doctor findById(int id);
    Doctor save(Doctor dr);
    // Used for adding new doctor
    void deleteById(int id);
    List<Doctor> findAll();
}