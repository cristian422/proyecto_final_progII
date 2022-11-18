package com.example.motogpprog2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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

    public Race() {

    }

    //me dice si el usuario si tiene los permisos o no
    public String makerace(User user){
        if(user.getRol().getCode().equals("001")){

            return this.state="carrera creada";
        }
        return "no tiene los permisos";
    }

    /**
     * bikes=new ListDE();
     *         bikes.addDE(new Bike("004","negro",true));
     *         bikes.addDE(new Bike("005","morado",false));
     *
     *         cual es la mejor practica??
     */
    public List<Bike> obtenerlista(){
        //me da la lista de los corredores
        for (int i = 0; i < clasification.getGrill().size()-1; i++) {
            System.out.println(listDE.addDE(clasification.getGrill().get(i).getBike()));
            listDE.addDE(clasification.getGrill().get(i).getBike());

        }
        return listDE.getList();

    }
    public List<Bike> adelantarPosicion(BikePosition bikePosition){//ingreso bikedto
        NodeDE temp=listDE.getHead();
        //contador es el numero de la posicion en la que se encuentra la bike
        //por el momento se le da uno para iniciarla mas adelante el for le da la verdadera posicion
        int contador=1;
        //
        if(bikePosition.position>=listDE.getSize()){//si las posiciones a adelatar son mayores o iguales a la lista queda de prumero
            /**
             * el proceso pensado es:
             * si la cantidad de posiciones a adelantar es mayor o igual a la cantidad de conductores va a quedar de primero
             * uso un metodo que me extrae los datos de la bike
             * la cual la uso paras sacarla de la posicion en la que esta y despues eliminarla
             * ya que si no la elimino y simplemente la agrego quedaria dos veces
             * y si la eliminio sin guardar perderia los datos de la bike y despues no podria agregarla al inicio
             */
            Bike guardabike=listDE.obtenerbike(bikePosition.bike.getNumberBike());
            listDE.deletByPosition(bikePosition.bike);
            listDE.addToStart(guardabike);
        }else {
            /**
             * primero se necesita saber que tan atras esta la bike
             * por lo que el while es mientras el numero de la bike que es unico para cada uno
             * sean dimerentes va a ir sumando uno al contador que me va a decir desde que posicion
             * esta en ese momento la bike.
             * cuando entra al for va hasta que se adelante la cantidad de posiciones que se ingreso
             *  se repite casi el mismo procedimiento anterior
             *  pero en este el agregar por posicion
             *  le ingreso la bike que va a ingresar no se repetira ya que fue eliminada de la posicion
             *  en la que estaba pero se guardaron sus datos para ingresarla despues
             *  y la poscicion en la que se va a ingresar sera la resta de la posicion en la que esta
             *  y la cantidad de posiciones que va a adelantar
             *
             */
            while (temp.getData().getNumberBike().equals(bikePosition.bike.getNumberBike())!=false){
                contador=contador+1;
                temp=temp.getNext();
            }
                Bike guardabike=listDE.obtenerbike(bikePosition.bike.getNumberBike());
                listDE.deletByPosition(bikePosition.bike);
                listDE.addByPosition(new BikePosition(guardabike,contador- bikePosition.position));
                contador=contador-1;

        }

        return listDE.getList();
    }


}
