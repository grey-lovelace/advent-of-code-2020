import re
input = open('input.txt').read()
pattern = r"(?s).+?\r?\n\r?\n"
re.findall(pattern, input)