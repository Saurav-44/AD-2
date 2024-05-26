public class MergeSort {

    static void mergeSort(int arr[], int si, int ei) {
        if(si < ei) {
            int mid = (si + ei)/2;
            mergeSort(arr, si, mid);
            mergeSort(arr, mid+1, ei);
            merge(arr, si, mid, ei);
        }
    }

        static void merge(int arr[], int si, int mid, int ei) {
            int merge[] = new int[ei-si+1];
            int i = si; // iterator for left part of original arr
            int j = mid+1; //  iterator for right part of original arr
            int k = 0; // iterator for merge arr

            while(i <= mid && j <= ei){
                if(arr[i] < arr[j]){
                    merge[k] = arr[i];
                    i++;
                }

                else {
                    merge[k] = arr[j];
                    j++;
                }

                k++;
            }

            while(i <= mid) {
                merge[k++] = arr[i++];
            }

            while(j <= ei) {
                merge[k++] = arr[j++];
            }

            for(k = 0, i=si; k < merge.length; k++,i++ ){ // copying merge arr to original arr
                arr[i] = merge[k];
            }
        
        
}

static void printArr(int arr[]) {
    for(int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.println();
}
    public static void main(String[] args) {
        int arr[] = {5,1,7,9,3};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);

    }
}