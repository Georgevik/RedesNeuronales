import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	final static int N_ENTRADAS = 8;
	final static int N_NEURONAS = 12;

	public static void main(String[] args) {
		HashMap<Integer, Neurona> mapNeuronas = new HashMap<Integer, Neurona>();

		ArrayList<String> rows = leerFichero("neuronas.txt");
		ArrayList<String> stringCampos;
		Neurona neurona = null;

		for (String neu : rows) {
			stringCampos = new ArrayList<String>(Arrays.asList(neu.split("\t")));
			neurona = new Neurona(Integer.parseInt(stringCampos.get(0).trim()),
					Double.parseDouble(stringCampos.get(1).trim()),
					Double.parseDouble(stringCampos.get(2).trim()));
			mapNeuronas.put(neurona.id, neurona);
		}

		ArrayList<String> par;
		rows = leerFichero("conexiones.txt");

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

		rows = leerFichero("abalone.txt");
		for (String con : rows) {
			stringCampos = new ArrayList<String>(Arrays.asList(con.split("\t")));

			for (int i = 0; i < N_ENTRADAS; i++) {
				double paco = Double.parseDouble(stringCampos.get(i).trim());
				mapNeuronas.get(i + 1).valorEntrada = paco;
			}

			double a = mapNeuronas.get(mapNeuronas.size()).getPeso();
			System.out.println(a + " -> " + stringCampos.get(N_ENTRADAS));

		}

		System.out.println(rows.size());
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
