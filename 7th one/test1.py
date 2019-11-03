

# Celestial body and relevent Mass Multiplier
mass_multi=dict()
mass_multi["Mercury"]=0.378
mass_multi["Venus"]=0.907
mass_multi["Moon"]=0.166
mass_multi["Mars"]=0.377
mass_multi["Ganymede"]=0.1835
mass_multi["Europe"]=0.1335
mass_multi["Gynmede"]=0.1448
mass_multi["Callisto"]=0.1264
# const variables for Fight crew max and Mission specialists max
crew_max=100
speci_max=150
# calculate available personal item mass it gets weight and type of astronaut

def personalItemMass(type,weight):
    if type is "crew":
        return crew_max-weight
    elif type is "spec":
        return speci_max-weight
# calculate the availble average mass when pass all availble mass 
def calcAvg(list):
    total=0
    for i in list:
        total=total+i
    avg=total/len(list)
    return avg
# calculate average availble weight
def avgAvalibleWei(dest,avg):
    return avg*mass_multi[dest]


def Calculate():
    dest=None
    while True:
        dest=input("Destination Selected:\t")
        if dest in mass_multi:
            break
        print("Invalid destionantion please enter valid one")

    crew=input("Entered tool weights for crew:\t")
    speci=input("Entered tool weights for mission specialists:")
    crewarr=crew.split(",")
    speciarr=speci.split(",")
    output=[]
    for i in range(3):
        temp=crew_max-int(crewarr[i])
        output.append(temp)
    for i in range(3):
        temp=speci_max-int(speciarr[i])
        output.append(temp)
    total=0
    for i in output:
        total=total+i
    
    avg=total/len(output)
    weightdest=avg*mass_multi[dest]

    print("Available mass for astronauts:",end = '')
    for i in output:
        print(i,end=',')
    print("\nTotal Available Mass:",total)
    print("Average Available Mass:",avg)
    print("Average Available weight on  destination:",weightdest)



def printDestinations():
    for key in mass_multi:
        print(key,"-",mass_multi[key])

def printallowances():
    print("\n\n\n")
    print("Weight Allowance for Flight crew:",crew_max)
    print("Weight Allowance for Mission specialists:",speci_max)
    print("\n\n\n")

def printMenu(): 
    print("Astronaut Mass Allowance Calculator")
    print("A:Display Programe option")
    print("B:Display Destinations with Mass Multipliers")
    print("C:Display Weight allowances for astronauts")
    print("D:Calculate Personal Mass allowance")
    print("E:Calculate Average Available mass and weight")
    print("X:Exit")
    return input()

def main():
    while True:
        inputval=printMenu()
        if inputval is "A":
            print("c")
        elif inputval is "B":
            printDestinations()
        elif inputval is "C":
            printallowances()
        elif inputval is "D":
            Calculate()
        elif inputval is "E":
            print("c")
        elif inputval is "X":
            break
        else:
            print("\n\n\n==========Invalid input========\n\n\n")

# main()
Calculate()
