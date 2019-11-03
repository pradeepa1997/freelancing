import Bucket
import MyHashableKey
import Exeption


class HashMap:
    def __init__(self):
        self.tablesize=19
        self.hashtable=[None]*self.tablesize

    def insert(self,key,data):
    
        index=key%self.tablesize
        
        if self.hashtable[index] is None:
            self.hashtable[index]=Bucket.Bucket()
        if(self.hashtable[index].contains(key)):
            raise Exeption.ItemExistsException()
           
        self.hashtable[index].insert(key,data)

        if(len(self)>self.tablesize*1.20):
            self.rebuild()

    def update(self,key,data):
        index=key%self.tablesize
        if self.hashtable[index] is not None:
            if self.hashtable[index].contains(key) is False:
                raise Exeption.NotFoundException()

            self.hashtable[index].update(key,data)
        else:
            raise Exeption.NotFoundException()
        
            

    def find(self,key):
        index=key%self.tablesize

        if self.hashtable[index] is not None:
            if self.hashtable[index].contains(key) is False:
                raise Exeption.NotFoundException()
            return self.hashtable[index].find(key)

        else:
            raise Exeption.NotFoundException()

    def contains(self,key):
        
        index=key%self.tablesize
        if self.hashtable[index] is not None:
            return self.hashtable[index].contains(key)
        else:
            return False

    def remove(self,key):
        index=key%self.tablesize
        if self.hashtable[index] is not None:
            if self.hashtable[index].contains(key) is False:
                raise Exeption.NotFoundException()
            self.hashtable[index].remove(key)
        

    def __setitem__(self,key,data):
        index=key%self.tablesize
        if self.hashtable[index] is not None:
            self.hashtable[index].__setitem__(key,data)
        else:
            self.hashtable[index]=Bucket.Bucket()
            self.hashtable[index].insert(key,data)
    def __getitem__(self,key):
        index=key%self.tablesize
        if self.hashtable[index]:
            return self.hashtable[index].find(key)
        else:
            raise Exeption.NotFoundException()

    def __len__(self):
        lenght=0
        for i in range(self.tablesize):
            if self.hashtable[i] is not None:
                lenght+=len(self.hashtable[i])

        return lenght

    def rebuild(self):
        oldtablesize=self.tablesize
        self.tablesize=(self.tablesize*2)+1

        oldhashtable=self.hashtable

        for i in range(len(oldtablesize)):
            if oldhashtable[i] is not None:
                temp=oldhashtable[i]
                while temp is not None:
                    self.insert(temp.key,temp.data)












    
