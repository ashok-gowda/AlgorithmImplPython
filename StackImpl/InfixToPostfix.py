def constructPreceDict():
    prec={}
    prec['*']=2
    prec['\\']=2
    prec['-']=1
    prec['+']=1
    prec['(']=0
    return prec

def constructPreceDictForPrefix():
    prec = {}
    prec['*'] = 2
    prec['\\'] = 2
    prec['-'] = 1
    prec['+'] = 1
    prec[')'] = 0
    return prec

def getStackContents(stack,top):
    while top>=0:
        print(str(stack[top]),end=' ')
        top-=1
    print()

def  getPostfixExpression(string):
     infixList=list(string)
     postList=[]
     stack=[]
     top=-1
     precisionDictionary=constructPreceDict()
     for a in infixList:
         if not a in precisionDictionary and a !=')':
             postList.append(a)
         elif a=='(':
             stack.append('(')
             top+=1
         elif a in precisionDictionary:
              while (top>=0) and (precisionDictionary[stack[top]]>=
                  precisionDictionary[a]):
                  postList.append(stack[top])
                  top-=1
                  stack.pop()
              top+=1
              stack.append(a);
         elif a==')':
              while 1:
                  if stack[top]=='(':
                      stack.pop()
                      top-=1
                      break
                  postList.append(stack[top])
                  stack.pop()
                  top-=1

     while top>=0:
           postList.append(stack[top])
           top-=1
     return ''.join(postList)




def postfixEvaluation(string):
    postFixString=list(string)
    stack=[]
    top=-1
    precedenceDictionary=constructPreceDict()
    for a in postFixString:
        if not a in precedenceDictionary:
           stack.append(a)
           top+=1
        elif a in precedenceDictionary:
            op2=stack.pop()
            op1=stack.pop()
            top-=2
            answer=op1+a+op2
            stack.append(answer)
            top+=1
    return stack[0]

def convertInfixToPrefix(infixExpression):
    infixList=list(infixExpression)# Scan from right to left
    prefixList=[];infixList.reverse();
    precedenceDictionary=constructPreceDictForPrefix()
    stack=[]
    stack.insert(0,')')
    top=0
    infixList.insert(len(infixList),"(")
    for a in infixList:
        if a==')':
            stack.append(a)
            top+=1
        elif a=='(':
             while top>=0:
                 if stack[top]==')':
                    stack.pop()
                    top-=1
                    break
                 prefixList.insert(0,stack.pop())
                 top-=1
        elif a in precedenceDictionary:
             while top>=0 and(precedenceDictionary[stack[top]]>precedenceDictionary[a]):
                 prefixList.insert(0, stack.pop())
                 top-= 1;
             stack.append(a)
             top+=1
        elif a not in precedenceDictionary:
            prefixList.insert(0,a)
    return "".join(prefixList);

















if __name__=='__main__':
   #print(getPostfixExpression("(A+B)*C-(D-E)*(F+G)"))
   #print(postfixEvaluation("AB+C*DE-FG+*-"))
    print(convertInfixToPrefix("(A+B)*C-(D-E)*(F+G)"))