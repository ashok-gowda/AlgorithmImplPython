
def binarySearch(arr,low,high,element):
    while low<high:
        mid=int((low+high)/2)
        if(arr[mid]==element):
            return mid+1;
        elif(arr[mid]<element):
            low=mid+1
        else:
            high=mid-1

    return low if arr[low]>element else low+1


def binaryInsertionSort(arr):
    for i in range(1,len(arr)):
        low,high=0,i-1
        p=binarySearch(arr,low,high,arr[i])
        j=i
        elementToBePlaced=arr[i]
        while j>=p:
            arr[j]=arr[j-1]
            j-=1
        arr[p]=elementToBePlaced

    for i in range(len(arr)):
        print(str(arr[i]),sep=' ')

if __name__=="__main__":
    arr = [40, 24, 1, 2, 25, 50]
    binaryInsertionSort(arr)