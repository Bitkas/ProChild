package com.DAI.ProChild.RegisterComplaint;

import com.DAI.ProChild.Complaint.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterComplaintRepository extends JpaRepository<Complaint, Integer> {

}
