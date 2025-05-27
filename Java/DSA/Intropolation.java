// interpolation serach = better than binary search, best for perfect/ uniform distributed data.
// "guesses" where a value might be based on calculated results of probing, if probe is incorrect, the
// search area is narrowed and a new probe is calculated.

public class Main {

    public static void main(String[] args) {

        int[] array = {1,2,4,8,16,32,64,128,256,512,1024};
        
        int index = interpolationSearch(array, 128);

        if(index!= -1){
            System.out.println("Element found at index: " + index);
        }
        else{
            System.out.println("Element not found");
        }

    }

    private static int interpolationSearch(int[] array, int value) {
        int high = array.length - 1;
        int low = 0;

        while (low <= high && value >= array[low] && value <= array[high]) {

            // Avoid division by zero
            if (array[high] == array[low]) {
                if (array[low] == value) return low;
                else break;
            }

            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);

            System.out.println("probe: " + probe);

            if (array[probe] == value) {
                return probe;
            } else if (array[probe] < value) {
                low = probe + 1;
            } else {
                high = probe - 1;
            }
        }

        return -1;
    }

}
