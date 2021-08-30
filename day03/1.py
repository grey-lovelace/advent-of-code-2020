input = open('input.txt').read().splitlines()
shiftAmount = 3
currentPostion = 0
found = 0
for val in input:
    print(currentPostion)
    if val[currentPostion] == "#": found += 1
    currentPostion += shiftAmount
    if currentPostion >= len(val): currentPostion -= len(val)
print(f"Answer is: {found}")
