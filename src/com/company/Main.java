package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import clases.CapacidadEndedudamiento;
import clases.Constante;

public class Main {
    //Recuerda que aca empieza todo
    public static void main(String[] args) {
    	
    	String entrada;
    	
    	//Con este objeto de la clase Scanner puedes capturar informacion por consola cada ves que lo uses
		// recuerda cerrar el flujo de consulta cada ves lo uses sobre para que los uses in.close()
		Scanner in = new Scanner(System.in);
	    //Esto te dara la primera entrada al proceso de solicitar los datos para instancir nuestro objeto
	    // CapacidadEndedudamiento()
		CapacidadEndedudamiento capacidadEndeudamiento = new CapacidadEndedudamiento();
		Constante constante = new Constante();
			
		entrada = "SI";
		
		while (entrada.equals("SI")) {
			
		    //Valida las entradas de los usuarios que no vayas a convertir una "A" numero y el calculo no te funcione
		    //Utiliza el metodo is numeric para vada entrada de ser necesarios
			try {
				
				System.out.println(constante.mensajeIngreso() +  "ingresos mensuales");
				String ingresosTotales = in.next();
				
				if (isNumeric(ingresosTotales)) {
					
					capacidadEndeudamiento.setIngresosTotales(Integer.parseInt(ingresosTotales));
					
					System.out.println(constante.mensajeIngreso() + " gastos fijos");
					String gastosFijos = in.next();
					
					if (isNumeric(gastosFijos)) {
						
						capacidadEndeudamiento.setGastosFijos(Integer.parseInt(gastosFijos));
						
						System.out.println(constante.mensajeIngreso() + " gastos variable");
						String gastosVariables = in.next();
						
						if (isNumeric(gastosVariables)) {
							
							capacidadEndeudamiento.setGastoVaribales(Integer.parseInt(gastosVariables));
							
							System.out.println("Su capacidad de endeudamiento es de: " +capacidadEndeudamiento.getCapacidadEndeudamiento());
							
							System.out.println(constante.mensajePeticion());
							entrada = in.next();
						}
						else {
							System.out.println(constante.mensajeError());
							System.out.println(constante.mensajePeticionErr());
							entrada = in.next();
						}		
					}
					else {
						System.out.println(constante.mensajeError());
						System.out.println(constante.mensajePeticionErr());
						entrada = in.next();
					}
				}
				else {
					System.out.println(constante.mensajeError());
					System.out.println(constante.mensajePeticionErr());
					entrada = in.next();
				}
		 
			}
			catch(NumberFormatException | InputMismatchException e) {
				System.out.println(constante.mensajeError());

			}

		}
		
    }
    	

    public static boolean isNumeric(String value) {
        // implementa un bloque try catch aca
    	try {
    		Integer.parseInt(value);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}  	
    	

   }
    
 
}
