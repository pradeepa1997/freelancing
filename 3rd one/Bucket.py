import Node
import Exeption

class Bucket:
    def __init__(self):
        self.head=None

    def insert(self,key,data):
        if(self.head==None):
            self.head=Node.Node(key,data)

        else:
            temp=self.head
            while temp.next is not None:
                if temp.key is key:
                    raise Exeption.ItemExistsException()
                temp=temp.next

            temp.next=Node.Node(key,data)
    def update(self,key,data):
        temp=self.head
        while temp is not None:
            if temp.key is key:
                temp.data=data
                return
            temp=temp.next
        raise Exeption.NotFoundException()

    def find(self,key):
        temp=self.head
        while temp is not None:
            if temp.key is key:
                return temp.data
            temp=temp.next
        
        raise Exeption.NotFoundException()


    def contains(self,key):
        temp=self.head
        
        while temp is not None:
            #if there is key contain value "key" this if execute and return true
            if temp.key is key:
                return True
            temp=temp.next
        #above while loop finish mean there is no key contain value key therefore return false
        return False

        
    def remove(self,key):
        #this is an special case which is removing head of the list
        if self.head.key is key:
            self.head=self.head.next
            return
        temp=self.head
        pre=None
        while temp is not None:
            if temp.key is key:
                pre.next=temp.next
                return
            pre=temp
            temp=temp.next
        Exeption.NotFoundException()

    def __setitem__(self,key,data):
        temp=self.head
        #find key in exist linklist and if it is there update it
        while temp is not None:
            if temp.key is key:
                temp.data=data
                return
            temp=temp.next
        #programe has come to this line mean this key is not in our linklist therefore add new Node
        self.insert(key,data)
    def __getitem__(self, key):
        return self.find(key)
    
    def __len__(self):
        count=0
        temp=self.head
        while temp is not None:
            count+=1
            temp=temp.next
        return count

    
    #this is a function which is return whole node cantain key value as "key"
    # def search(self,key):
    #     temp=self.head
    #     while temp is not None:
    #         if temp.key is key:
    #             return temp
    #     return None
# m = Bucket()
# m.insert(5, "fimma")
# m.insert(4, "fjarri")
# m.insert(2, "tvistur")
# m.insert(5, "fimmarimma")
# m[1] = "ás"
# m.update(4, "fjarkalarki")
# m.update(6, "sexxxxxa")
# m[6] = "sexa"

# print("size of map: " + str(len(m)))
# print(m.contains(12))
# m[12] = "drottning"
# print(m.contains(12))

# print("size of map: " + str(len(m)))
# print(m.find(4))
# print(m[2])
# print(m[1])
# print(m[5])
# print(m.find(6))
# print(m[7])
# m.remove(5)
# print(m.find(5))
# print("size of map: " + str(len(m)))
    
