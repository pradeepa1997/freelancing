# exeption classes
class ItemExistsException(Exception):
    pass
        

class NotFoundException(Exception):
    pass
# MyComparableKey class
class MyComparableKey:
    def __init__(self,int_value,string_value):
        self.int_value=int_value
        self.string_value=string_value
    
    def  __lt__(self,other):
        if self.int_value<other.int_value:
            return True
        else:
            return False

# creating node class for store node date
class Node:
    def __init__(self,key,data):
        self.key=key
        self.data=data
        self.left=None
        self.right=None
# implement of tree class
class Tree:
    def __init__(self):
            self.root=None

#insertig new node to tree
  
    def insert(self,key,data):
        # root is None easily create new node and eqaul it to root
        if self.root is None:
            self.root=Node(key,data)
            return
        # call recursive insertion function an equal return value to root
        self.root=self.insertion(self.root,key,data)

    def insertion(self,r,key,data):
        # if key is less than r.key
        if r.key>key:
            # if key is less than r.key and r.left is None . then insert new node as r.left node
            if r.left is None:
                r.left=Node(key,data)
            # if key is less than r.key and r.left is not None . then call insertion function for r.left subtree
            else:
                r.left=self.insertion(r.left,key,data)
        
        elif r.key<key:
            # if key is greater than r.key and r.right is None . then insert new node as r.right node
            if r.right is None:
                r.right=Node(key,data)
            # if key is greater than r.key and r.left is not None . then call insertion function for r.right subtree
            else:
                r.right=self.insertion(r.right,key,data)
        else:
                raise ItemExistsException()
        return r

        
    def update(self,r,key,data):
            if self.root is None or r.root is None:
                raise NotFoundException()
        
            # just find the given key and replace its data as new data
            if r.key>key:
                update(r.left,key,data)
            elif r.key<key:
                update(r.right,key,data)
            else:
                r.data=data
        
    def find(self,r,key):
        # finding given key and return contain data of given key
            if root is None or r is None:
                raise NotFoundException()

            if r.key>key:
                find(r.left,key)
            elif r.key<key:
                find(r.right,key)
            else:
                return r.data

    def contains(self,r,key):
        # if given key is here then return true ,is not then return false
            if root is None or r is None:
                return False
                
            if r.key>key:
                contains(r.left,key)
            elif r.key<key:
                contains(r.right,key)
            else:
                return True


    def remove(self,r,key):
            if self.root is None:
                raise NotFoundException()

            self.root=self.deleteNode(r,key)
            
    def deleteNode(self,r,key): 

        # This is base case which is exit condition in recursive function
        if r is None: 
            raise NotFoundException() 

        # if delete key less than current r key we should traversal left subtree
        if key < r.key: 
            r.left = self.deleteNode(r.left, key) 

        # if delete key greater than current r key we should traversal right subtree
        elif(key > r.key): 
            r.right = self.deleteNode(r.right, key) 

        # if r.key is key then we should delete the key
        else: 
            
            # Node with only one child or no child 
            if r.left is None : 
                temp = r.right 
                r = None
                return temp 
                
            elif r.right is None : 
                temp = r.left 
                r = None
                return temp 

            # if Node with two children has delete node.we will find smallest one in right subtree and replace it
        
            temp = self.minValueNode(r.right) 

            # replacing data 
            r.key = temp.key
            r.data=temp.data 

            # then call again recursivley delete function for that smallest node of right subtree 
            r.right = self.deleteNode(r.right , temp.key) 


        return r 

    def minValueNode(self,r): 
        current = r 

        # loop down to find the leftmost leaf 
        while(current.left is not None): 
            current = current.left 

        return current

    # overriding __setitem__ function

    def __setitem__(self,key,data):
            if self.contains(key):
                temp=self.root
                while True:
                    if temp.key is key:
                        temp.data=data
                    elif temp.key>key:
                        temp=temp.left
                    else:
                        temp=temp.right
            else:
                self.insert(key,data)

    # overriding __getitem__ function
    def __getitem__(self,key):
            return find(key)

    def size(self,r):
        if r is None:
            return 0

        right=size(r.right)
        left=size(r.left)

        return (1+right+left)

    # overriding __len__ function
    def __len__(self):

            temp=self.size(self.root)
            return temp
    def createstring(self,r):
        if r is None :
            return ""
        temp=self.createstring(r.left)+"{"+str(r.key)+":"+r.data+"} "+self.createstring(r.right)
        
        return temp



    def __str__(self):
        return self.createstring(self.root)




                

m= Tree()
m.insert(5,"five")
m.insert(3,"three")
m.insert(6,"six")
m.insert(1,"one")
m.insert(10,"ten")
m.insert(4,"four")
m.insert(8,"eight")
m.insert(9,"nine")
m.insert(2,"two")
m.insert(11,"eleven")


temp=str(m)
print(temp)
m.remove(m.root,5)
temp=str(m)
print(temp)

m.remove(m.root,6)
temp=str(m)
print(temp)

m.remove(m.root,1)
temp=str(m)
print(temp)











                    



    
