arr=[14,15,1,24,2,20]
for i in range(len(arr)):
    minimumElement=i
    for j in range(i+1,len(arr)):
        if arr[minimumElement]>arr[j]:
            minimumElement=j
    arr[i],arr[minimumElement]=arr[minimumElement],arr[i]

for i in range(len(arr)):
    print(str(arr[i]),sep=' ',end=' \n')