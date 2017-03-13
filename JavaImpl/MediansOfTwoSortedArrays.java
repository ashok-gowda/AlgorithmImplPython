/**
 * Created by ashokg on 13/3/17.
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 *Median of two sorted arrays
 *Question: There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
 */
public class MediansOfTwoSortedArrays
{
    public static int findMedianOfTwoSortedArrays(int arr1[],int arr2[],int low1,int high1,
                                           int low2,int high2){

         if(low1==high1 && low2==high2){
            return (arr1[low1]+arr2[low2])/2;
        }
        else if(high2-low2==1 && high1-low1==1){
            int op1=Math.max(arr1[low1],arr2[low2]);
            int op2=Math.min(arr1[high1],arr2[high2]);
            return (op1+op2)/2;
        }
        int m1=getMedian(arr1,low1,high1);
        int m2=getMedian(arr2,low2,high2);
        if(m1==m2){
            return m1;
        }
        else if(m1<m2){
             int mid1=(low1+high1)/2;
             int mid2=(low2+high2)/2;
             return findMedianOfTwoSortedArrays(arr1,arr2,mid1,high1,low2,mid2);
        }
        else{
            int mid1=(low1+high1)/2;
            int mid2=(low2+high2)/2;
            return findMedianOfTwoSortedArrays(arr1,arr2,low1,mid1,mid2,high2);
        }

    }

    public static int getMedian(int arr[],int low,int high){
        int Size=high-low+1;
        int mid=(low+high)/2;
        if(Size%2==0){
            return arr[mid];
        }
        return (arr[mid]+arr[mid+1])/2;
    }

    public static void main(String args[]){
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 14, 17, 30, 45};
        int p=MediansOfTwoSortedArrays.
                findMedianOfTwoSortedArrays(ar1,ar2,0,3,0,3);
        System.out.println(p);
    }
}
