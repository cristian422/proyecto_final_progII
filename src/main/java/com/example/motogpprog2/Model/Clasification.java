package com.example.motogpprog2.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Clasification {
    private String description;
    private List<BaikeClasifDTO> grill;
    @Autowired
    private boolean state;

    public Clasification(){
        this.state=true; //iniciamos la clasificacion en true
        this.grill=new ArrayList<>();
        //agrega unas bikes y sus tiempos  en este caso estan desorganizados
        grill.add(new BaikeClasifDTO(new Bike("1","red",true),1));
        grill.add(new BaikeClasifDTO(new Bike("2","green",true),3));
        grill.add(new BaikeClasifDTO(new Bike("4","blue",true),2));
    }

    //este metodo cuando tengo mas de una clasimicacion
    public Clasification(List<BaikeClasifDTO> grill){
        this.state=true;
        this.grill=grill;
    }

    public String addBiker(BaikeClasifDTO baikeClasifDTO){
        grill.add(baikeClasifDTO);
        return "se agrego ";
    }

    //este metodo organiza la grill en orden segun el menor tiempo
    public List<BaikeClasifDTO> sortGrill() {
        //va a ir comparando cual es el mayor y organiza la grilla dejando de primero
        //al bike que tiene el menor tiempo
        for (int i=0;i<=this.grill.size()-1;i++){

            for (int k=0;k<=this.grill.size()-1;k++){
                System.out.println(grill.get(k).getTime());
                if (k<grill.size()-1){
                if(grill.get(k).getTime() > grill.get(k+1).getTime()){
                      BaikeClasifDTO aux=grill.get(k);
                    System.out.println("este es el aux"+aux);
                      grill.set(k,grill.get(k+1));
                      grill.set(k+1,aux);
                    }
                }
            }
        }

        return grill ;
    }


    public List<BaikeClasifDTO> getGrill() {
        return sortGrill();
    }


}
