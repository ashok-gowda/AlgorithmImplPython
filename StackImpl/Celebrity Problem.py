list=[[0,0,1,0],[1,1,1,1],[0,0,0,0],[1,0,0,0]]
#O(n) Celebrity Problem
def knows(i,j):
    if list[i][j]==1:
        return True
    else:
        return False
p=[0,1,2,3]
def findCelebrity(p):
    celebrity=0
    i=1
    while(i<len(p)-1):
         if knows(celebrity,i):
             celebrity=i
         i+=1
    print(str(celebrity))

if __name__=="__main__":
    findCelebrity(p)

