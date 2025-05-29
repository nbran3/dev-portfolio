// selection sort = search through an array and keep track of the minimum value during each iteration
// At the end of each iteration, the variables swap

public class SelectionSort {

    public static void main(String[] args) {
        int array[] = {2,9,1,8,5,6,3,4,7};

        selectionSort(array);

        for(int i : array){
            System.out.print(i);
        }


    }

    private static void selectionSort(int[] array) {
        for(int i = 0; i<array.length-1; i++){
            int min = i;
            for(int j = i + 1; j <array.length; j++){
                if(array[min] > array[j]){ 
                  // if you want to sort by descending order, change > to <
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
