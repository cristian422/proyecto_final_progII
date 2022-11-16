package com.example.motogpprog2.Service;

import com.example.motogpprog2.Model.Bike;
import com.example.motogpprog2.Model.BikeDTO;
import com.example.motogpprog2.Model.Clasification;
import com.example.motogpprog2.Model.Race;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class RaceService {
    private List<Race> races;
    private List<Clasification> clasifications;
    @Autowired
    private BikeService bikeService;

    public List<Bike> showBikes(){
        return bikeService.getList();
    }
    public String agregar(Bike bike){
        return bikeService.addBike(bike);
    }
    public String delet(int i){
        return bikeService.delet(i);
    }
    public String update(BikeDTO bike){
        return bikeService.update(bike);
    }
}
