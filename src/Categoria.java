
public class Categoria {
	
	//ATRIBUTOS

	public String nombre;
	public double IVA;
	
	//CONSTRUCTOR
	
	public Categoria(String nombre, double IVA) throws CategoriaException {
		
		setNombre(nombre);
		setIVA(IVA);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CategoriaException{
		if(nombre==null) {
			throw new CategoriaException ("El producto debe tener un nombre");
		}
		this.nombre = nombre;
	}

	public double getIVA() throws CategoriaException {
		
		if(IVA< 0 || IVA > 21) {
			throw new CategoriaException("IVA incorrecto");
		}
		return IVA;
	}

	public void setIVA(double iVA) {
		IVA = iVA;
	}
	
	public String toString() {
		
		return "La categoría "+nombre+" tiene un IVA de "+ IVA +" %";
	}

}
