/**
 * Created by ashokg on 11/3/17.
 */
public class InterpolationSearch {
    int arr[];
    int element;

    public InterpolationSearch(int[] arr,int element) {
        this.arr = arr;
        this.element=element;
    }

    public int searchElement(){
        int low=0,high=arr.length-1;
        while(low<high && arr[low]<=element && arr[high]>=element) {
            int pos=low+(((element-arr[low])/(arr[high]-arr[low]))*(high-low));
            if(arr[pos]==element)
                return 1;
            else if(arr[pos]<element)
                    low=pos+1;
            else high=pos-1;
        }
        return 0;
    }

    public static void main(String args[]){
        int arr[] =  {10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
                24, 33, 35, 42, 47};
        InterpolationSearch iSearch=new InterpolationSearch(arr,35);
        System.out.println(iSearch.searchElement());
    }
}
