input = open('input.txt').read().splitlines()
for i, val in enumerate(input):
    currentInt = int(val)
    for val2 in input[i+1::]:
        currentInt2 = int(val2)
        if currentInt + currentInt2 == 2020:
            answer = currentInt * currentInt2
            print(f'Answer is: {answer}')
            quit()