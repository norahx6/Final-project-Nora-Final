package com.example.hrbackend.service;

import com.example.hrbackend.model.Hr;
import com.example.hrbackend.repository.HrRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HrService {
    private final HrRepository hrrepository;
    public List<Hr> get_hr(){

        return hrrepository.findAll();
    }
    public void add_hr(Hr hr) {

        hrrepository.save(hr);
    }


    public void update_hr(Hr hr, Integer id) {
        Hr hr1=hrrepository.getById(id);
        hr1.setCategory(hr.getCategory());
        hr1.setUserId(hr.getUserId());
        hr1.setSummary(hr.getSummary());
        hr1.setYearsOfExperience(hr.getYearsOfExperience());
        hrrepository.save(hr);
    }
    public void delete_hr(Integer id) {
        Hr myHr = hrrepository.getById(id);
        hrrepository.delete(myHr);
    }

}
