package com.example.motogpprog2.Service;

import com.example.motogpprog2.Model.Rol;
import com.example.motogpprog2.Model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class UserService {
    private List<Rol> roles;

    private List<User> usuarios;


    public UserService(){
        roles=new ArrayList<>();
        usuarios=new ArrayList<>();

        roles.add(new Rol("001","administrador"));
        roles.add(new Rol("002","usuario"));
        usuarios.add(new User("luis@doritos","123",new Rol("001","administrador")));
        usuarios.add(new User("cris@doritos","321",new Rol("002","usuario")));

    }
    public String addRol(Rol rol){
        for (Rol rol1: roles){
            if(rol1.getCode().equals(rol.getCode()) || rol1.getDescription().equals(rol.getDescription())){
                return "no se puede agregar";
            }

        }
        this.roles.add(rol);
        return "se agrego el rol ";

    }

    public List<User> getUsuarios() {
        return this.usuarios;
    }

    public Boolean verifyAccess(User user){
        for (User user1: usuarios){
            if (user1.getRol().getCode().equals(user.getRol().getCode())&& user.getRol().getDescription().equals("administrador")){
                return true;
            }
        }
        return false;

    }
}
