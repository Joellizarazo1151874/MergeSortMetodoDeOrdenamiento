import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Genera 100 casos de prueba aleatorios
        int[][] testCases = generateTestCases(100);
        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i+1) + ": ");
            // Imprime cada caso de prueba generado
            printArray(testCases[i]); 
        }
    }
    // Genera n casos de prueba aleatorios
    private static int[][] generateTestCases(int n) {
        // Crea un objeto Random para generar valores aleatorios
        Random rand = new Random(); 
        // Crea un arreglo bidimensional para almacenar los casos de prueba
        int[][] testCases = new int[n][]; 
        for (int i = 0; i < n; i++) {
            // Genera un tamaño aleatorio para el arreglo (entre 1 y 1000)
            int size = rand.nextInt(1000) + 1; 
            // Crea un arreglo del tamaño generado
            int[] arr = new int[size]; 
            for (int j = 0; j < size; j++) {
                // Genera valores aleatorios para cada posición del arreglo (entre -10000 y 10000)
                arr[j] = rand.nextInt(20001) - 10000; 
            }
            // Agrega el arreglo generado al arreglo de casos de prueba
            testCases[i] = arr; 
        }
        // Retorna el arreglo de casos de prueba generado
        return testCases; 
    }
    // Imprime un arreglo en formato de lista
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length-1) {
                // Imprime cada valor del arreglo, separado por coma
                System.out.print(arr[i] + ", "); 
            } else {
                // Imprime el último valor del arreglo sin coma
                System.out.print(arr[i]); 
            }
        }
        // Imprime el cierre de la lista
        System.out.println("]"); // Imprime el cierre de la lista
    }
}