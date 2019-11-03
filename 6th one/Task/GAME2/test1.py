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
    


# this loop will run 5 time which for our 5 test cases 
for i in range(5):

    # finding card 1
    index1=random.randint(0,12)
    cardtype=random.randint(0,3)
    card1=returnCarde(cardtype,index1)
    value=0
    # Add to value to 1st card value
    if index1==12:
        value=13
    elif index1 <9:
        value=index1+2
    else:
        value=10
    
    
    # finding card 2
    index2=random.randint(0,12)
    cardtype=random.randint(0,3)
    card2=returnCarde(cardtype,index2)
    # Add to value to  2nd card value
    if index2==12:
        value=value+13
    elif index2 <9:
        value=value+index2+2
    else:
        value=value+10


    # finding card 3
    index3=random.randint(0,12)
    cardtype=random.randint(0,3)
    card3=returnCarde(cardtype,index3)

    # Add to value to  3rd card value
    if index3==12:
        value=value+13
    elif index3 <9:
        value=value+index3+2
    else:
        value=value+10

    
        
    #Print result
    
    print("Test case:",i+1)
    print("Card 1:",card1)
    print("Card 2:",card2)
    print("Card 3:",card3)
    print("Total:",value)

    # print a message using total value
    
    if value is 33:
        print("Message:Winner!!!!!")
    elif value >33:
         print("Message:Too high, you lose.")

    elif value >27 and value<33:
        print("Message:A good total")

    else:
        print("Message:You still might win")
    print("\n\n\n")

    
    
    
    




    
