
from tkinter import *
import tkinter.messagebox as tm
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
output=None
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

#import pymysql

output=[0]*6
temp=[None]*6


class LoginFrame(Frame):

    def __init__(self, master):
        super().__init__(master)

        #Row 1
        L1 = Label(top, text = "Destinations")
        L1.place(x = 10,y = 10)

        L2 = Label(top, text = "Max tool weight")
        L2.place(x = 300,y = 10)

        B = Button(top, text = "Exit")
        B.place(x = 950, y = 10)

        #Row 2
        L3 = Label(top, text = "Tool Weights")
        L3.place(x = 500,y = 50)
        
        L4 = Label(top, text = "Available")
        L4.place(x = 700,y = 50)

        L5 = Label(top, text = "Crew : 100KG")
        L5.place(x = 300,y = 100)

        self.E1 = Entry(top, bd = 3)
        self.E1.place(x = 500,y = 100)

        self.E2 = Entry(top, bd = 3)
        self.E2.place(x = 500,y = 150)

        self.E3 = Entry(top, bd = 3)
        self.E3.place(x = 500,y = 200)

        self.E4 = Entry(top, bd = 3)
        self.E4.place(x = 500,y = 250)


        self.E5 = Entry(top, bd = 3)
        self.E5.place(x = 500,y = 300)
        
        self.E6 = Entry(top, bd = 3)
        self.E6.place(x = 500,y = 350)

        L5 = Label(top, text = "Mission specialists")
        L5.place(x = 300,y = 250)

        
        

        



        Calculate = Button(top, text = "Calculate",command=lambda: self.retrieve_input())
        Calculate.place(x = 700, y = 500)

        frame = Frame(top)
        frame.place(x = 10, y = 40)

        lb = Listbox(frame, width=30, height=20)
        lb.pack(side = 'left',fill = 'y' )

        scrollbar = Scrollbar(frame, orient="vertical",command=lb.yview)
        scrollbar.pack(side="right", fill="y")

        lb.config(yscrollcommand=scrollbar.set)

        for key in mass_multi:
            lb.insert(END,key)
        

        top.geometry("1000x600+10+10")

    def retrieve_input(self):
        temp[0]=self.E1.get()
        temp[1]=self.E2.get()
        temp[2]=self.E3.get()
        temp[3]=self.E4.get()
        temp[4]=self.E5.get()
        temp[5]=self.E6.get()
        self.display()
        

    def display(self):
        # calculating each personal mass
        output[0]=personalItemMass("crew",int(temp[0]))
        output[1]=personalItemMass("crew",int(temp[1]))
        output[2]=personalItemMass("crew",int(temp[2]))
        output[3]=personalItemMass("crew",int(temp[3]))
        output[4]=personalItemMass("crew",int(temp[4]))
        output[5]=personalItemMass("crew",int(temp[5]))

        self.E7 = Label(top, text = output[0])
        self.E7.place(x = 700,y = 100)

        self.E8 = Label(top, text = output[1])
        self.E8.place(x = 700,y = 150)


        self.E9 = Label(top, text = output[2])
        self.E9.place(x = 700,y = 200)

        self.E10 = Label(top, text = output[3])
        self.E10.place(x = 700,y = 250)


        self.E11 =Label(top, text = output[4])
        self.E11.place(x = 700,y = 300)
        
        self.E12 = Label(top, text = output[5])
        self.E12.place(x = 700,y = 350)
        # L15 = Label(top, text = temp[0])
        # L15.place(x = 400,y = 400)


top = Tk()
top.title("Planetary Expoloration App")

lf = LoginFrame(top)
top.mainloop()

