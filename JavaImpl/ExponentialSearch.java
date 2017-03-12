/**
 * Created by ashokg on 11/3/17.
 */
public class ExponentialSearch {
    int arr[];
    int element;

    public ExponentialSearch() {
    }

    public ExponentialSearch(int[] arr,int element) {
        this.arr = arr;
        this.element=element;
    }

    public boolean findElement(){
        int previousRange=-1,currentRange=1;
        int n=arr.length-1;
        while(arr[Math.min(currentRange-1,n)]<element){
            previousRange=currentRange-1;
            currentRange*=2;
            if(previousRange>n){
                return false;
            }
        }
        while(previousRange<=Math.min(currentRange,n)){
            if(arr[previousRange]==element){
                return true;
            }
            previousRange++;
        }
        return false;
    }

    public static void main(String args[]){
        int arr[] = {10, 20, 40, 45, 55};
        ExponentialSearch expSearch=new ExponentialSearch(arr,20);
        System.out.println(expSearch.findElement());
    }
}
