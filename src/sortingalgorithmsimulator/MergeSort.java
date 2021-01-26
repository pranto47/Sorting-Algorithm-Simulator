package sortingalgorithmsimulator;



class MergeSort
{
    int [] sequence;
    int [][]partition_sequence;
    int i=0;
    int j=0;
    MergeSort(int [] sequence,int [][]partition_sequence){
        this.sequence=sequence;
        this.partition_sequence=partition_sequence;
    }
    
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            partition_sequence[j][0]=l;
            partition_sequence[j][1]=m;
            partition_sequence[j+1][0]=m+1;
            partition_sequence[j+1][1]=r;
            j+=2;
            
            sort(arr, l, m);
            sort(arr , m+1, r);
            
            sequence[i]=l;
            sequence[i+1]=r;
            i+=2;
            
            merge(arr, l, m, r);
        }
    }
 
    public void start(){
        int arr[] = {12, 11, 13, 5, 6, 7,2,1,8,4,9,10};
        int finalarray[]=new int [(2*12)-2];
 
        System.out.println("Given Array");
 
        sort(arr, 0, arr.length-1);
 
    }
}