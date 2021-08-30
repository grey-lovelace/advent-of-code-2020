import re
input = open('input.txt').read().splitlines()
pattern = r"^(\d+)-(\d+) (.): (.+)$"
foundNum = 0
for val in input:
    match = re.search(pattern, val)
    min = int(match.group(1))
    max = int(match.group(2))
    letter = match.group(3)
    pw = match.group(4)
    count = pw.count(letter)
    if count >= min and count <= max:
        foundNum += 1
print(f"Answer is: {foundNum}")