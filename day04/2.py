import re

input = open('input.txt').read()
pattern = r"(?s).+?\r?\n\r?\n"
matches = re.findall(pattern, input)


def isValidPassport(passport):
    match = re.search(r"\bbyr:(\d{4})\b", passport)
    if not (match and int(match.group(1)) in range(1920, 2003)): return False

    match = re.search(r"\biyr:(\d{4})\b", passport)
    if not (match and int(match.group(1)) in range(2010, 2021)): return False

    match = re.search(r"\beyr:(\d{4})\b", passport)
    if not (match and int(match.group(1)) in range(2020, 2031)): return False

    match = re.search(r"\bhgt:(\d+)(cm|in)\b", passport)
    if not (match and (
            (match.group(2) == "in" and int(match.group(1)) in range(59, 77)) or
            (match.group(2) == "cm" and int(match.group(1)) in range(150, 194))
    )): return False

    if not re.search(r"\bhcl:\#[0-9a-f]{6}\b", passport): return False

    if not re.search(r"\becl:(?:amb|blu|brn|gry|grn|hzl|oth)\b", passport): return False

    if not re.search(r"\bpid:\d{9}\b", passport): return False

    return True


answer = len(list(filter(isValidPassport, matches)))
print(f"Answer is: {answer}")
