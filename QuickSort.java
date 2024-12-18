public class QuickSort {
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int inicio, int fin) {
        int posI = inicio;
        int posD = fin;
        int piv = nums[(posI + posD) / 2]; // Elegir el pivote

        do {
            while (nums[posI] < piv) {
                posI++;
            }
            while (nums[posD] > piv) {
                posD--;
            }
            if (posI <= posD) {
                intercambiar(nums, posI, posD);
                posI++;
                posD--;
            }
        } while (posI <= posD);

        // Recursión para las sublistas
        if (inicio < posD) {
            quickSort(nums, inicio, posD);
        }
        if (posI < fin) {
            quickSort(nums, posI, fin);
        }
    }

    private void intercambiar(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}