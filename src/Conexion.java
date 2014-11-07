public class Conexion {
	public Neurona origen, destino;
	public double peso;

	public Conexion(Neurona origen, Neurona destino, double peso) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;

		this.origen.addSalida(this);
		this.destino.addEntrada(this);
	}

}
