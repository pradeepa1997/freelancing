
def issorted(numbers):
    if sorted(numbers) == numbers:
        return True
    else:
        return False 
 
 
def sort(numbers):
    n=0
    import random
    while not issorted(numbers):
        n=n+1
        random.shuffle(numbers)
    print(n)
    return numbers 
 
 
print(sort([6, 3, 8, 5, 2, 7, 4, 1])) 

