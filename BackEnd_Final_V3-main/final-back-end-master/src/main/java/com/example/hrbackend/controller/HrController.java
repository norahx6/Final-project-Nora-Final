package com.example.hrbackend.controller;

import com.example.hrbackend.dto.ApiResponse;
import com.example.hrbackend.model.Hr;
import com.example.hrbackend.service.HrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Hr")
public class HrController {
    public final HrService Hrservice;

    @GetMapping
    public ResponseEntity<List> get_hr(){
        List<Hr> myhr= Hrservice.get_hr();
        return ResponseEntity.status(200).body(myhr);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> addCustomer(@RequestBody @Valid Hr hr){
        Hrservice.add_hr(hr);
        return ResponseEntity.status(200).body(new ApiResponse("HR added",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCustomer(@RequestBody @Valid Hr hr,@PathVariable Integer id){
        Hrservice.update_hr(hr,id);
        return ResponseEntity.status(200).body(new ApiResponse("HR updated,",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Integer id){
        Hrservice.delete_hr(id);
        return ResponseEntity.status(200).body(new ApiResponse("HR deleted",200));

    }


}
