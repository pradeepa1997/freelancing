import MyHashableKey

# READ THIS!!
# DO NOT USE THE BUILT-IN HASH
# FUNCTIONS FOR INTEGERS AND STRINGS!
# MAKE SURE YOUR IMPLEMENTATION OF
# __hash__ RETURNS A POSITIVE INTEGER!

if __name__ == "__main__":
    k1 = MyHashableKey.MyHashableKey(1, "one")
    print(hash(k1))
    k2a = MyHashableKey.MyHashableKey(2, "two")
    print(hash(k2a))
    k2b = MyHashableKey.MyHashableKey(2, "two")
    print(hash(k2b))
    print(k1 == k2a)
    print(k2a == k2b)
