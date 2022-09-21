package com.example.hrbackend.repository;

import com.example.hrbackend.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface meetingRepository extends JpaRepository<Meeting,Integer> {
    Meeting findMeetingById(Integer id);

    //    find order by hr id rahaf
    List<Meeting> findAllByCustomerId(Integer id);

    //List<Meeting> findMeetingByCustomerId(Integer customerId);


    //find order by hr id nora
    List<Meeting> findMeetingByHrId(Integer hrId);


}
