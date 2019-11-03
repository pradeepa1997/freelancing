class MyComparableKey:
    def __init__(self,int_value,string_value):
        self.int_value=int_value
        self.string_value=string_value
    
    def  __lt__(self,other):
        if self.int_value<other.int_value:
            return True
        else:
            return False
