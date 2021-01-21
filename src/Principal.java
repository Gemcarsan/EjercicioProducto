import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		char respuesta;

		crearCategoria();
		do {
			System.out.println("¿Desea crear un nuevo producto?(S/N)");
			respuesta = teclado.nextLine().charAt(0);
			respuesta = Character.toUpperCase(respuesta);
			if (respuesta == 'S') {
				crearCategoria();
			} else {
				System.out.println("Hasta la próxima");
			}
		} while (respuesta != 'S' || respuesta != 'N');

	}

	/***
	 * metodo para crear la clase categoria
	 */

	public static void crearCategoria() {
		String nombre;
		double IVA;

		try {
			System.out.println("Introduzca el nombre del producto: ");
			nombre = teclado.nextLine();

			System.out.println("Introduzca el IVA del producto: ");
			IVA = Double.parseDouble(teclado.nextLine());

			Categoria categoria1 = new Categoria(nombre, IVA);

			crearProducto(categoria1);

		} catch (CategoriaException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Metodo para crear la clase producto
	 * 
	 * @param categoria1
	 */

	public static void crearProducto(Categoria categoria1) {
		String descripcion;
		double precioSinIVA;

		try {
			System.out.println("Introduzca una breve descripción del producto: ");
			descripcion = teclado.nextLine();

			System.out.println("Introduzca el precio del producto sin IVA:");
			precioSinIVA = Double.parseDouble(teclado.nextLine());

			Producto producto1 = new Producto(descripcion, precioSinIVA, categoria1);

			System.out.println(" ");
			tratarMenu(producto1, categoria1);

		} catch (ProductoException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Método para llamar el menu
	 * 
	 * @param producto1
	 */

	public static void tratarMenu(Producto producto1, Categoria categoria1) {
		int respuesta;
		double precioSinIVA, IVA;
		boolean salir = false;
		do {

				System.out.println("Buenas. Seleccione una opción: \n1.Consulta el producto "
						+ "\n2.Modifica el precio sin IVA \n3.Modifica el IVA \n4.Precio venta \n5.Salir");
				respuesta = Integer.parseInt(teclado.nextLine());
			

			try {

				switch (respuesta) {
				case 1:
					System.out.println(producto1);
					break;
				case 2:
					System.out.println("Introduzca el nuevo precio sin IVA: ");
					precioSinIVA = Double.parseDouble(teclado.nextLine());
					producto1.setPrecioSinIVA(precioSinIVA);
					break;
				case 3:
					System.out.println("Introduzca el nuevo IVA: ");
					IVA = Double.parseDouble(teclado.nextLine());
					categoria1.setIVA(IVA);

					break;
				case 4:
					System.out.println(producto1.precioVenta(categoria1));
					break;
				case 5:
					salir = true;
					System.out.println("Hasta la próxima");
					break;
				default:
					System.out.println("Error.");
				}

			} catch (ProductoException e) {

				e.printStackTrace();
			} catch (CategoriaException e) {
				e.printStackTrace();
			}
		} while (salir == false);
	}
}
