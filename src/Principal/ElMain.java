package Principal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import Principal.Carrito;

public class ElMain {
		/*Introduccion a la programacion OO*/
		
	
	
	public static void main(String[] args) throws IOException {
		
		/*1*/
		
		/*1. Implemente usted mismo el ejemplo visto en clase de “carrito de compras”: una clase
		Producto (que pueda tener hasta 3 items), otra ItemCarrito, otra Carrito y otra
		Descuento, con 2 subclases.*/
		
		/*Producto produc1 = new Producto ("pan",200,"minion",5);
		Producto produc2 = new Producto ("factura",600,"medialunas",24);
		Producto produc3 = new Producto ("queso",500,"musarela",10);
		
		
		/*2*/
		
		/*En un programa main, lea de un archivo, por ejemplo separado por Tabs o comas, una
		lista de items, arme los objetos correspondientes y con el método de carrito “precio”,
		retorne el resultado. Por ejemplo:
		
		cant precioUnitario producto
			
			1 40 jabón en polvo
			3 10 esponjas
			2 100 chocolates
				carrito.precio() == 270*/
		
        double total = 0;
        Carrito carrito = new Carrito();
		
        File archivo = new File("C:\\D\\leer.txt");
        Scanner sc = new Scanner(archivo);
		
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
			
            String[] partes = linea.split("-");			
            int stock = Integer.parseInt(partes[0]);
            double precio = Double.parseDouble(partes[1]);
            String nombre = partes[2];
            Producto producto = new Producto(nombre, precio, "", stock);

            total += carrito.sumaPrecio(precio, stock);
            System.out.println("");
            System.out.print("--");
            System.out.print(producto.getCodigo());
            System.out.print("  ");
            System.out.print(producto.getNombre());
            System.out.print("  ");
            System.out.print(producto.getStock());
            System.out.print("  ");
            System.out.print(producto.getPrecio());
        }

        try {
            if (total == 0) {
                throw new Exception("No se puede aplicar descuento a un carrito de precio 0");
            } else if (total < 0) {
                throw new Exception("El descuento no puede resultar en un monto negativo");
            } else {
                // Realizar descuento y mostrar total con descuento
                double totalConDescuento = carrito.aplicarDescuento(total);
                System.out.println("");
                System.out.print("------------------------ ");
                System.out.println("");
                System.out.print("Total con descuento: ");
                System.out.print(totalConDescuento);
            }
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Error al aplicar descuento: " + e.getMessage());
        }
		
	}

}



