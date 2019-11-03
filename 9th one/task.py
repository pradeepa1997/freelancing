import sys
rot13dic=dict()
rot5dic=dict()
rot47dic=dict()
val = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
key = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM"

for i in range(52):
    rot13dic[key[i]]=val[i]

key="0123456789"
val="45678901234"

for i in range(10):
    rot5dic[key[i]]=val[i]

key="PQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNO"
val="!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"

for i in range(94):
    rot47dic[key[i]]=val[i]

def rot13(cyphertext):
    plain_text=''
    for c in cyphertext:
        if ord(c) >ord('z') or ord(c)<ord('A'):
            print("Invalid argument!!!!!!!!!\nPlease enter valid one")
            return
        if ord(c)>ord('Z') and ord(c)<ord('a'):
            print("Invalid argument!!!!!!!!!\nPlease enter valid one")
            return
        if ord(c)<ord('a') and ord(c)>ord('Z'):
            print("Invalid argument!!!!!!!!!\nPlease enter valid one")
            return
        plain_text=plain_text+rot13dic[c]

    print(plain_text)
        
def rot5(cyphertext):
    plain_text=''
    for c in cyphertext:
        if ord(c)>ord('9') or ord(c)<ord('0'):
            print("Invalid argument!!!!!!!!!\nPlease enter valid one")
            return
        plain_text=plain_text+rot5dic[c]
    print(plain_text)
def rot47(cyphertext):
    plain_text=''
    for c in cyphertext:
        plain_text=plain_text+rot47dic[c]
    print(plain_text)
def ceaser(cyphertext):
    val="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    
    for i in range(1,53):
        plain_text=''
        for c in cyphertext:
            temp=val.index(c)
            temp=(temp-i)%52
            plain_text=plain_text+val[temp]
        print("+",i," ",plain_text)

if sys.argv[1]=="alpha":
    
    ceaser(sys.argv[2])
    rot13(sys.argv[2])
elif sys.argv[1]=="dec":
    rot5(sys.argv[2])
elif sys.argv[1]=="all":
    rot47(sys.argv[2])
else:
    print("Invalid argument!!!!!!!!!\nPlease enter valid one")
