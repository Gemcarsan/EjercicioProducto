
public class Producto {
	

	public String descripcion;
	public double precioSinIVA;
	public Categoria categoria;
	public int codigo;
	
	public static int codigoPorDefecto=1;
	
	public Producto(String descripcion, double precioSinIVA, Categoria categoria) throws ProductoException {
	
		setDescripcion(descripcion);
		setPrecioSinIVA(precioSinIVA);
		
		this.categoria = categoria;
	
		this.codigo=codigoPorDefecto;
		
		codigoPorDefecto++;
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws ProductoException{
		
		if(descripcion==null) {
			throw new ProductoException("El producto debe tener una descripcion");
		}
		this.descripcion = descripcion;
	}

	public double getPrecioSinIVA() throws ProductoException {
		
		if(precioSinIVA<0) {
			throw new ProductoException ("El precio no puede ser negativo");
		}
		
		return precioSinIVA;
	}

	public void setPrecioSinIVA(double precioSinIVA) {
		this.precioSinIVA = precioSinIVA;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public String toString() {
		return "La descripción del producto es " + descripcion + 
				"\n-Su precio sin IVA es de " + precioSinIVA + " euros "
				+ "\n-Su categoria es " + categoria
				+ "\n-Su código " + codigo;
	}
	
	public double precioVenta (Categoria categoria) throws ProductoException, CategoriaException {
		double calcularIVA;
		double precioVentaFinal;
		
		
		calcularIVA=(getPrecioSinIVA()*categoria.getIVA())/100;
		
		precioVentaFinal=getPrecioSinIVA()+calcularIVA;
		
		return precioVentaFinal;
	}
	
	
}
