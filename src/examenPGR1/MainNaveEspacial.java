package examenPGR1;

import java.util.Scanner;

public class MainNaveEspacial {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System .in);
		NaveEspacial a[]= new NaveEspacial[50];
		int menu=0;
		int contador=0;
		do {
			menu=menu(teclado);
			switch(menu) {
			case 1:
				contador=introducir(teclado, a, contador);
				break;
			case 2:
				if (contador>0) {
					mostrarMayor( teclado,contador,a);
				}else {
					System.out.println("No hay Naves");
				}			
				break;
			case 3:
				if (contador>0) {
					ordenLanzamiento(a,contador);
				}else {
					System.out.println("No hay Naves");
				}			
				break;
			case 4:
				if (contador>0) {
					modificar( teclado,a,contador);
				}else {
					System.out.println("No hay Naves");
				}			
				break;
			case 5:
				if (contador>0) {
					mostrar(a, contador);
				}else {
					System.out.println("No hay Naves");
				}			
				break;
			case 6:
				if (contador>0) {
					contador=eliminar( teclado,a,contador);
				}else {
					System.out.println("No hay Naves");
				}			
				break;
			case 7:
				System.out.println("Hasta la vista!");

				break;

			}
		}while (menu!=7);
	}

	public static int menu(Scanner teclado) {
		int menu;
		System.out.println("---- MENU ----");
		System.out.println("1. Añadir naves espaciales");
		System.out.println("2. Mostrar naves cuya antiguedad sea superior a una dada");
		System.out.println("3. Ordenar naves por año de lanzamiento");
		System.out.println("4. Modificar Capacidad Total de las naves que admiten Pasajeros");
		System.out.println("5. Mostrar todas las naves espaciales registradas");
		System.out.println("6. Eliminar una nave espacial");
		System.out.println("7. Salir");
		menu = teclado.nextInt();
		return menu;
	}

	public static int introducir(Scanner teclado, NaveEspacial a[], int contador) {
		String respuesta="";
		String Nombre;
		if (contador>a.length) {
			System.out.println("Error. No puedes introducir más Naves ");
		}else {
			for (int i = contador; i < a.length && !respuesta.equalsIgnoreCase("no"); i++) {
				NaveEspacial a1=new NaveEspacial();
				a[i]=a1;
				System.out.println("Introduce el nombre de la nave:");
				Nombre=teclado.next();
				if(buscarNombre(teclado,Nombre,a,contador)==-1) {
					a[i].setNombre(Nombre);
					System.out.println("Introduce el año de creacion:");
					a[i].setAñoCreacion(teclado.nextInt());
					System.out.println("Intorduce el año de lanzamiento:");
					a[i].setAñoLanzamiento(teclado.nextInt());

					while(a[i].getAñoLanzamiento()<a[i].getAñoCreacion()) {
						System.out.println("Error: el año de lanzamiento no puede ser anterior al año de creacion");
						System.out.println("Intorduce el año de lanzamiento:");
						a[i].setAñoLanzamiento(teclado.nextInt());
					}

					System.out.println("Introduce la capacidad total de personas:");
					a[i].setCapacidad(teclado.nextInt());
					System.out.println("Introduce el numero de tripulantes necesarios:");
					a[i].setTripulantes(teclado.nextInt());
					System.out.println("Nave añadida existosamente");
					contador++;
				}else {
					System.out.println("Ya hay una nave con ese nombre ");
				}
				do {
					System.out.print("Quieres seguir introduciendo naves? ");
					respuesta = teclado.next();

					if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("sí") && !respuesta.equalsIgnoreCase("no")) {
						System.out.println("Las opciones válidas son Si/No");
					}
				} while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("sí") && !respuesta.equalsIgnoreCase("no"));
			}
		}
		return contador;
	}

	public static int buscarNombre(Scanner teclado,String Nombre, NaveEspacial a[], int contador) {
		for (int i=0; i<contador;i++) {
			if(Nombre.equalsIgnoreCase(a[i].getNombre())) {
				return i;
			}
		}
		return -1;
	}	

	public static void mostrarMayor(Scanner teclado, int contador, NaveEspacial a[]) {
		int antiguedad;
		boolean hay=false;
		System.out.println("Introduce la antiguedad minima:");
		antiguedad = teclado.nextInt();
		for (int i=0; i<contador;i++) {
			if (a[i].calcularAntiguedad(i)>=antiguedad) {
				hay =true;
				System.out.println(a[i].toString());
			}
		}
		if (!hay) {
			System.out.println("No se han encontrado naves con una antiguedad superior a "+antiguedad);
		}
	}

	public static void ordenLanzamiento(NaveEspacial a[], int contador) {
		NaveEspacial sigNav=new NaveEspacial();
		for(int i=0; i<a.length-1; i++){
			for(int j=0; j<(a.length-1-i) && a[j+1]!=null; j++){ 
				if(a[j].getAñoLanzamiento()<a[j+1].getAñoLanzamiento()){ 
					sigNav=a[j];
					a[j]=a[j+1];
					a[j+1]=sigNav;
				}   
			}
		}

		mostrar(a,contador);
	}

	public static void mostrar( NaveEspacial[] a, int contador) {
		for (int i=0;i<contador;i++) {
			System.out.println(a[i].toString());
		}
	}

	public static int buscarPorNombre(Scanner teclado, NaveEspacial a[], int contador) {
		String Nombre;
		Nombre=teclado.next();
		for (int i=0; i<contador;i++) {
			if(Nombre.equalsIgnoreCase(a[i].getNombre())) {
				return i;
			}
		}
		return -1;
	}

	public static int eliminar(Scanner teclado, NaveEspacial a[], int contador) {
		int pos=0;
		System.out.println("Introduce el nombre de la nave que deseas eliminar?");
		pos=buscarPorNombre(teclado, a, contador);
		if (pos==-1) {
			System.out.println("No se encontro ninguna nave con ese nombre ");
		}else {
			a[pos]=null;
			contador--;
			System.out.println("Nave eliminada correctamente");
			for (int i=pos;i<contador;i++) {
				a[i]=a[i+1];
			}
			a[contador]=null;
		}

		return contador;	
	}

	public static void modificar(Scanner teclado, NaveEspacial a[], int contador) {
		String cambiar;
		int nuevacapacidad;
		for (int i=0;i<contador;i++) {
			if(a[i].admitePasajeros()) {
				System.out.println(a[i].toString());
				System.out.println("Desea cambiar la capacidad total de la nave?");
				cambiar=teclado.next();
				if(cambiar.equalsIgnoreCase("si")) {
					System.out.println("Introduce la nueva capacidad para la nave "+a[i].getNombre());
					nuevacapacidad=teclado.nextInt();
					if(nuevacapacidad<a[i].getTripulantes()) {
						System.out.println("Error: La nueva capacidad no puede ser menor que el numero de tripulantes necesarios");
					}
					else {
						a[i].setCapacidad(nuevacapacidad);
					}
				}
			}
		}
	}


}
