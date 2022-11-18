package com.example.motogpprog2.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BaikeClasifDTO {
    private Bike bike;
    private  int time;

    public BaikeClasifDTO(BaikeClasifDTO baikeClasifDTO) {
    }
}
