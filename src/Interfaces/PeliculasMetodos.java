package Interfaces;

import java.util.List;

import Models.Peliculas;

public interface PeliculasMetodos {

	public void guardar(Peliculas pelicula);
	public List<Peliculas> mostrar();
	public Peliculas buscar(String nombre);
	public void eliminar(String nombre);
	public List<Peliculas> buacarCategoria(String categoria);
	public float calcularInvertido();
	
	
	
}
