package sortingalgorithmsimulator;


class QuickSortLength
{
    static int length=0;
    int [] arr;
    QuickSortLength(int [] height_new){
        arr=height_new;
    }
    
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<=high-1; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            System.out.println();

            length+=2;
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
        else if(low==high){
            length+=2;
        }
    }
    public int start(){
        //int arr[] = {10, 7, 8, 9, 1, 5, 12, 34, 2, 6, 4, 16};
        int n = arr.length;
 
        //QuickSortLength ob = new QuickSortLength();
        sort(arr, 0, n-1);
        return length;
    }
}