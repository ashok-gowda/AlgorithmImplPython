#This program is to find out the next greatest element using stack
##It can also be used to find the next smallest previous smallest
#O(n) Implementation
class Node:
      def __init__(self,data,index):
          self.data=data
          self.index=index

class Stack:
      def __init__(self):
          self.enteredList=[]
          self.stackObject=[]
          self.stacktop=-1
          self.nextGreatestIndex={}
          self.nextSmallestIndex={}
          self.previousSmallestIndex={}

      def pushdatatoList(self,list):
          self.enteredList=list

      def pushdatatoStack(self,data):
          self.stackObject.append(data)

      def constuctNextGreatestDictionary(self):
          for i in range(len(self.enteredList)):
              self.nextGreatestIndex[i]=len(self.enteredList)

      def constuctNextSmallestDictionary(self):
          self.stacktop=-1
          self.stackObject=[]
          for i in range(len(self.enteredList)):
              self.nextSmallestIndex[i]=len(self.enteredList)


      def findNextGreatestElement(self):
          self.constuctNextGreatestDictionary()
          for i in range(0, len(self.enteredList)):
              if self.stacktop<0:
                  self.pushdatatoStack(Node(self.enteredList[i],i))
                  self.stacktop += 1
              else:
                  while  self.stacktop>=0 and (self.enteredList[i]> self.stackObject[self.stacktop].data) :
                      self.nextGreatestIndex[self.stackObject[self.stacktop].index]=i
                      self.stackObject.pop()
                      self.stacktop-=1
                  self.stacktop+=1
                  self.pushdatatoStack(Node(self.enteredList[i],i))
          while self.stacktop>=0:
              self.stacktop-=1

      def findNextSmallestElement(self):
          self.constuctNextSmallestDictionary()
          for i in range(0, len(self.enteredList)):
              if self.stacktop < 0:
                  self.pushdatatoStack(Node(self.enteredList[i], i))
                  self.stacktop += 1
              else:
                  while self.stacktop >= 0 and (self.enteredList[i] < self.stackObject[self.stacktop].data):
                      self.nextSmallestIndex[self.stackObject[self.stacktop].index] = i
                      self.stackObject.pop()
                      self.stacktop -= 1
                  self.stacktop += 1
                  self.pushdatatoStack(Node(self.enteredList[i], i))




      def getElementFromDictionaryIndexes(self,dictionary):
          for (key,value) in dictionary.items():
              if value!=len(self.enteredList):
                print("List number"+str(self.enteredList[key])+
                    " at index"+str(key)+" Next Element Value "+str(self.enteredList[value]))
              else:
                  print("List number"+str(self.enteredList[key])+
                    "at index"+str(key)+"  Not found");

if __name__=="__main__":
    a = Stack()
    a.pushdatatoList([12,11,10,19,3])
    a.findNextGreatestElement()
    a.getElementFromDictionaryIndexes(a.nextGreatestIndex)
    print("NEXT SMALLEST ELEMENT IMPLEMENTATION")
    a.findNextSmallestElement()
    a.getElementFromDictionaryIndexes(a.nextSmallestIndex)

