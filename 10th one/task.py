import random

# This is randome number generator function it will get two argument ,amount is number of random numbers you are going to generate
# and second one is max number can generate
def generateRandom(amount,n):return [random.randint(0,n) for i in range(amount)]
    
# This function will get two arguments ,both are numbers then it return larger one
def returnLarger(a,b):return a if a>b else b 
# This function will get one argument. It should be a list of numbers.Function will return only even numbers
def removeOdd(list):
    return [item for item in list if (item%2)==0] 


# testing fintions

print(generateRandom(5,100))
print(returnLarger(6,5))
print(removeOdd([1,2,3,4,5,6,7,8,9]))

