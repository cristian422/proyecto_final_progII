package com.example.motogpprog2.Controller;
import com.example.motogpprog2.Model.Bike;
import com.example.motogpprog2.Model.UserDTO;
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

    @GetMapping
    public List<Bike> getBikes(){
        return raceService.showBikes();
    }

    @PostMapping(path = "addbike")
    public String agregar(@RequestBody UserDTO userDTO){
        if(userService.verifyAccess(userDTO.getUser())){
            return raceService.agregar(userDTO.getBike());
        }
        return "no tiene los permisos para esta opcion";
    }
    @PostMapping(path = "delet")
    public String delet(@RequestBody int i){
        return raceService.delet(i);
    }
    @PostMapping(path = "updatebike")
    public void update(){

    }

}
