/**
 * Created by ashokg on 11/3/17.
 */
public class JumpSearch {

    public int search(int arr[],int x){
        int n=arr.length;
        int blockSize=new Double(Math.floor(Math.sqrt(n))).intValue();
        int k=0;
        int step=0;
        int prev=-1;
        while(arr[Math.min(step,n-1)]<x){
            prev=step;
            step+=++k*blockSize;
            if(prev>=n-1){
                return 0;
            }
        }
        while(arr[prev]<x){
             ++prev;
             if(arr[prev]==x){
                 return 1;
             }
             if(prev==Math.min(step,n-1)){
                 return 0;
             }
        }
        return 0;
    }

    public static void main(String args[]){
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x = 377;
        JumpSearch jump=new JumpSearch();
        System.out.println(jump.search(arr,x));
    }
}
