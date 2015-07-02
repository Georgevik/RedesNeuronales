import java.util.ArrayList;

public class Neurona {
	public int id;
	public double bias;
	public double activacion;
	private ArrayList<Conexion> entradas;
	private ArrayList<Conexion> salidas;
	private double valorEntrada;

	public Neurona(int id, double bias) {
		super();
		this.id = id;
		this.bias = bias;
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
		String texto="";
		double valor = 0;
		//si es neurona de entrada
		if(entradas.isEmpty()){
			valor = valorEntrada;


		//si es neurona de salida
		}else if(salidas.isEmpty()){
			for(Conexion conexion : entradas){
				double pesoConexion = conexion.peso;
				double pesoNeurona = conexion.origen.getPeso();
				valor+=pesoConexion*pesoNeurona;
				texto += pesoConexion+"*"+pesoNeurona+"+";
			}
			//valor += bias;
			//System.out.print("Salida= f("+texto+"+"+bias+"="+valor+")=");
			//valor= funcionActivacion(valor);
			//System.out.println(valor);

		//Capa oculta
		}else{
			for(Conexion conexion : entradas){
				double pesoConexion = conexion.peso;
				double pesoNeurona = conexion.origen.getPeso();
				valor+=pesoConexion*pesoNeurona;
				texto += pesoConexion+"*"+pesoNeurona+"+";
			}
			valor += bias;
			//System.out.print("Neu"+id+"= f("+texto+"="+valor+"+"+bias+")=");
			valor= funcionActivacion(valor);
			//System.out.println(valor);
		}

		return valor;

	}



	public double funcionActivacion(double sum){
		return Math.tanh(sum);
	}

}
