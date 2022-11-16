package com.example.motogpprog2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDE {
    private Bike data;
    private NodeDE next;
    private NodeDE previus;

    //se necesita un kid
    public NodeDE(Bike data){;
        this.data=data;

    }

}
