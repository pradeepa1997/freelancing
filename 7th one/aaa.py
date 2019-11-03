#import pymysql
from tkinter import *
import tkinter.messagebox as tm



    
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

        E1 = Entry(top, bd = 3)
        E1.place(x = 700,y = 100)

        E2 = Entry(top, bd = 3)
        E2.place(x = 500,y = 100)


        E3 = Entry(top, bd = 3)
        E3.place(x = 700,y = 150)

        E4 = Entry(top, bd = 3)
        E4.place(x = 500,y = 150)


        E5 = Entry(top, bd = 3)
        E5.place(x = 700,y = 200)
        
        E6 = Entry(top, bd = 3)
        E6.place(x = 500,y = 200)

        L5 = Label(top, text = "Mission specialists")
        L5.place(x = 300,y = 250)

        E7 = Entry(top, bd = 3)
        E7.place(x = 700,y = 250)

        E8 = Entry(top, bd = 3)
        E8.place(x = 500,y = 250)


        E9 = Entry(top, bd = 3)
        E9.place(x = 700,y = 300)

        E10 = Entry(top, bd = 3)
        E10.place(x = 500,y = 300)


        E11 = Entry(top, bd = 3)
        E11.place(x = 700,y = 350)
        
        E12 = Entry(top, bd = 3)
        E12.place(x = 500,y = 350)



        Calculate = Button(top, text = "Calculate")
        Calculate.place(x = 700, y = 500)

        frame = Frame(top)
        frame.place(x = 10, y = 40)

        lb = Listbox(frame, width=30, height=20)
        lb.pack(side = 'left',fill = 'y' )

        scrollbar = Scrollbar(frame, orient="vertical",command=lb.yview)
        scrollbar.pack(side="right", fill="y")

        lb.config(yscrollcommand=scrollbar.set)

        for i in range(10):
            lb.insert(END, 'test'+str(i))
        

        top.geometry("1000x600+10+10")


top = Tk()
top.title("Student Registration System")

lf = LoginFrame(top)
top.mainloop()
