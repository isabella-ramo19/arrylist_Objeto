/*Isabella Ramos Ampudia
 * ficha: 2821728
 * 27/02/2024
 */
package ejercicio;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudiante {

    private int identificacion;
    private String nombre;
    private String email;

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nIdentificación: ");
        sb.append(identificacion);
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nEmail: ");
        sb.append(email);
        return sb.toString();
    }

    public static class Estudiantebasico1 {
        static Scanner entrada = new Scanner(System.in);
        static ArrayList<Estudiante> estudiantes = new ArrayList<>();

        public static void main(String[] args) {
            leerEstudiantes();
            System.out.println("Estudiantes: ");
            mostrarEstudiantes();
            mostrarPorIdentificacion();
            actualizarNombre();
        }

        public static void leerEstudiantes() {
            int identificacion;
            String nombre;
            String email;
            Estudiante aux;
            int N;
            do {
                System.out.println("Número de estudiantes a leer: ");
                N = entrada.nextInt();
            } while (N < 0);
            entrada.nextLine(); // Consumir el carácter de nueva línea en el búfer
            for (int i = 1; i <= N; i++) {
                System.out.println("Estudiante " + i);
                System.out.print("Identificación: ");
                identificacion = entrada.nextInt();
                entrada.nextLine(); // Consumir el carácter de nueva línea en el búfer
                System.out.print("Nombre: ");
                nombre = entrada.nextLine();
                System.out.print("Email: ");
                email = entrada.nextLine();

                aux = new Estudiante();
                aux.setIdentificacion(identificacion);
                aux.setNombre(nombre);
                aux.setEmail(email);

                estudiantes.add(aux);
            }
        }

        public static void mostrarEstudiantes() {
            for (Estudiante estudiante : estudiantes)
                System.out.println(estudiante);
        }

        public static void mostrarPorIdentificacion() {
            int identificacion;
            System.out.print("Introduce el número de identificación del estudiante que deseas encontrar: ");
            identificacion = entrada.nextInt();
            System.out.println("El estudiante con la identificación " + identificacion + " es:");
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getIdentificacion() == identificacion)
                    System.out.println(estudiante);
            }
        }

        public static void actualizarNombre() {
            int identificacion;
            System.out.print("Introduce el número de identificación del estudiante cuyo nombre quieres actualizar: ");
            identificacion = entrada.nextInt();
            entrada.nextLine(); // Consumir el carácter de nueva línea en el búfer
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getIdentificacion() == identificacion) {
                    System.out.print("Introduce el nuevo nombre para el estudiante: ");
                    String nuevoNombre = entrada.nextLine();
                    estudiante.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado correctamente.");
                    return;
                }
            }
            System.out.println("No se encontró ningún estudiante con la identificación proporcionada.");
        }
    }
}
