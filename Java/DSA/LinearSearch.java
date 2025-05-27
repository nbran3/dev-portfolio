public class Main {

    public static void main(String[] args) {

// Linear Search - Slow for large datasets,
// good for small to medium datasets, good for DS that do not have random access (LL)

int[] array = {3,4,6,8,9,1,3,7,2};

int index = linearSearch(array,1);
if(index != -1){
    System.out.println("Element found at index: " + index);

} else{
    System.out.println("Element not found");
}

    }

    private static int linearSearch(int[] array, int value) {
        for(int i = 0; i<array.length; i++){
            if(array[i] == value){
                return i;
            }

        }
        return -1;
    }

}
