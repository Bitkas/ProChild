package com.DAI.ProChild.Complaint_form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintFormRepository extends JpaRepository<Complaint_Form, Integer> {
}
