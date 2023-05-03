import java.util.*;
class Solution {
    public int[] sortArray(int[] nums) {
        // llamamos al método mergeSort
        mergeSort(nums, 0, nums.length - 1);
        return nums; // retornamos el arreglo ordenado
    }
    private void mergeSort(int[] nums, int left, int right) {
        // si left es mayor o igual que right, no hay nada que ordenar
        if (left >= right) return; 
        
        int mid = left + (right - left) / 2;//calculamos el punto medio del arreglo
        mergeSort(nums, left, mid);//ordenamos la primera mitad del arreglo
        mergeSort(nums, mid + 1, right);//ordenamos la segunda mitad del arreglo
        merge(nums, left, mid, right);//unimos las dos mitades ordenadas
    }
    private void merge(int[] nums, int left, int mid, int right) {
        //creamos un arreglo temporal para almacenar los elementos ordenados
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        // Combinamos las dos mitades ordenadas en el arreglo temporal
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // Agregamos los elementos restantes de la primera mitad del arreglo a temp
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // Agregamos los elementos restantes de la segunda mitad del arreglo a temp
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        // Copiamos los elementos ordenados del arreglo temporal al arreglo original
        for (i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}