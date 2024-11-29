package examenPGR1;

import java.time.LocalDate;

public class NaveEspacial {

	private String Nombre;
	private int AñoCreacion;
	private int AñoLanzamiento;
	private int Capacidad;
	private int Tripulantes;

	public NaveEspacial() {
		this.Nombre="";
		this.AñoCreacion=0;
		this.AñoLanzamiento=0;
		this.Capacidad=0;
		this.Tripulantes=0;
	}
	public NaveEspacial(String n, int ac, int al, int c, int t) {
		this.Nombre=n;
		this.AñoCreacion=ac;
		this.AñoLanzamiento=al;
		this.Capacidad=c;
		this.Tripulantes=t;
	}
	
	
	
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getAñoCreacion() {
		return AñoCreacion;
	}
	public void setAñoCreacion(int añoCreacion) {
		AñoCreacion = añoCreacion;
	}
	public int getAñoLanzamiento() {
		return AñoLanzamiento;
	}
	public void setAñoLanzamiento(int añoLanzamiento) {
		AñoLanzamiento = añoLanzamiento;
	}
	public int getCapacidad() {
		return Capacidad;
	}
	public void setCapacidad(int capacidad) {
		Capacidad = capacidad;
	}
	public int getTripulantes() {
		return Tripulantes;
	}
	public void setTripulantes(int tripulantes) {
		Tripulantes = tripulantes;
	}
	@Override
	public String toString() {
		return "NaveEspacial [Nombre=" + Nombre + ", AñoCreacion=" + AñoCreacion + ", AñoLanzamiento=" + AñoLanzamiento
				+ ", Capacidad=" + Capacidad + ", Tripulantes=" + Tripulantes + "]";
	}
	
	
	
	public int calcularAntiguedad(int añoActual) {
		 añoActual=LocalDate.now().getYear();
		return añoActual-this.AñoCreacion;
	}
	
	public boolean admitePasajeros() {
		if((this.Capacidad-this.Tripulantes)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
