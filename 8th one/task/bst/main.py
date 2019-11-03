import tree
import exeption


def test_map(m):
    try:
        m.insert(5, "fimma")
    except exeption.ItemExistsException:
        print("Item already exists")
    try:
        m.insert(4, "fjarri")
    except exeption.ItemExistsException:
        print("Item already exists")
    try:
        m.insert(2, "tvistur")
    except exeption.ItemExistsException:
        print("Item already exists")
    try:
        m.insert(5, "fimmarimma")
    except exeption.ItemExistsException:
        print("Item already exists")
    m[1] = "ás"

    try:
        m.update(4, "fjarkalarki")
    except exeption.NotFoundException:
        print("Item not found")
    try:
        m.update(6, "sexxxxxa")
    except exeption.NotFoundException:
        print("Item not found")

    m[6] = "sexa"

    print("size of map: " + str(len(m)))
    print(m.contains(12))
    m[12] = "drottning"
    print(m.contains(12))

    print("size of map: " + str(len(m)))
    try:
        print(m.find(4))
    except exeption.NotFoundException:
        print("Item not found")
    try:
        print(m[2])
    except exeption.NotFoundException:
        print("Item not found")
    try:
        print(m[1])
    except exeption.NotFoundException:
        print("Item not found")
    try:
        print(m[5])
    except exeption.NotFoundException:
        print("Item not found")
    try:
        print(m.find(6))
    except exeption.NotFoundException:
        print("Item not found")
    try:
        print(m[7])
    except exeption.NotFoundException:
        print("Item not found")

    print("size of map: " + str(len(m)))
    try:
        m.remove(5)
        print("Item removed")
    except exeption.NotFoundException:
        print("Item not found")
    try:
        print(m.find(5))
    except exeption.NotFoundException:
        print("Item not found")
        
    print("size of map: " + str(len(m)))

    print(m)
    
    try:
        m.insert(12, "drolla")
    except exeption.ItemExistsException:
        print("Item already exists")
    print(m)

    try:
        m.insert(6, "sixxer")
    except exeption.ItemExistsException:
        print("Item already exists")
    print(m)

    try:
        m.insert(9, "nía")
    except exeption.ItemExistsException:
        print("Item already exists")
    print(m)


if __name__ == "__main__":
    print("\nTESTING BSTMAP")
    m = tree.BSTMap()
    test_map(m)
    