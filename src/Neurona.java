import java.util.ArrayList;

public class Neurona {
	public int id;
	public double bias;
	public double activacion;
	private ArrayList<Conexion> entradas;
	private ArrayList<Conexion> salidas;
	private double valorEntrada;

	public Neurona(int id, double activacion) {
		super();
		this.id = id;
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

	public void setValorActivacion(double valor){
		this.valorEntrada = valor;
	}

	public double getPeso(){
		double valor = 0;
		//si es neurona de entrada
		if(entradas.isEmpty()){
			valor = valorEntrada;


		//si es neurona de salida
		}else if(salidas.isEmpty()){
			for(Conexion conexion : entradas){
				valor+=conexion.peso*conexion.origen.getPeso();
			}
			valor += bias;
			valor= funcionActivacion(valor);
			

		//Capa oculta
		}else{
			for(Conexion conexion : entradas){
				valor+=conexion.peso*conexion.origen.getPeso();
			}
			valor += bias;
			valor= funcionActivacion(valor);
		}

		return valor;

	}



	public double funcionActivacion(double sum){
		return Math.tanh(sum);
	}

}
