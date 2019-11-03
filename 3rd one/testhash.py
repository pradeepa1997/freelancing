import Bucket
import MyHashableKey


class HashMap:
    def __init__(self):
        self.tablesize=19
        self.hashtable=[None]*self.tablesize

    def insert(key,data):
        hashkey=MyHashableKey.MyHashableKey(key,data)
        index=hashkey.__hash__()%tablesize
        if self.hashtable[index] is None:
            self.hashtable[index]=Bucket.Bucket()
            self.hashtable[index].insert(key,data)
        else:
            self.hashtable[index].insert(key,data)

    def find(self,key):
        hashkey=MyHashableKey.MyHashableKey(key,data)
        index=hashkey.__hash__()%tablesize
        if self.hashtable[index] is not None:
            return self.hashtable[index].find(key,data)


    def contains(self,key):
        hashkey=MyHashableKey.MyHashableKey(key,data)
        index=hashkey.__hash__()%tablesize
        if self.hashtable[index] is not None:
            return self.hashtable[index].contains(key,data)
        else:
            return False

    def remove(self,key):
        

m =HashMap()

m.hashtable[5]="hello"
m.hashtable[4]=1
m
print(m.hashtable[1])
