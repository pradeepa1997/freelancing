
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












output=['']*6

def retrieve_input():
    temp=[None]*6
    temp[0]=LoginFrame.E1.get("1.0","end-1c")
    temp[1]=LoginFrame.E2.get("1.0","end-1c")
    temp[2]=LoginFrame.E3.get("1.0","end-1c")
    temp[3]=LoginFrame.E4.get("1.0","end-1c")
    temp[4]=LoginFrame.E5.get("1.0","end-1c")
    temp[5]=LoginFrame.E6.get("1.0","end-1c")

# calculating each personal mass
    output[0]=personalItemMass("crew",int(temp[0]))
    output[1]=personalItemMass("crew",int(temp[1]))
    output[2]=personalItemMass("crew",int(temp[2]))
    output[3]=personalItemMass("crew",int(temp[3]))
    output[4]=personalItemMass("crew",int(temp[4]))
    output[5]=personalItemMass("crew",int(temp[5]))


    
    
    

    
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
        self.E1.place(x = 700,y = 100)
        self.E1.pack()

        self.E2 = Entry(top, bd = 3)
        self.E2.place(x = 500,y = 100)


        self.E3 = Entry(top, bd = 3)
        self.E3.place(x = 700,y = 150)

        self.E4 = Entry(top, bd = 3)
        self.E4.place(x = 500,y = 150)


        self.E5 = Entry(top, bd = 3)
        self.E5.place(x = 700,y = 200)
        
        self.E6 = Entry(top, bd = 3)
        self.E6.place(x = 500,y = 200)

        L5 = Label(top, text = "Mission specialists")
        L5.place(x = 300,y = 250)

        E7 = Label(top, text = output[0])
        E7.place(x = 700,y = 250)

        E8 = Label(top, text = output[1])
        E8.place(x = 500,y = 250)


        E9 = Label(top, text = output[2])
        E9.place(x = 700,y = 300)

        E10 = Label(top, text = output[3])
        E10.place(x = 500,y = 300)


        E11 =Label(top, text = output[4])
        E11.place(x = 700,y = 350)
        
        E12 = Label(top, text = output[5])
        E12.place(x = 500,y = 350)



        Calculate = Button(top, text = "Calculate",command=lambda: retrieve_input())
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


top = Tk()
top.title("Planetary Expoloration App")

lf = LoginFrame(top)
top.mainloop()

