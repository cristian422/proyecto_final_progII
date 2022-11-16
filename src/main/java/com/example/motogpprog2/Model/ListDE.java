package com.example.motogpprog2.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class ListDE {
    private NodeDE head;
    private int size;

    public List<Bike> getList() {
        //creamos un ayudante de tipo NodeDE
        //igualamos el temp a la head
        NodeDE temp = head;
        //creamos una lista que va a guardar objetos de tipo kid
        List<Bike> list = new ArrayList<>();
        //verificamos que la cabeza si contenga algo
        // ya que si es null no se hace nada
        //si la cabeza es diferente de null
        if (head != null) {
            //mientras el ayudante sea diferente de null
            while (temp != null) {
                //agregamos a la lista los datos que contiene el ayudante o temporal
                list.add(temp.getData());
                //el temporal pasa a ser su siguiente
                temp = temp.getNext();
            }


        }
        //retornamos la lista
        return list;
    }

    public String addDE (Bike bike) {
        //si la lista esta vacia simplemente se agrega a la cabeza
        if (head == null) {
            //guardamos al kid en un nodo DE y lo guardamos en la head
            head = new NodeDE(bike, null, null);
        } else {//en caso que la cabeza si contenga alfo
            NodeDE temp = head;//creamos un temporal y lo igualamos a la cabeza
            while (temp.getNext() != null) {//mientras que el siguiente del temporal sea diferente a null
                temp = temp.getNext();//temporal pasa a ser el seguiente

            }
            //Ayudante esta en el ultimo
            //guardamos al kid en un nodo DE
            NodeDE newNode = new NodeDE(bike, null, temp);
            //guardamos al nuevo nodo en el siguiente del temporal
            temp.setNext(newNode);
            //le sumamos uno al tamaño de la lista por el nuevo que se añadio
            size++;


        }//retornamos un mensaje que nos dice que si se pudo añadir al niño
        return "la bike se   agrego";
    }
    public String deletByPosition(int i){//se el ingresa de entrada la posicion del dato a eliminar
        //creamos un temporal de tipo NodeDE
        NodeDE temp=this.head;//igualamos el temporal a la head
        int contador=1;//iniciamos el contador en uno
        if (i==1){//si la posicion ingresada es la primera
            head=temp.getNext();//la cabeza pasa a ser el siguiente del temporal
            head.setPrevius(null);//el anterior del head queda null
        }
        while (contador<i){//hace que llegue a una posicion antes de la indicada
            if (contador==i-1){
                temp.getNext().getNext().setPrevius(temp);//guardamos en el previo del siguiente siguiente al temporal

                temp.setNext(temp.getNext().getNext());//el siguente del temporal pasa a ser siguiente siguiente
                }
            temp=temp.getNext();//el temporal pasa a ser su siguiente
            contador=contador+1;//contador aumenta en uno

        }
        size--;//contrario al size++ en este caso el tamaño se reduce uno
        return "eliminado";
    }
    //metodo agregar por posicion
    // actualizar
    public String updateByPosition(BikeDTO bikeDTO)  {//de entrada se el manda un objeto de tipo bikedto
        NodeDE temp=this.head;//creamos un temporal de nodeDE
        int contador=1;//iniciamos un contador en uno
        //creamos un kid de los datos del kidDTO
        Bike newbike = new Bike(bikeDTO.getBike().getNumberBike(), bikeDTO.getBike().getColor(),bikeDTO.getBike().isState());

        if (bikeDTO.getPosition() == 1) {//si la posicion del DTO es igual a 1 se ingresa de primero
            temp.getData().setNumberBike(newbike.getNumberBike());
            temp.getData().setColor(newbike.getColor());
            temp.getData().setState(newbike.isState());
        }
        while (contador < bikeDTO.getPosition()) {//mientras el contador sea menor a la posicion ingresada
            //hace que se quede en una posicion antes

            if (contador == bikeDTO.getPosition() ) {//contador igual a la posicion menos uno verifica que si este en una posicion antes
                temp.getData().setNumberBike(newbike.getNumberBike());
                temp.getData().setColor(newbike.getColor());
                temp.getData().setState(newbike.isState());
            }
            temp = temp.getNext();//el temporal pasa a ser el siguiente
            contador = contador + 1;//contador aumenta en uno

        }
        size++;//sumamos uno al tamaño
        return "actualizado ";
    }
    //agregar conductor
    //necesito un bikeDTO


    /***
     * bean de aplicacion: uno para todos
     * bean de secion: uno para cada uno
     * bean request: solo cuando se llama
     * localDate time
     *         return "eliminado";
     */

    //consultar informacion de bike
    public Bike consultInformationBike(int position){
        NodeDE temp=this.head;
        int contador=1;
        if (position==1){
            return this.head.getData();
        }
        while (contador!=position){
            temp=temp.getNext();
            contador=contador+1;
        }
        return temp.getData();
    }

    //no esta la clase piloto
    //donde se programa la creacion de una carrera
}
