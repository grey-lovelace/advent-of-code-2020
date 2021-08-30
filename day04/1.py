import re
input = open('input.txt').read()
pattern = r"(?s).+?\r?\n\r?\n"
requiredFields = ['byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid']
matches = re.findall(pattern, input)
def hasField(passport, field): return re.search(r"\b"+field+r":[^\s]+\b" ,passport.strip())
def isValidPassport(passport): return all(hasField(passport, field) for field in requiredFields)
answer = len(list(filter(isValidPassport, matches)))
print (f"Answer is: {answer}")