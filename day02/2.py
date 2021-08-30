import re
input = open('input.txt').read().splitlines()
pattern = r"^(\d+)-(\d+) (.): (.+)$"
foundNum = 0
for val in input:
    match = re.search(pattern, val)
    option1 = int(match.group(1))-1
    option2 = int(match.group(2))-1
    letter = match.group(3)
    pw = match.group(4)
    firstChar = pw[option1] #if len(pw) > option1 else None
    secondChar = pw[option2] #if len(pw) > option2 else None
    if firstChar != secondChar and (letter in [firstChar, secondChar]):
        foundNum += 1
print(f"Answer is: {foundNum}")