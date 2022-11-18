package com.example.motogpprog2.Service;

import com.example.motogpprog2.Model.Bike;
import com.example.motogpprog2.Model.BikeDTO;
import com.example.motogpprog2.Model.ListDE;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class BikeService {
    private ListDE bikes;

    /**
     * public List<Bike> getList(){
     *         return bikes.getList();
     *     }
     *     public String addBike(Bike bike){
     *         bikes.addDE(bike);
     *         return "se agrego";
     *     }
     *     public String delet(B){
     *         return bikes.deletByPosition(i);
     *     }
     *     public String update(BikeDTO bikeDTO){
     *         return  bikes.updateByPosition(bikeDTO);
     *     }
     * @return
     */




}
