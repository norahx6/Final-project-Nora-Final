package com.example.hrbackend.controller;

import com.example.hrbackend.dto.ApiResponse;
import com.example.hrbackend.model.Meeting;
import com.example.hrbackend.model.User;
import com.example.hrbackend.service.meetingService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth/meet")
public class meetingController {
    public final meetingService meetingservice;

    @GetMapping
    public ResponseEntity<List> getMeeting(@AuthenticationPrincipal User user){
        return ResponseEntity.status(HttpStatus.OK).body(meetingservice.getMeetingsByUserId(user.getId()));
    }



    @PostMapping
    public ResponseEntity<ApiResponse> addMeeting(@RequestBody Meeting meeting, @AuthenticationPrincipal User user){
        meetingservice.add_meeting(meeting,user);
        return ResponseEntity.status(200).body(new ApiResponse("Meeting added",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateMeeting(@RequestBody Meeting meeting, @PathVariable Integer id){
        meetingservice.update_meeting(meeting,id);
        return ResponseEntity.status(200).body(new ApiResponse("Meeting updated",200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Integer id){
        meetingservice.delete_order(id);
        return ResponseEntity.status(200).body(new ApiResponse("Meeting deleted",200));
    }

    // find order by hr id
    @GetMapping("/by-hr")
    public ResponseEntity<List<Meeting>>findMeetingByHrId(@AuthenticationPrincipal User user){
        List<Meeting>meetings = meetingservice.getMeetingsByHr(user);
        return ResponseEntity.status(200).body(meetings);
    }

//    // find
//    @GetMapping("/by-customer")
//    public ResponseEntity<List<Meeting>>findMeetingByCustomerId(@AuthenticationPrincipal User user){
//        List<Meeting>meetings = meetingservice.getMeetingsByCustomer(user);
//        return ResponseEntity.status(200).body(meetings);
//
//}






}
