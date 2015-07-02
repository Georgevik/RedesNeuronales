import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	final static int N_ENTRADAS = 8;
	static int N_NEURONAS;
	static boolean isNormalizado = true;

	public static void main(String[] args) {
		String norm = "";
		if (isNormalizado)
			norm = "_norm";

		HashMap<Integer, Neurona> mapNeuronas = new HashMap<Integer, Neurona>();

		ArrayList<String> rows = leerFichero("dni.net");
		ArrayList<String> stringCampos;
		Neurona neurona = null;

		for (String neu : rows) {
			stringCampos = new ArrayList<String>(Arrays.asList(neu.split("\t")));
			neurona = new Neurona(Integer.parseInt(stringCampos.get(0).trim()),
					Double.parseDouble(stringCampos.get(1).trim()));
			mapNeuronas.put(neurona.id, neurona);
		}

		N_NEURONAS = mapNeuronas.size();

		ArrayList<String> par;
		rows = leerFichero("conexiones" + norm + ".txt");

		for (String con : rows) {
			stringCampos = new ArrayList<String>(Arrays.asList(con.split("\t")));

			for (int i = 0; i < stringCampos.size(); i++) {
				if (i == 0)
					neurona = mapNeuronas.get(Integer.parseInt(stringCampos
							.get(i)));
				else {
					par = new ArrayList<String>(Arrays.asList(stringCampos.get(
							i).split(":")));
					new Conexion(mapNeuronas.get(Integer.parseInt(par.get(0)
							.trim())), neurona, Double.parseDouble(par.get(1)
							.trim()));
				}
			}

		}

		double sumaDeRestas = 0;
		double aciertos = 0;
		double diferenciaMedia = 0;

		rows = leerFichero("dni_full.pat");
		for (String con : rows) {
			stringCampos = new ArrayList<String>(Arrays.asList(con.split("\t")));

			for (int i = 0; i < N_ENTRADAS; i++) {
				double paco = Double.parseDouble(stringCampos.get(i).trim());
				int id = mapNeuronas.get(i + 1).id;
				mapNeuronas.get(i + 1).setValorActivacion(paco);
				;
			}

			double a = mapNeuronas.get(mapNeuronas.size()).getPeso();
			double b = Double.parseDouble(stringCampos.get(N_ENTRADAS).trim());

			double da, db;
			da = desnormalizar(a);
			db = desnormalizar(b);
			if (!isNormalizado) {
				da = Math.round(a);
				db = Math.round(b);
			}
			//System.out.println(a + " -> " + b);
			// System.out.println(desnormalizar(a)+" -> "+desnormalizar(b));
			if (da == db) {
				aciertos++;
			}
			diferenciaMedia += Math.abs(db - da);

			sumaDeRestas += ((a - b) * (a - b));
		}

		double asdf = aciertos / rows.size() * 100;

		System.out.println("Error cuadrático: " + sumaDeRestas);
		System.out.println("Error cuadrático medio: "
				+ (sumaDeRestas / rows.size()));
		System.out.println("Aciertos " + aciertos + " de " + rows.size());
		System.out.println("Error de clasificación:" + (100 - asdf) + " %");
		System.out.println("Error de aproximación: "
				+ (diferenciaMedia / rows.size()));

	}

	public static long desnormalizar(double normal) {
		int MAX = 29;
		int MIN = 1;

		long desnormalizar = Math.round(normal * (MAX - MIN) + MIN);

		return desnormalizar;

	}

	public static ArrayList<String> leerFichero(String nombreFichero) {
		ArrayList<String> resultado = new ArrayList<String>();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File("archivos/" + nombreFichero);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;

			while ((linea = br.readLine()) != null)
				resultado.add(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}
}
