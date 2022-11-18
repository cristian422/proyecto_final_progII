package com.example.motogpprog2.Controller;
import com.example.motogpprog2.Model.*;
import com.example.motogpprog2.Service.RaceService;

import com.example.motogpprog2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "races")
public class RaceController {
    @Autowired
    private RaceService raceService;
    @Autowired
    private UserService userService;

    /**
     * @GetMapping
     *     public List<Bike> getBikes(){
     *         return raceService.showBikes();
     *     }
     *
     *     @PostMapping(path = "addbike")
     *     public String agregar(@RequestBody UserDTO userDTO){
     *         if(userService.verifyAccess(userDTO.getUser())){
     *             return raceService.agregar(userDTO.getBike());
     *         }
     *         return "no tiene los permisos para esta opcion";
     *     }
     *     @PostMapping(path = "delete")
     *     public String delet(@RequestBody int i){
     *         return raceService.delete(i);
     *     }
     *     @PostMapping(path = "updatebike")
     *     public String update(@RequestBody BikeDTO bikeDTO){
     *         return raceService.update(bikeDTO);
     *     }
     * @return
     */


    @PostMapping(path = "makegrill")
    public List<BaikeClasifDTO> makeGrill(){
        return raceService.makeGrill();
    }

    @PostMapping(path = "makerace")
    public Race makerace(@RequestBody User user){
        return raceService.makerace(user);
    }
    @PostMapping(path = "toassignClasifiction")
    public String toassignClasifiction(){
        return raceService.toassignClasifiction();
    }
    @PostMapping(path = "obtenerlista")
    public List<Bike> obtenerlista(){
        return raceService.obtenerlista();
    }
    @PostMapping(path = "advance")
    public List<Bike>advance(@RequestBody BikePosition bikePosition){return raceService.advance(bikePosition);}


}
