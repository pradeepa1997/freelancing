import random   #import the random for calculate the random value

# This is an array which contain all cards names
cards=["Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"]
# this function return card in text when the pass random card type and random card
def returnCarde(cardtype,index):
    card=None
    # Selcting what is card type is
    if cardtype is 0:
        card="Spades"
    elif cardtype is 1:
        card ="Hearts"
    elif cardtype is 2:
        card="Diamonds"
    else:
        card="Clubs"
    # add to relevent card name for passed int value index
    card=cards[index]+" of "+card
    # finally return the card with card name and card type
    return card
    
# this array for save how many times each value occurd 
# This array should have only 40 element because max value can taken is 39 also array last index 39
outputarr=[0]*40
# this loop will run 10000 time mention as qeustion test case 3
for j in range(10000):

    # finding card 1
    index1=random.randint(0,12)
    cardtype1=random.randint(0,3)
    card1=returnCarde(cardtype1,index1)
    value=0
    # Add to value  1st card value
    if index1==12:
        value=13
    elif index1 <9:
        value=index1+2
    else:
        value=10
    
    
    # finding card 2
    card2=None
    card3=None
    cardtype2=None
    cardtype3=None

    while True:

        index2=random.randint(0,12)
        cardtype2=random.randint(0,3)
        #checking card2 is == card 1
        # if it is equal it will select another card untill it not equal to card1
        if index1==index2 and cardtype1==cardtype2:
            continue
        card2=returnCarde(cardtype2,index2)
        # Add to value  2nd card value
        if index2==12:
            value=value+13
        elif index2 <9:
            value=value+index2+2
        else:
            value=value+10
        break


    # finding card 3

    while True:

        index3=random.randint(0,12)
        cardtype3=random.randint(0,3)
        card3=returnCarde(cardtype3,index3)
        #checking card2 is == card3 and card3==card1
        # if it is equal it will select another card untill it not equal to card1 and card2
        if(cardtype3==cardtype2 and index3==index2) or (cardtype3==cardtype1 and index3==index1):
            continue

        # Add to value  3rd card value
        if index3==12:
            value=value+13
        elif index3 <9:
            value=value+index3+2
        else:
            value=value+10
        break
    # Add 1 to relevant element in the array
    outputarr[value]=outputarr[value]+1

# Finnaly print the number of winnigs occurd 
print("\n\n\n\n")
print("Number of Winning times:",outputarr[33])

        
            
    
        
        
