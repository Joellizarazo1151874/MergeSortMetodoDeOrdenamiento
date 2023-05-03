import java.util.*;
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return; // Caso base
        int mid = left + (right - left) / 2;
        // División recursiva del sub-arreglo izquierdo
        mergeSort(nums, left, mid); 
        // División recursiva del sub-arreglo derecho
        mergeSort(nums, mid + 1, right); 
        // Combinación de los sub-arreglos ordenados
        merge(nums, left, mid, right); 
    }
    private void merge(int[] nums, int left, int mid, int right) {
        // Arreglo temporal para almacenar los elementos combinados
        int[] temp = new int[right - left + 1]; 
        int i = left, j = mid + 1, k = 0;
        // Combinación ordenada de los sub-arreglos
        while (i <= mid && j <= right) { 
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // Combinación de los elementos que quedan en el sub-arreglo izquierdo
        while (i <= mid) { 
            temp[k++] = nums[i++];
        }
        // Combinación de los elementos que quedan en el sub-arreglo derecho
        while (j <= right) { 
            temp[k++] = nums[j++];
        }
        // Copia de los elementos ordenados al arreglo original
        for (i = 0; i < temp.length; i++) { 
            nums[left + i] = temp[i];
        }
    }
}
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        // Lectura de datos
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution solucion = new Solution();
        int[] resultado = solucion.sortArray(nums);
        System.out.println("El arreglo ordenado es:");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
        sc.close();
    }
}