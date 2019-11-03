

class MyHashableKey:
    def __init__(self,int_value,string_value):
        self.string_value=string_value
        self.int_value=int_value



    def __eq__(self,other):
        if self.__hash__() == other.__hash__():
            return True
        else:
            return False
    def __hash__(self):
        stringval=0
        for i in range(len(self.string_value)):
            stringval+=(ord(self.string_value[i]))
        index=stringval*self.int_value
        return index