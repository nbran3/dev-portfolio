// merge sort

public class Main {

    public static void main(String[] args) {
    int[] array = {8,2,5,4,3,7,6,1,9};

    mergeSort(array);

    for(int i = 0; i < array.length; i++){
        System.out.print(array[i] + " ");
    }

    }

    private static void mergeSort(int[] array) {

        int length = array.length;
        if(length <= 1)return;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int l = 0; // left array
        int r = 0; // right array

        for(; l < length; l++){
            if(l < middle){
                leftArray[l] = array[l];
            }else {
                rightArray[r] = array[l];
                r++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array){

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l=0, r=0;

        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;

        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;

        }

    }


}
