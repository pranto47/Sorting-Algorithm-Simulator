package sortingalgorithmsimulator;


class QuickSort
{
   
    int []sequence;
    int []arr;
    int len=0;
    QuickSort(int [] sequence,int [] height_new_2){
        this.sequence=sequence;
        arr=height_new_2;
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
            sequence[len]=low;
            sequence[len+1]=high;
            len+=2;
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
        else if(low==high){
            sequence[len]=sequence[len+1]=low;
            len+=2;
        }
    }
 
    public void start(){
        int n = arr.length;
        sort(arr, 0, n-1);
    }
}