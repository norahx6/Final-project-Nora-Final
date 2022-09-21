package com.example.hrbackend.service;

import com.example.hrbackend.model.Customer;
import com.example.hrbackend.model.Hr;
import com.example.hrbackend.model.Meeting;
import com.example.hrbackend.model.User;
import com.example.hrbackend.repository.CustomerRepository;
import com.example.hrbackend.repository.HrRepository;
import com.example.hrbackend.repository.meetingRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class meetingService {
    public final meetingRepository meetingrepository;
    public final HrRepository hrRepository;
    public  final CustomerRepository customerRepository;

    public  List<Meeting> getMeetingsByUserId(Integer userId) {
        List<Meeting> meetings= meetingrepository.findAllByCustomerId(userId);
        return meetings;
    }


    public List<Meeting> get_meeting(){

        return meetingrepository.findAll();
    }
    public void add_meeting(Meeting meeting, User user){
        meeting.setCustomerId(user.getId());
        meetingrepository.save(meeting);

    }
    public void update_meeting (Meeting meeting, Integer id){
        Meeting oldm=meetingrepository.findMeetingById(id);
       // oldm.setTime(meeting.getTime());
        oldm.setLink(meeting.getLink());
        meetingrepository.save(oldm);
    }

    public void delete_order(Integer id){
        Meeting meeting=meetingrepository.getById(id);
        meetingrepository.delete(meeting);
    }

    // find order by hr id nora
     public  List<Meeting> getMeetingsByHr(User user) {
        Hr hr= hrRepository.findByUserId(user.getId());
            List<Meeting> meetings= meetingrepository.findMeetingByHrId(hr.getId());
            return meetings;
     }

//    public  List<Meeting> getMeetingsByCustomer(User user) {
//        Customer customer= customerRepository.findByUserId(user.getId());
//        List<Meeting> meetings= meetingrepository.findMeetingByCustomerId(customer.getId());
//        return meetings;
//    }


}