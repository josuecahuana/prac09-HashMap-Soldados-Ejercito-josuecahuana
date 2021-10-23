import java.util.*;

public class Videojuego {
	public static void main(String[] args) {
		System.out.println("Bienvenido a mi prueba de juego de batalla");
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		HashMap<Integer,Soldado> ejercito1 = new HashMap<Integer,Soldado>();
		HashMap<Integer,Soldado> ejercito2 = new HashMap<Integer,Soldado>();
		ejercito1=crearEjercito(ejercito1,ejercito2,1);
		ejercito2=crearEjercito(ejercito2,ejercito1,2);
		int opcion=0;
		while(opcion!=9) {
			System.out.println("\n¿Que desea hacer?\n");
			System.out.println("1. Mostrar tabla con soldados\n2. Mostrar datos del "
					+ "soldado con mayor vida\n3. Promedio de vida de todos los "
					+ "soldados\n4. Vida total del ejercito\n5. Datos de todos los "
					+ "datos en el orden en el que fueron creados\n6. Ordenar soldados "
					+ "de acuerdo a sus puntos de vida\n7.Buscar soldado(busqueda binaria)\n"
					+ "8. Definir ganador\n9. Terminar programa\n");
			System.out.print("Su opcion: ");
			opcion = sc.nextInt();
			System.out.println("----------------------------------------------------------------------------------------");
			int opcion1=0;
			switch(opcion) {
				case 1:
					imprimirTablero(ejercito1,ejercito2);
					break;
				case 2:
					System.out.print("Ingrese a que ejercito quiere aplicar esto: \n1. Ejercito 1\n2. Ejercito 2\n\nSu opcion: ");
					opcion1 = sc.nextInt();
					System.out.println("----------------------------------------------------------------------------------------");
					switch(opcion1) {
						case 1:
							conMasVida(ejercito1);
							break;
						case 2:
							conMasVida(ejercito2);
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					break;
				case 3:
					System.out.print("Ingrese a que ejercito quiere aplicar esto: \n1. Ejercito 1\n2. Ejercito 2\n\nSu opcion: ");
					opcion1 = sc.nextInt();
					System.out.println("----------------------------------------------------------------------------------------");
					switch(opcion1) {
						case 1:
							System.out.println("El promedio de vida entre los soldados es: "+promedioVida(ejercito1));
							break;
						case 2:
							System.out.println("El promedio de vida entre los soldados es: "+promedioVida(ejercito2));
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					break;
				case 4:
					System.out.print("Ingrese a que ejercito quiere aplicar esto: \n1. Ejercito 1\n2. Ejercito 2\n\nSu opcion: ");
					opcion1 = sc.nextInt();
					System.out.println("----------------------------------------------------------------------------------------");
					switch(opcion1) {
						case 1:
							System.out.println("La vida total de los soldados es: "+vidaTotal(ejercito1));
							break;
						case 2:
							System.out.println("La vida total de los soldados es: "+vidaTotal(ejercito2));
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					break;
				case 5:
					System.out.print("Ingrese a que ejercito quiere aplicar esto: \n1. Ejercito 1\n2. Ejercito 2\n\nSu opcion: ");
					opcion1 = sc.nextInt();
					System.out.println("----------------------------------------------------------------------------------------");
					switch(opcion1) {
						case 1:
							soldadosEnOrden(ejercito1,1);
							break;
						case 2:
							soldadosEnOrden(ejercito2,2);
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					break;
				case 6:
					System.out.print("Ingrese a que ejercito quiere aplicar esto: \n1. Ejercito 1\n2. Ejercito 2\n\nSu opcion: ");
					opcion1 = sc.nextInt();
					System.out.println("----------------------------------------------------------------------------------------");
					switch(opcion1) {
						case 1:
							ordenarVida(ejercito1,1);
							break;
						case 2:
							ordenarVida(ejercito2,2);
							break;
						default:
							System.out.println("Opcion no valida");
							break;
					}
					break;	
				case 7: 
					System.out.println("Ingrese el nombre del soldado a buscar");
					String nombre = sc.next();
	
					if(nombre.substring(3, 4).equals("1")) {
						busquedaBin(ejercito1, nombre);
					}
					else if(nombre.substring(3,4).equals("2")) {
						busquedaBin(ejercito2, nombre);
					}
					else {
						System.out.println("Nombre no valido");
					}
					break;
				case 8:
					definirGanador(ejercito1,ejercito2);
					break;
				case 9: 
					System.out.println("Hasta pronto!");
					break;
				default:
					System.out.println("Opcion no valida");
					break;
			}
			System.out.println("----------------------------------------------------------------------------------------");
		}
	}
	public static void imprimirTablero(HashMap<Integer,Soldado> ejercito1,HashMap<Integer,Soldado> ejercito2) {
		Soldado[][] E1 = new Soldado[10][10];
		Soldado[][] E2 = new Soldado[10][10];
		for(int i=1;i<=ejercito1.size();i++) {
			E1[ejercito1.get(i).getColumna()-1][ejercito1.get(i).getFila()-1]= ejercito1.get(i);
		}
		for(int i=1;i<=ejercito2.size();i++) {
			E2[ejercito2.get(i).getColumna()-1][ejercito2.get(i).getFila()-1]= ejercito2.get(i);
		}
		System.out.println("\n			  	  Tabla  del juego    			");
		System.out.println("________________________________________________________________________________________\n");
		System.out.println("Los soldados del ejercito 1 tienen un 1 despues de sol y los del ejercito 2 tienen un 2\n");
		for(int i=0;i<10;i++) {
			if(i==0) {
				System.out.println("	   1	   2	   3	   4	   5	   6	   7	   8	   9	   10");
				System.out.println("	+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
			}
			for(int j=0;j<10;j++) {
				if(j==0) {
					System.out.print("   "+(i+1)+"	");
				}
				if(E1[j][i]!=null) {
					System.out.print("|"+E1[j][i].getNombre()+"	");
				}
				else if(E2[j][i]!=null) {
					System.out.print("|"+E2[j][i].getNombre()+"	");
				}
				else {
					System.out.print("|	");
				}
				if(j==9) {
					System.out.print("|");
				}
			}
			System.out.println("\n	+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
		}
	}
	public static void conMasVida(HashMap<Integer,Soldado> ejercito) {
		Soldado masVida = new Soldado();
		int repetidos= 1;
		for(int i=1;i<=ejercito.size();i++) {
			if(ejercito.get(i).getVida()>masVida.getVida()) {
				masVida = ejercito.get(i);
				repetidos=1;
			}
			else if(ejercito.get(i).getVida()==masVida.getVida()){
				repetidos++;
			}
		}
		if(repetidos==1) {
			System.out.println(masVida.toString());
		}
		else {
			System.out.println("Estuvieron empatados "+repetidos+" soldados, son los siguientes: \n");
			for(int i=1;i<ejercito.size();i++) {
				if(ejercito.get(i).getVida()==masVida.getVida()) {
					System.out.println(ejercito.get(i).toString());
				}
			}
			System.out.println("");
		}
	}
	public static double promedioVida(HashMap<Integer, Soldado> ejercito) {
		double vidaTotal=0;
		for(int i=1;i<=ejercito.size();i++) {
			vidaTotal = vidaTotal+ejercito.get(i).getVida();
		}
		double promedio = vidaTotal/ejercito.size();
		return promedio;
	}
	public static int vidaTotal(HashMap<Integer, Soldado> ejercito) {
		int vidaTotal=0;
		for(int i=1;i<=ejercito.size();i++) {
			vidaTotal = vidaTotal + ejercito.get(i).getVida();
		}
		return vidaTotal;
	}
	public static void soldadosEnOrden(HashMap<Integer,Soldado> ejercito, int numero) {
		for(int k=1;k<=ejercito.size();k++) {
			System.out.println(ejercito.get(k).toString());
		}
			
	}
	public static int numeroSoldados(ArrayList<ArrayList<Soldado>> ejercito) {
		int numeroSoldados =0;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(ejercito.get(i).get(j).getFila()!=-1) {
					numeroSoldados++;
				}
			}
		}
		return numeroSoldados;
	}
	public static void ordenarVida(HashMap<Integer, Soldado> ejercito, int numero) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el metodo de ordenamiento que desea aplicar: \n1. Insercion\n2. Burbuja\n\nSu opcion: ");
		System.out.print("Su opcion: ");
		int opcion2= sc.nextInt();
		System.out.println("----------------------------------------------------------------------------------------");
		switch(opcion2){
			case 1:
				ordenarInsercion(ejercito,ejercito.size(),numero);
				break;
			case 2:
				ordenarBurbuja(ejercito,ejercito.size(),numero);
				break;
			default:
				System.out.println("Opcion no valida");
		}
	}
	public static void ordenarBurbuja(HashMap<Integer, Soldado> soldados,int numeroSoldados,int numero) {
		Soldado[] SoldadosDesordenados = new Soldado[numeroSoldados];
		for(int i=1;i<=numeroSoldados;i++) {
			SoldadosDesordenados[i-1]=soldados.get(i);
		}
		for(int i=0;i<numeroSoldados;i++) {
			for(int j=0;j<numeroSoldados-1;j++) {
				if(SoldadosDesordenados[j].getVida()>SoldadosDesordenados[j+1].getVida()) {
					Soldado temp = SoldadosDesordenados[j];
					SoldadosDesordenados[j]=SoldadosDesordenados[j+1];
					SoldadosDesordenados[j+1]=temp;
				}	
			}
		}
		System.out.println("Soldados del ejercito "+numero+" ordenados: "+"\n");
		for(int i=0;i<numeroSoldados;i++) {
			System.out.println(SoldadosDesordenados[i].toString());
		}

	}
	
	public static void ordenarInsercion(HashMap<Integer, Soldado> soldados,int numeroSoldados,int numero) {
		Soldado[] SoldadosDesordenados = new Soldado[numeroSoldados];		
		for(int i=1;i<=numeroSoldados;i++) {
			SoldadosDesordenados[i-1]=soldados.get(i);
		}
		for(int i=0;i<numeroSoldados;i++) {
			for(int j=0;j<i;j++) {
				if(SoldadosDesordenados[i].getVida()<SoldadosDesordenados[j].getVida()) {
					Soldado temp = SoldadosDesordenados[i];
					System.arraycopy(SoldadosDesordenados, j, SoldadosDesordenados, j+1, i-j);
					SoldadosDesordenados[j]=temp;
				}
			}
		}	
		System.out.println("Soldados del ejercito "+numero+" ordenados: "+"\n");
		for(int i=0;i<numeroSoldados;i++) {
			System.out.println(SoldadosDesordenados[i].toString());
		}
	}

	public static HashMap<Integer,Soldado> crearEjercito(HashMap<Integer,Soldado> ejercito,HashMap<Integer,Soldado> ejercitoRival,int numero){
		Random rd = new Random();
		int numeroSoldados = rd.nextInt(10)+1;
		for(int i=1;i<=numeroSoldados;i++) {
			String nombre = "Sol"+numero+i;
			int vida = rd.nextInt(10)+1;
			int fila, columna;
			while(true) {
				int contador=0;
				fila = rd.nextInt(10)+1;
				columna = rd.nextInt(10)+1;
				for(int k=1;k<=ejercito.size();k++) {
					if(ejercito.get(k).getColumna()==columna&&ejercito.get(k).getFila()==fila) {
						contador++;
					}
				}	
				for(int k=1;k<=ejercitoRival.size();k++) {
					if(ejercitoRival.get(k).getColumna()==columna&&ejercitoRival.get(k).getFila()==fila) {
						contador++;
					}
				}	
				if(contador==0) break;
			}
			Soldado soldado= new Soldado();
			soldado.setColumna(columna);
			soldado.setFila(fila);
			soldado.setVida(vida);
			soldado.setNombre(nombre);
			System.out.println(soldado.toString());
			ejercito.put(i, soldado);
		}
		return ejercito;
	}
	public static void definirGanador(HashMap<Integer, Soldado> ejercito1,HashMap<Integer, Soldado> ejercito2) {
		if(vidaTotal(ejercito2)>vidaTotal(ejercito1)) {
				System.out.println("El ejercito 2 gana por tener mas vida total que el ejercito 1");
		}
		else if(vidaTotal(ejercito2)<vidaTotal(ejercito1)) {
				System.out.println("El ejercito 1 gana por tener mas vida total que el ejercito 2");
			}
		else {
			if(ejercito2.size()>ejercito1.size()) {
			System.out.println("El ejercito 2 gana por tener mas soldados que el ejercito 1");
			}
			else if(ejercito2.size()<ejercito1.size()) {
			System.out.println("El ejercito 1 gana por tener mas soldados que el ejercito 2");
			}
			else {
				if(promedioVida(ejercito2)>promedioVida(ejercito1)) {
					System.out.println("El ejercito 2 gana porque sus soldados tienen en promedio mas vida que el ejercito 1");
				}
				else if(promedioVida(ejercito2)<promedioVida(ejercito1)) {
					System.out.println("El ejercito 1 gana porque sus soldados tienen en promedio mas vida que el ejercito 2");
				}
				else {
					System.out.println("¡Es un empate!");
				}
			}
		}
	}
	public static void busquedaBin (HashMap<Integer, Soldado> ejercito,String nombre) {
		String numero = nombre.substring(4, nombre.length());
		int m, a= 1 ,b= ejercito.size();
		while(a<b) {
			m= (a + b)/ 2;
			String soldado= ejercito.get(m).getNombre().substring(4, ejercito.get(m).getNombre().length());
			if(soldado.compareTo(numero)> 0) {
				b= m;
			}
			else if(soldado.compareTo(numero)< 0) {
				a= m;
			}
			else {	
				System.out.println("\n"+ejercito.get(m).toString());
				break;
			}
		}
	}
}
