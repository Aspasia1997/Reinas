/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8reinas;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Entradas {
    
         int tablero [][] = new int [8+1][8+1];
         String entrada [] = new String [8+1];
         
                 
        String[] arr_con_parentesis;
        String[] arr_sin_parentesis = new String[8 + 1];
    
         String[] xy; // pa las cordenadas xd
         String x,y;
       
         int num_x,num_y, sizeTab = 8, atacante_x, atacante_y;
         private int contador_reinas = 0;
         
          int text_input;
          String valor_ingresado;
          
          Scanner input_coordenadas = new Scanner(System.in);
          
          Boolean reiniciar = true;
          
          public void Principal() {
            while(reiniciar){
            
                System.out.print("INSTRUCCIONES: " + "\n1.- Mantener el formato como este : [\"(1,1)\",\"(2,5)\",\"(3,8)\",\"(4,6)\",\"(5,3)\",\"(6,7)\",\"(7,2)\",\"(8,4)\"]\n");

                System.out.print("\n2. - Ingresar las 8 posiciones como el ejemplo de arriba: ");

                valor_ingresado = input_coordenadas.next(); 

                try {

                    String expSubString = valor_ingresado.substring(2,63);

                    arr_con_parentesis = expSubString.split ("\",\"");
                    String part1 = arr_con_parentesis[0];

                    System.out.print("\n");

                    reiniciar = false;
                    Algoritmo(tablero);
                    Imprime(tablero);
                    
                    if(contador_reinas == 8){
                     System.out.println("GANASTE ninguna reina choca en diagonal, columna o vertical / horizontal");
                    }



                }catch(Exception ex){
                    System.out.println("    Agrega una entrada similar a las instrucciones!!!     ");
                }
            }
          
          }
          
          
                 public void Algoritmo(int tab[][] ){    
            
            int status = 1;                      

            for(int num=0; num<arr_con_parentesis.length;num++){
                
                arr_sin_parentesis[num+1] = arr_con_parentesis[num];
                
                String a = arr_sin_parentesis[num+1].substring(1,4);
                
                String[] xy = a.split(",");
                x = xy[0];
                y = xy[1];
                num_x = Integer.parseInt(x);
                num_y = Integer.parseInt(y);
                
                
                if ( tab[num_x][num_y] == 0 ) {   
               
                    for ( int i = 1; i <= sizeTab; i++ ){
                        for ( int j = 1; j <= sizeTab; j++ ) { 

                            if ( tab[i][j]  != 0) {  //Evalua que no exista cero al recorrer, es decir ubica una reina cercana
                            // Evalua si la reina ataca en misma columna o fila
                                if ((( num_x == i) || (num_y == j ))  || (Math.abs(num_x - i) == Math.abs(num_y - j )) ) {

                                    status = 2;
                                    atacante_x = i;
                                    atacante_y = j;
                                    break;
                                }
                                
                            }
                        }
                        
                    }

                } else{
             
                    
                    status = 0;

                    break;
                }
                
                if ( status == 0){
                    System.out.println("Fallaste con los numeros: " + num_x + "  " + num_y);
                }else if (status == 2){
                    System.out.println("La Reina en la posicion: " + "(" + atacante_x + "," + atacante_y + ")" + " Te ha derrotado, intenta cambiar la ubicacion: " + "("  + num_x + "," + num_y + ")");
                    System.out.println("\n");
                    break;
                }else{
                  
                    tablero[num_x][num_y] = ++contador_reinas; //registra el numero de reina en la posicion
              }
                
                
            }
  
        }

        public void Imprime(int tablero_final[][]) {      
            //sentencia para imprimir las reinas
            for ( int k = 1; k <= sizeTab; k++ ) {
                for ( int j = 1; j <= sizeTab; j++) {
                    System.out.printf("%5d", tablero_final[k][j]);
                } 
                System.out.println("\n");
            }

        }
    
    }
          
          

          
          





        

