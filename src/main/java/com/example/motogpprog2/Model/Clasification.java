package com.example.motogpprog2.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Clasification {
    private String description;
    private List<BaikeClasifDTO> grill;
    private boolean state;

    public Clasification(){
        this.grill=new ArrayList<>();
        grill.add(new BaikeClasifDTO(new Bike("1","red",true),(float) 1.45));
        grill.add(new BaikeClasifDTO(new Bike("2","green",true),(float) 2.45));
    }

    public String addBiker(BaikeClasifDTO baikeClasifDTO){
        grill.add(baikeClasifDTO);
        return "se agrego ";
    }

    public List<BaikeClasifDTO> getGrill() {

        return grill;
    }
}
