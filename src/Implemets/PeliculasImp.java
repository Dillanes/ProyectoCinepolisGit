package Implemets;

import java.util.ArrayList;
import java.util.List;

import Interfaces.PeliculasMetodos;
import Models.Peliculas;

public class PeliculasImp implements PeliculasMetodos {

	private List<Peliculas> listaPeliculas= new ArrayList<Peliculas>();
	private List<Peliculas> pCategoria = new ArrayList<Peliculas>();
	float invertido;

	// Validar que el nombre no se repita
	@Override
	public void guardar(Peliculas pelicula) {

		if(listaPeliculas.size() > 0) {
			for (Peliculas p : listaPeliculas) {

				if (p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
					System.out.println("Pelicula ya registrada");
					break;
				}

			}
		}
		

			listaPeliculas.add(pelicula);
			System.out.println("Se guardo la pelicula");


	}

	@Override
	public List<Peliculas> mostrar() {
		// TODO Auto-generated method stub
		return listaPeliculas;
	}

	@Override
	public Peliculas buscar(String nombre) {

		for (int i = 0; i < listaPeliculas.size(); i++) {
			if (listaPeliculas.get(i).getNombre().equalsIgnoreCase(nombre)) {
				return listaPeliculas.get(i);
			}
		}
		return null;

	}

	@Override
	public void eliminar(String nombre) {
		Peliculas peliculaEnc = buscar(nombre);

		if (peliculaEnc != null) {
			listaPeliculas.remove(peliculaEnc);
			System.out.println("Se elimino la pelicula: " + peliculaEnc);

		} else {
			System.out.println("No se encontro la pelicula");
		}

	}

	@Override
	public List<Peliculas> buacarCategoria(String categoria) {
		
		pCategoria.removeAll(pCategoria);
		listaPeliculas = mostrar();
		

		for (int i = 0; i < listaPeliculas.size(); i++) {
			if (listaPeliculas.get(i).getCategoria().equalsIgnoreCase(categoria)) {
				
				pCategoria.add(listaPeliculas.get(i));
			}
		}

		if (pCategoria != null)
			return pCategoria;
		else
			return null;
	}

	@Override
	public float calcularInvertido() {
		invertido = 0;

		for (int i = 0; i < listaPeliculas.size(); i++) {
			invertido += listaPeliculas.get(i).getPrecio();
		}

		return invertido;
	}

}
