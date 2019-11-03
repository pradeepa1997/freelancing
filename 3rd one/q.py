def calculate(a,b,c):
    return (a*100)+(b*20)+(c*1)

"""
P:100
Q:20
R:1
"""

bill = int(input('Please enter the value of the bill you have to pay\n'))
print('Please enter the amount of 100 , 20 and 1 banknotes in your wallet')
P = int(input())
Q = int(input())
R = int(input())
print('')
count=0
for i in range(1,P+1):
    for j in range(1,Q+1):
        for k in range(1,R+1):
            temp=calculate(0,0,k)
            if temp==bill:
                count=+1
            temp=calculate(0,j,0)
            if temp==bill:
                count=+1
            temp=calculate(0,j,k)
            if temp==bill:
                count=+1
            temp=calculate(i,0,0)
            if temp==bill:
                count=+1
            temp=calculate(i,0,k)
            if temp==bill:
                count=+1
            temp=calculate(i,j,0)
            if temp==bill:
                count=+1
            temp=calculate(i,j,k)
            if temp==bill:
                count=+1


print('There are ',count,' ways to pay this bill:')

