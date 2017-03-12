arr=[40,24,1,2,25,50]
for i in range(len(arr)):
    for j in range(len(arr)-1):
        if arr[j]>arr[j+1]:
            arr[j],arr[j+1]=arr[j+1],arr[j]

for i in range(len(arr)):
    print(arr[i],sep=' ')
