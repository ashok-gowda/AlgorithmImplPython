#http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
#Now implementing the O(n) Version

def calculatePowerOfX(x,n):
    if(n==1):
        return x
    elif n%2==0:
        return calculatePowerOfX(x,n/2)*calculatePowerOfX(x/n/2)
    else:
        return x*calculatePowerOfX(x,n/2)*calculatePowerOfX(x/n/2)

#NowImplementingthe O(logn) version

def calculatePowerOfX1(x,n):
    if(n==1):
        return x
    t=calculatePowerOfX1(x,int(n/2))
    if(n%2==0):
        return t*t
    else:
        return x*t*t


print(calculatePowerOfX1(2,3))



























