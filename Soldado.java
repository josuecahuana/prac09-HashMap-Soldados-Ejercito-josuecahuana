
public class Soldado {
	private String nombre;
	private int vida;
	private int fila=-1;
	private int columna=-1;
	
	public Soldado() {
		fila=-1;
		columna=-1;
		vida=0;
	}
	
	public void setNombre(String nuevoNombre) {
		nombre=nuevoNombre;
	}
	public void setVida(int nuevaVida) {
		vida = nuevaVida;
	}
	public void setColumna(int nuevaColumna) {
		columna = nuevaColumna;
	}
	public void setFila(int nuevaFila) {
		fila = nuevaFila;
	}
	public String getNombre() {
		return nombre;
	}
	public int getVida() {
		return vida;
	}
	public int getColumna() {
		return columna;
	}
	public int getFila() {
		return fila;
	}
	public String toString() {
		return nombre+", "+vida+" de vida, posicion: ("+fila+", "+columna+")";
	}

}
