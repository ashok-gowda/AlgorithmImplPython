class Position:
    def __init__(self,sum,low,high):
        self.sum=sum
        self.low=low
        self.high=high



def findMaxCrossSum(arr,low,high):
     mid=int((low+high)/2)
     leftSum=-50000
     sum=0
     i=mid
     crossLeft=mid
     while i>=0:
         sum+=arr[i]
         if sum>leftSum:
            leftSum=sum
            crossLeft=i
         i-=1
     j=mid+1
     sum=0
     rightSum=-50000
     crossRight=mid+1
     while j<=high:
         sum+=arr[j]
         if sum>rightSum:
             rightSum=sum
             crossRight=j
         j+=1
     return Position(leftSum+rightSum,crossLeft,crossRight)




def findMaximumSubarray(arr,low,high):
    if low==high:
        return Position(arr[low],low,high)
    mid=int((low+high)/2)
    leftSubArray=findMaximumSubarray(arr,low,mid)
    rightSubArray=findMaximumSubarray(arr,mid+1,high)
    crossSubArray=findMaxCrossSum(arr,low,high)
    if leftSubArray.sum>rightSubArray.sum and leftSubArray.sum>crossSubArray.sum:
        return leftSubArray
    elif rightSubArray.sum>crossSubArray.sum:
        return rightSubArray
    else:
        return crossSubArray


arr=[2, 3, 4, 5, -1]
p=findMaximumSubarray(arr,0,4)
print(str(p.sum)+" "+str(p.low)+" "+str(p.high))





