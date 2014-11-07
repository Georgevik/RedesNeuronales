import java.util.ArrayList;

public class Neurona {
	public int id;
	public double bias;
	public double activacion;
	private ArrayList<Conexion> entradas;
	private ArrayList<Conexion> salidas;
	public double valorEntrada;

	public Neurona(int id, double bias, double activacion) {
		super();
		this.id = id;
		this.bias = bias;
		this.activacion = activacion;
		this.entradas = new ArrayList<Conexion>();
		this.salidas = new ArrayList<Conexion>();

	}

	public void addEntrada(Conexion conexion) {
		entradas.add(conexion);
	}

	public void addSalida(Conexion conexion) {
		salidas.add(conexion);
	}

	public double getPeso(){
		if(entradas.isEmpty())
			return valorEntrada;
		
		double valor = bias;
		for(Conexion conexion : entradas){
			valor+=conexion.peso*conexion.origen.getPeso();
		}

		
		return valor;
	}
	
}
