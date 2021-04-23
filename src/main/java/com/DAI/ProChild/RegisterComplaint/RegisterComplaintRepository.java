package com.DAI.ProChild.RegisterComplaint;

import com.DAI.ProChild.Complaint.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterComplaintRepository extends JpaRepository<Complaint, Integer> {
}
