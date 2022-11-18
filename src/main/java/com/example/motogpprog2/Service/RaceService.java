package com.example.motogpprog2.Service;

import com.example.motogpprog2.Model.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class RaceService {
    private List<Race> races;

    private List<Clasification> clasifications;
    @Autowired
    private BikeService bikeService;

    public RaceService(){
        List<Clasification> newClasificacion=new ArrayList<>();
        List<Race> newRace=new ArrayList<>();
        newClasificacion.add(new Clasification());
        newRace.add(new Race());
        this.races=newRace;
        this.clasifications=newClasificacion;


    }

    /**
     * public List<Bike> showBikes(){
     *         return bikeService.getList();
     *     }
     *     public String agregar(Bike bike){
     *         return bikeService.addBike(bike);
     *     }
     *     public String delete(int i){
     *         return bikeService.delet(i);
     *     }
     *     public String update(BikeDTO bike){
     *         return bikeService.update(bike);
     *     }
     *
     * @return
     */


    //me devuelve la grilla ordenada
    public List<BaikeClasifDTO> makeGrill(){
        System.out.println(clasifications.size());
        if (clasifications.size()==1){

            return clasifications.get(0).getGrill();
        } else  {
            clasifications.get(clasifications.size()-1).setState(false);
            clasifications.add(new Clasification(clasifications.get(clasifications.size()-1).getGrill()));
            return clasifications.get(clasifications.size()-1).getGrill();
        }
    }


    /**
     * para iniciar una carrera se comprueba que tenga los permiso correctos
     * y se toma la ultima carrera que se tenga en la lista
     *
     * @param user
     * @return
     */
    public Race makerace(User user){
        if (races.size()==1){
            races.get(0).makerace(user);
            return races.get(races.size()-1);
        }else {
            races.get(getRaces().size()-1).makerace(user);
            return races.get(getRaces().size()-1);
        }

    }

    /**
     *
      * @return
     */
    public String toassignClasifiction(){
        if (races.get(getRaces().size() - 1).getState()==null) {
            return "no se a creado una carrera";
        }
        if(races.get(getRaces().size()-1).getState().equals("carrera creada")) {
            races.get(races.size() - 1).setClasification(clasifications.get(clasifications.size() - 1));
            return "se asigno correctamente la clasificacion a la carrera";
        }
        return "no se a creado una carrera";
    }

    /**
     * bikes=new ListDE();
     *         bikes.addDE(new Bike("004","negro",true));
     *         bikes.addDE(new Bike("005","morado",false));
     *
     *         cual es la mejor practica??
     */
    public List<Bike> obtenerlista(){
       return races.get(getRaces().size()-1).obtenerlista();
    }

    public List<Bike> advance(BikePosition bikePosition){
        return races.get(getRaces().size()-1).adelantarPosicion(bikePosition);
    }

}
