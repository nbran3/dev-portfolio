public class Bubble {

    public static void main(String[] args) {

        int array[] = {9, 2, 7, 6, 1, 5, 4, 3, 8};


        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }

    }

    private static void bubbleSort(int array[]) {

        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                }

            }
        }

    }
}
