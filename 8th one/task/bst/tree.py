import node
import exeption

class BSTMap:
    def __init__(self):
            self.root=None

#insertig new node to tree
  
    def insert(self,key,data):
        # root is None easily create new node and eqaul it to root
        if self.root is None:
            self.root=node.Node(key,data)
            return
        # call recursive insertion function an equal return value to root
        self.root=self.insertion(self.root,key,data)

    def insertion(self,r,key,data):
        # if key is less than r.key
        if r.key>key:
            # if key is less than r.key and r.left is None . then insert new node as r.left node
            if r.left is None:
                r.left=node.Node(key,data)
            # if key is less than r.key and r.left is not None . then call insertion function for r.left subtree
            else:
                r.left=self.insertion(r.left,key,data)
        
        elif r.key<key:
            # if key is greater than r.key and r.right is None . then insert new node as r.right node
            if r.right is None:
                r.right=node.Node(key,data)
            # if key is greater than r.key and r.left is not None . then call insertion function for r.right subtree
            else:
                r.right=self.insertion(r.right,key,data)
        else:
                raise exeption.ItemExistsException()
        return r

        
    def update(self,key,data):
            if self.root is None:
                raise exeption.NotFoundException()
        
            # just find the given key and replace its data as new data
            self.updateRecursion(self.root,key,data)

    def updateRecursion(self,r,key,data):
        if r is None:
            raise exeption.NotFoundException()
        
            # just find the given key and replace its data as new data
        if r.key>key:
            self.updateRecursion(r.left,key,data)
        elif r.key<key:
            self.updateRecursion(r.right,key,data)
        else:
            r.data=data

    def find(self,key):
        # finding given key and return contain data of given key
        if self.root is None :
            raise exeption.NotFoundException()

            
    def findRecursion(self,r,key):
        if r is None:
            raise exeption.NotFoundException()
        if r.key>key:
            self.findRecursion(r.left,key)
        elif r.key<key:
            self.findRecursion(r.right,key)
        else:
            return r.data


    def contains(self,key):
        # if given key is here then return true ,is not then return false
            if self.root is None:
                return False
                
            self.containsRecursion(self.root,key)

    def containsRecursion(self,r,key):
        if r is None:
            return False

        if r.key>key:
            self.containsRecursion(r.left,key)
        elif r.key<key:
            self.containsRecursion(r.right,key)
        else:
            return True
        
    
        



    def remove(self,key):
            if self.root is None:
                raise exeption.NotFoundException()

            self.root=self.deleteNode(self.root,key)
            
    def deleteNode(self,r,key): 

        # This is base case which is exit condition in recursive function
        if r is None: 
            raise exeption.NotFoundException() 

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
            return self.find(key)

    def size(self,r):
        if r is None:
            return 0

        right=self.size(r.right)
        left=self.size(r.left)

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