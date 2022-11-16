package com.example.motogpprog2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Data
public class UserDTO {
    private User user;
    private Bike bike;
}
