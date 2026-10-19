package Main;

import java.util.List;
import java.util.Scanner;

import Implemets.PeliculasImp;
import Models.Peliculas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lectura = null;
		String nombre, categoria;
		float precio;
		int estreno, menuPrincipal;

		Peliculas pelicula = null;

		PeliculasImp imp = new PeliculasImp();

		do {
			System.out.println("MENU PRINCIPAL");
			System.out.println("1.- ALTA");
			System.out.println("2.- MOSTRAR");
			System.out.println("3.- BUSCAR POR NOMBRE");
			System.out.println("4.- EDITAR CATEGORIA BUSCAR POR NOMBRE");
			System.out.println("5.- ELIMINAR");
			System.out.println("6.- BUSCAR POR CATEGORIA");
			System.out.println("7.- CALCULAR LO INVERTIDO");
			System.out.println("8.- SALIR");
			lectura = new Scanner(System.in);
			menuPrincipal = lectura.nextInt();

			switch (menuPrincipal) {
			case 1:
				try {
					System.out.println("Registro de Pelicula");

					System.out.println("Agregar nombre: ");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					System.out.println("Ingresa la categoria: ");
					lectura = new Scanner(System.in);
					categoria = lectura.nextLine();

					System.out.println("Ingresa el precio: ");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();

					System.out.println("Ingresa el año: ");
					lectura = new Scanner(System.in);
					estreno = lectura.nextInt();

					// Crear pelicula
					pelicula = new Peliculas(nombre, categoria, precio, estreno);
					// guardar pelicula
					imp.guardar(pelicula);
					
				} catch (Exception e) {
					System.out.println("Se genero un error: " + e.getMessage());
				}
				break;
			case 2:
				if (imp.mostrar().size() > 0)
					System.out.println(imp.mostrar());
				else
					System.out.println("No hay registros");

				break;
			case 3:

				if (imp.mostrar() == null) {
					System.out.println("No hay registros");
					break;
				}
				System.out.println("Ingrese el nombre a buscar: ");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine();
				pelicula = imp.buscar(nombre);

				if (pelicula != null)
					System.out.println(pelicula);
				else
					System.out.println("No existe la pelicula");
				break;
			case 4:
				if (imp.mostrar() == null) {
					System.out.println("No hay registros");
					break;
				}

				try {
					System.out.println("Editar pelicula buscada por nombre");
					System.out.println("Nombre del producto a editar: ");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					pelicula = imp.buscar(nombre);

					if (pelicula != null) {
						System.out.println("Se encontro la pelicula: " + pelicula + " para editar precio");
						System.out.println("Nuevo precio: ");
						lectura = new Scanner(System.in);
						precio = lectura.nextInt();
						pelicula.setPrecio(precio);
						System.out.println("Nuevo precio");
					} else {
						System.out.println("No existe la pelicula");
						break;
					}

				} catch (Exception e) {
					System.out.println("Error al registar pelicula " + e.getMessage());
				}

				break;
			case 5:
				if (imp.mostrar() == null) {
					System.out.println("No hay registros");
					break;
				}

				try {
					System.out.println("Eliminar pelicula buscada por nombre");
					System.out.println("Nombre del producto a editar: ");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					pelicula = imp.buscar(nombre);

					if (pelicula != null) {
						System.out.println("Se encontro la pelicula a eliminar:" + pelicula);
						imp.eliminar(nombre);
						System.out.println("Se elimino pelicula");
					} else {
						System.out.println("No existe la pelicula");
						break;
					}
				} catch (Exception e) {
					System.out.println("Error " + e.getMessage());
				}

				break;
			case 6:
				if (imp.mostrar() == null) {
					System.out.println("No hay registros");
					break;
				}

				System.out.println("Ingrese la categoria a buscar: ");
				lectura = new Scanner(System.in);
				categoria = lectura.nextLine();
				List<Peliculas> pCategoria = imp.buacarCategoria(categoria);

				if (pCategoria != null)
					System.out.println(pCategoria);
				else
					System.out.println("No se encontro esta categoria");
				break;

			case 7:
				if (imp.mostrar() == null) {
					System.out.println("No hay registros");
					break;
				}

				System.out.println("Total invertido: " + imp.calcularInvertido());
				break;
			case 8:
				System.out.println("EXIT");
				break;

			}

		} while (menuPrincipal < 8);

	}

}
