package com.chainsys.springmvc.employeedao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Appointment;
public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {
    Appointment findById(int id);
    Appointment save(Appointment app);
    // Used for adding new doctor
    void deleteById(int app_id);
    List<Appointment> findAll();
    //TODO native query
    int getNextId();
}