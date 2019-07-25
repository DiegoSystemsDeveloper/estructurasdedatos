/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/*

Modificar las clases necesarias para obtener el numero total de 
bicicletas registradas.

Mostrar el promedio de ganancias de una sucursal

*/

import java.util.*;

class VentaDeBicicletas 
{
   public final static int NUM_SUCURSALES = 5;
   private ArrayList<Bicicleta> Bicicletas;
   private double [] gananciasSucursales;
   private int [] ventasSucursales;
      
   public VentaDeBicicletas ()
   {
    /* TODO: Instanciar la lista y las sucursales */       
       Bicicletas = new ArrayList();
       gananciasSucursales = new double[NUM_SUCURSALES];
       ventasSucursales = new int [NUM_SUCURSALES];
   }
   
   public Bicicleta darBicicletaEnLaPosicion(int pos)
   {
      /* TODO: Entregar un Bicicleta en la posicion ingresada */ 
       return Bicicletas.get(pos);
   }
   
   public double darGananciasDeSucursal( int numSucursal)
   {
      /* TODO: Entregar las ganancias de la sucursal ingresada */
       return gananciasSucursales[numSucursal];
   }
   
   public void agregarBicicleta(String codigo, String marca, int velocidadMaxima)
   {
      /* TODO: Agregar un nuevo Bicicleta a la lista */ 
       Bicicleta bicicleta = new BicicletaRuta(codigo, marca, velocidadMaxima);
       Bicicletas.add(bicicleta);
   }
   
   public void registrarGananciasSucursal( int numSucursal, double ganancias)
   {
	  /* TODO: Asignar a una sucursal determinada las ganancias ingresadas */ 
       gananciasSucursales[numSucursal] += ganancias;
       ventasSucursales[numSucursal] ++;
   }
   
   public int totalBicicletasRegistradas() {
       return Bicicletas.size();
   }
   
   public void promediarVentasSucursales() {
       double promedio;
       
       for(int i = 0; i < NUM_SUCURSALES; i++) {
           promedio = (gananciasSucursales[i]/ventasSucursales[i]);
           
           if(ventasSucursales[i] <= 0) {
               System.out.println("La sucursal " + i + " no tuvo ventas.");
           } 
           else {
               System.out.println("El promedio de la sucursal " + i + " es de: $ " + promedio + ".");
           }
       }
   }
}
abstract class Bicicleta 
{
   private String codigo;
   private String marca;
   
   public Bicicleta (String codigo, String marca)
   {
	  this.codigo = codigo;
	  this.marca = marca;
      
   }
   public String darMarca()
   {
      return marca;
   }
   
   public String darCodigo()
   {
      return codigo;
   }
   
   public abstract String darDescripcion();
   public abstract void acelerar();
   public abstract void frenar();
   /* TODO: Definir método abstracto para acelerar */    
   /* TODO: Definir método abstracto para frenar */    
}

class BicicletaRuta extends Bicicleta{
	
	private int velocidadMaxima;
	private int velocidad = 0;
	
	public BicicletaRuta(String codigo, String marca, int velocidadMaxima){
	/* TODO: Asignar los valores de entrada a los atributos */ 
            super(codigo, marca);
            this.velocidadMaxima = velocidadMaxima;
	}
	
        @Override
	public String darDescripcion(){	
        /* TODO: Retornar mensaje con el siguiente esquema:
            Bicicleta con código C de la marca: M con velocidad máxima de: V
	*/	
            return "Bicicleta con código: " + this.darCodigo() +
                   " de la marca: " + this.darMarca() + " con velocidad maxima"
                   + " de: " + this.getVelocidadMaxima();
	}
	
	/* TODO: Incrementar la velocidad actual en 5*/		
        @Override
	public void acelerar(){   
            this.setVelocidad(this.getVelocidad() + 5);
	}
	
	/* TODO: Llevar la velocidad a cero*/	
        @Override
	public void frenar(){	
            this.setVelocidad(0);
	}

    /**
     * @return the velocidadMaxima
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * @param velocidadMaxima the velocidadMaxima to set
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
		
}

public class Main 
{
   public static void main (String [] args)
   {
      VentaDeBicicletas registroVentasBicicletas = new VentaDeBicicletas();
      registroVentasBicicletas.agregarBicicleta("A001","GW",120);
      registroVentasBicicletas.agregarBicicleta("A002","Victory",110);
      registroVentasBicicletas.agregarBicicleta("A003","Trek",115);
      registroVentasBicicletas.agregarBicicleta("A004","Gw",105);
      registroVentasBicicletas.agregarBicicleta("A005","Cult",125);
      registroVentasBicicletas.registrarGananciasSucursal(0, 20000.0);
      registroVentasBicicletas.registrarGananciasSucursal(1, 20000.0);
      registroVentasBicicletas.registrarGananciasSucursal(2, 28000.0);
      registroVentasBicicletas.registrarGananciasSucursal(2, 72000.0);
      registroVentasBicicletas.registrarGananciasSucursal(2, 122000.0);
      registroVentasBicicletas.registrarGananciasSucursal(4, 56000.0);
      registroVentasBicicletas.promediarVentasSucursales();
      /* TODO: reemplazar x por el valor adecuado*/	
      System.out.println("La segunda Bicicleta registrada es de la marca "
         + registroVentasBicicletas.darBicicletaEnLaPosicion(1).darMarca() + " y las ganancias de la tercera sucursal fueron "
         + registroVentasBicicletas.darGananciasDeSucursal(2)
         + "\nEl numero de bicletas registradas es de: " + registroVentasBicicletas.totalBicicletasRegistradas());
   } 
}