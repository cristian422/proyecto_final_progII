package com.example.motogpprog2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
/**
 * iniciar carrera: Metodos
 * caida piloto
 * adelantar
 * perder posicion
 * salir de carrera
 */
public class Race {
    private Clasification clasification;
    private String state;
    private ListDE listDE;

    public String mostrarCorredores(){
        return this.state="carrera iniciada";
    }
    public void  classificate(){}

}
