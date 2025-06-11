public class Main {
    public static void main(String[] args) {

        int[] array = {8, 2, 5, 3, 9, 4, 7, 6, 1};

        quickSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.println(i + " ");
        }

    }

    private static void quickSort(int[] array, int startingIndex, int endingIndex) {

        if (endingIndex <= startingIndex) return; // base case

        int pivot = partition(array, startingIndex, endingIndex);

        quickSort(array, startingIndex, pivot - 1);
        quickSort(array, pivot + 1, endingIndex);


    }

    private static int partition(int[] array, int startingIndex, int endingIndex) {
        int pivot = array[endingIndex];
        int i = startingIndex - 1;

        for (int j = startingIndex; j < endingIndex; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[endingIndex];
        array[endingIndex] = temp;

        return i;
    }
}
