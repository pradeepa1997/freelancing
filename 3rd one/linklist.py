import Exeption


class Node:
    def __init__(self,key,data):
        self.key=key
        self.data=data
        self.next=None

class LinkedList:
    def __init__(self):
        self.head=None

    def insert(self,key,data):
        if(self.head==None):
            self.head=Node(key,data)

        else:
            temp=self.head
            while temp.next is not None:
                temp=temp.next

            temp.next=Node(key,data)
    def print(self):
        temp=self.head
        while temp is not None:
            print(temp.key)
            print(temp.data)
            temp=temp.next
    def find(self,key):
        temp=self.head
        while temp is not None:
            if temp.key is key:
                return temp.data

    def __getitem__(self, key):
        return self.find(key)

        
    # def remove(self,key):
    #     temp=self.head
    #     while temp.key is not key:
    #         if(temp.next==None):



L_ist=LinkedList()
L_ist.insert(1,10)
L_ist.insert(7,23)
L_ist.insert(6,23)
L_ist.insert(5,23)
L_ist.insert(4,23)
L_ist.insert(3,23)
L_ist.insert(2,23)
print(L_ist[1])

# L_ist.print()
