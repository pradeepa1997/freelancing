import random

def message(n):
    if(n<7):
        return "Worst than 7"
    if(n>7):
        return "Better than 7"
    else:
        return "Exactly 7"
    
def testcase1(casenum):
    if(casenum ==1):
        die1=1
        die2=4
        Sum = die1+die2
        print(die1,die2,Sum,message(Sum))
    if(casenum ==2):
        die1=1
        die2=6
        Sum = die1+die2
        print(die1,die2,Sum,message(Sum))
    if(casenum ==3):
        die1=6
        die2=1
        Sum = die1+die2
        print(die1,die2,Sum,message(Sum))
    if(casenum ==4):
        die1=5
        die2=5
        Sum = die1+die2
        print(die1,die2,Sum,message(Sum))

        
def testcase2():
    for i in range(len(list1)):
        for j in range(len(list2)):
            die1=list1[i]
            die2=list2[j]
            Sum = die1+die2
            print(die1,die2,Sum,message(Sum))
            
def testcase3():
    arr = [0,0,0,0,0,0,0,0,0,0,0]
    testcount=0
    while(testcount!=36000):
        Sum=0
        die1 = random.choice(list1)
        die2 = random.choice(list2)
        Sum = die1+die2
        arr[Sum-2]=arr[Sum-2]+1
        testcount=testcount+1
        
    for i in range(len(arr)):
        print(i+2 , arr[i])
        

list1=[1,2,3,4,5,6]
list2=[1,2,3,4,5,6]       
print("Enter 1 to run the game ")
print("Enter 2 to run testcases ")


x= int(input())
if (x ==1):
    print("Enter 1 to roll the die : ")
    print("Enter 0 to end the game : ")
    y = int(input())
    if(y):
        while(x):
            die1 = random.choice(list1)
            die2 = random.choice(list2)
            Sum = die1+die2
            print(message(Sum), end='\n\n\n')
            print("Enter 1 to roll the die ")
            print("Enter 0 to end the game ", end='\n\n')
            x= int(input())

if (x==2):
    print("Enter 1 to run testcase 1 ")
    print("Enter 2 to run testcase 2 ")
    print("Enter 3 to run testcase 3 ")
    y = int(input())
    if (y ==1):
        testcase1(1)
        testcase1(2)
        testcase1(3)
        testcase1(4)
    if (y ==2):
        testcase2()
    if (y==3):
        testcase3()



