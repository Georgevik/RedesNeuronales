RedesNeuronales
===============

Simulación de una red neuronal ya entrenada.

El programa funciona introduciendo en la carpeta "archivos" los siguientes archivos:

**abalone.txt**
Descipción: Contiene los datos de entrada y de salida. Por defecto, todos los datos son entrada menos uno, que es el de salida. Cada dato, tiene que estar separado por una tabulación y cada caso esta comprendido en un salto de línea

Ejemplo:
1.0	0.5135135135135136	0.5210084033613446	0.084070796460177	0.18133522224189835	0.15030262273032954	0.13232389730085584	0.14798206278026907	0.5

**neuronas.txt**
Descripción: Esta formado por el ID de la neurona(importante que este en orden creciente desde el 1, siendo la ultima neurona la de salida), activación y bias. Cada neurona debe estar en un salto de linea y cada dato separado por una tabulación.

Ejemplo:
1	0.00000	-0.00180
2 0.00000	-0.51550
3	0.00000	-0.94604
4	0.00000	-0.26067
11	0.28591	-0.91532
12	0.00007	-0.72144

**conexiones.txt**
Descripcion:Son los pesos de las conexiones entre las neuronas. Cada fila esta formada por el ID de la neurona y por parejas de conexiones <id_neurona>:<peso_conexión>

Ejemplo:
9	8:0.85446	7: 0.61491	6: 0.63946	5:-0.66190	4: 0.04449	3:-0.37711	2: 0.74089	1:-0.25000
10	8:0.14218	7: 0.26337	6:-0.79968	5:-0.56499	4: 0.54333	3: 0.24039	2: 0.74142	1:-0.63588
11	8:0.84317	7:-0.45964	6:-0.44369	5:-0.43247	4: 0.45621	3:-0.65493	2:-0.34425	1:-0.70914





