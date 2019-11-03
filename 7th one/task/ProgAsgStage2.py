
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
    temp=0
    if type is "crew":
        return crew_max-weight
    elif type is "spec":
        return speci_max-weight
# calculate the availble average mass when pass all availble mass 
def retTot(list):
    tot=0
    for i in list:
        tot=tot+i

    return tot
def calcAvg(list):
    total=retTot(list)
    avg=total/len(list)
    return avg
# calculate average availble weight
def avgAvalibleWei(dest,avg):
    return avg*mass_multi[dest]





temp=[0]*6
output=['']*6




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

        self.Lb1 = Listbox(top)
        i=1
        for key in mass_multi:
            self.Lb1.insert(i,key)
            i=i+1

        self.Lb1.pack()
        self.Lb1.place(x = 10,y = 40)
        

        top.geometry("1000x600+10+10")

    def retrieve_input(self):
        temp[0]=self.E1.get()
        temp[1]=self.E2.get()
        temp[2]=self.E3.get()
        temp[3]=self.E4.get()
        temp[4]=self.E5.get()
        temp[5]=self.E6.get()
        key=self.Lb1.curselection()
        print(key)
        self.display(key)
        

    def display(self,key):
        # calculating each personal mass
        

        output[0]=personalItemMass("crew",int(temp[0]))
        output[1]=personalItemMass("crew",int(temp[1]))
        output[2]=personalItemMass("crew",int(temp[2]))
        output[3]=personalItemMass("spec",int(temp[3]))
        output[4]=personalItemMass("spec",int(temp[4]))
        output[5]=personalItemMass("spec",int(temp[5]))

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
        total=retTot(output)
        ans="Total Available Mass:"+str(total)
        self.tot=Label(top,text=ans)
        self.tot.place(x=200,y=400)
        avg=calcAvg(output)

        ans="Average Available Mass:"+str(avg)
        self.avg=Label(top,text=ans)
        self.avg.place(x=200,y=420)
        val=None
        key=key[0]
        print(key)
        i=0
        val=None
        for j in mass_multi:
            
            if i is key:
                val=j
                break
            i=i+1

        data=avgAvalibleWei(val,avg)
        ans="Average Available weight on  destination:"+str(data)
        self.valu=Label(top,text=ans)
        self.valu.place(x=200,y=440)
        


top = Tk()
top.title("Planetary Expoloration App")

lf = LoginFrame(top)
top.mainloop()
