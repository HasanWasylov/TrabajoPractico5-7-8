package Principal;

public class Carrito {
	private int codigo;
	
	public Carrito(int codigo) {
		this.codigo = codigo;
	}
	
	public Carrito() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double sumaPrecio(double precio, int cantidad) {
		
		double result = precio*cantidad;
		return result ;
	}

	public double aplicarDescuento(double total) throws Exception {
	    if (total == 0) {
	        throw new Exception("No se puede aplicar descuento a un carrito de precio 0");
	    }

	    double descuento = total * 0.1; // 10% de descuento
	    double totalConDescuento = total - descuento;

	    if (totalConDescuento < 0) {
	        throw new Exception("El descuento no puede resultar en un monto negativo");
	    }

	    return totalConDescuento;
	}
}

