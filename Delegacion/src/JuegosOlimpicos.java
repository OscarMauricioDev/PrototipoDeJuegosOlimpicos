import java.util.Scanner;

public class JuegosOlimpicos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Medallero[] delegaciones = new Medallero[100]; 
        int delegacionCount = 0;

        int opcion;
        do {
            mostrarMenu();
            opcion = entrada.nextInt();
            entrada.nextLine(); 
            switch(opcion) {
                case 1:
                    if (delegacionCount < delegaciones.length) {
                        delegaciones[delegacionCount] = crearDelegacion(entrada);
                        delegacionCount++;
                    } else {
                        System.out.println("No se pueden añadir más delegaciones");
                    }
                    break;
                case 2:
                    listarDelegaciones(delegaciones, delegacionCount);
                    break;
                case 3:
                    modificarMedallas(delegaciones, delegacionCount, entrada);
                    break;
                case 4:
                    delegacionCount = eliminarDelegacion(delegaciones, delegacionCount, entrada);
                    break;
                case 5:
                    mostrarDelegacionConMasMedallas(delegaciones, delegacionCount);
                    break;
                case 6:
                    mostrarDelegacionConMenosMedallas(delegaciones, delegacionCount);
                    break;
                default:
                    break;
            }
        } while(opcion != 7);
        entrada.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n<< ------------------------- >>");
        System.out.println("<<       JUEGOS OLÍMPICOS    >>");
        System.out.println("<< ------------------------- >>");
        System.out.println("     1:  Crear una delegación ");
        System.out.println("     2:  Listar delegaciones ");
        System.out.println("     3:  Modificar medallas de una delegación ");
        System.out.println("     4:  Eliminar una delegación ");
        System.out.println("     5:  Delegación con más medallas ");
        System.out.println("     6:  Delegación con menos medallas ");
        System.out.println("     7:  Salir ");
        System.out.print("     Teclee opción: ");
    }

    public static Medallero crearDelegacion(Scanner entrada) {
        System.out.println("\n----------- Lectura de datos -----------");
        System.out.print("Ingrese el país: ");
        String pais = entrada.nextLine();
        System.out.print("Ingrese el número de deportistas: ");
        int numeroDeportistas = entrada.nextInt();
        System.out.print("Ingrese el número de medallas de oro: ");
        int medallasOro = entrada.nextInt();
        System.out.print("Ingrese el número de medallas de plata: ");
        int medallasPlata = entrada.nextInt();
        System.out.print("Ingrese el número de medallas de bronce: ");
        int medallasBronce = entrada.nextInt();
        System.out.print("Ingrese los años exactos: ");
        int aniosExactos = entrada.nextInt();
        entrada.nextLine();

        Medallero delegacion = new Delegacion(pais, numeroDeportistas, medallasOro, medallasPlata, medallasBronce, aniosExactos);
        System.out.println("Delegación creada exitosamente");
        return delegacion;
    }

    public static void listarDelegaciones(Medallero[] delegaciones, int delegacionCount) {
        if (delegacionCount == 0) {
            System.out.println("No hay delegaciones registradas");
        } else {
            System.out.println("\n----------- Lista de Delegaciones -----------");
            for (int i = 0; i < delegacionCount; i++) {
                delegaciones[i].mostrarDelegacion();
                System.out.println("-----------------------------------------");
            }
        }
    }

    public static void modificarMedallas(Medallero[] delegaciones, int delegacionCount, Scanner entrada) {
        System.out.print("Ingrese el país de la delegación a modificar: ");
        String pais = entrada.nextLine();
        for (int i = 0; i < delegacionCount; i++) {
            if (delegaciones[i].getPais().equalsIgnoreCase(pais)) {
                System.out.println("\n----------- Modificar Medallas -----------");
                System.out.print("Ingrese el nuevo número de medallas de oro: ");
                int medallasOro = entrada.nextInt();
                System.out.print("Ingrese el nuevo número de medallas de plata: ");
                int medallasPlata = entrada.nextInt();
                System.out.print("Ingrese el nuevo número de medallas de bronce: ");
                int medallasBronce = entrada.nextInt();
                entrada.nextLine();

                delegaciones[i].setMedallasOro(medallasOro);
                delegaciones[i].setMedallasPlata(medallasPlata);
                delegaciones[i].setMedallasBronce(medallasBronce);
                System.out.println("Medallas actualizadas exitosamente");
                return;
            }
        }
        System.out.println("Delegación no encontrada");
    }

    public static int eliminarDelegacion(Medallero[] delegaciones, int delegacionCount, Scanner entrada) {
        System.out.print("Ingrese el país de la delegación a eliminar: ");
        String pais = entrada.nextLine();
        for (int i = 0; i < delegacionCount; i++) {
            if (delegaciones[i].getPais().equalsIgnoreCase(pais)) {
                for (int j = i; j < delegacionCount - 1; j++) {
                    delegaciones[j] = delegaciones[j + 1];
                }
                delegaciones[delegacionCount - 1] = null;
                delegacionCount--;
                System.out.println("Delegación eliminada exitosamente");
                return delegacionCount;
            }
        }
        System.out.println("Delegación no encontrada");
        return delegacionCount;
    }

    public static void mostrarDelegacionConMasMedallas(Medallero[] delegaciones, int delegacionCount) {
        if (delegacionCount == 0) {
            System.out.println("No hay delegaciones registradas");
            return;
        }
        Medallero maxMedallasDelegacion = delegaciones[0];
        for (int i = 1; i < delegacionCount; i++) {
            if (delegaciones[i].calcularTotalMedallas() > maxMedallasDelegacion.calcularTotalMedallas()) {
                maxMedallasDelegacion = delegaciones[i];
            }
        }
        System.out.println("\n----------- Delegación con más Medallas -----------");
        maxMedallasDelegacion.mostrarDelegacion();
        System.out.println("-----------------------------------------");
    }

    public static void mostrarDelegacionConMenosMedallas(Medallero[] delegaciones, int delegacionCount) {
        if (delegacionCount == 0) {
            System.out.println("No hay delegaciones registradas");
            return;
        }
        Medallero minMedallasDelegacion = delegaciones[0];
        for (int i = 1; i < delegacionCount; i++) {
            if (delegaciones[i].calcularTotalMedallas() < minMedallasDelegacion.calcularTotalMedallas()) {
                minMedallasDelegacion = delegaciones[i];
            }
        }
        System.out.println("\n----------- Delegación con menos Medallas -----------");
        minMedallasDelegacion.mostrarDelegacion();
        System.out.println("-----------------------------------------");

    }
    
}
