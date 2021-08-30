input = open('input.txt').read().splitlines()
for i, val in enumerate(input):
    currentInt = int(val)
    for i2, val2 in enumerate(input[i+1::]):
        currentInt2 = int(val2)
        for val3 in input[i+1+i2::]:
            currentInt3 = int(val3)
            if currentInt + currentInt2 + currentInt3 == 2020:
                answer = currentInt * currentInt2 * currentInt3
                print(f'Answer is: {answer}')
                quit()