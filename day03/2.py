
import math
input = open('input.txt').read().splitlines()
trips = [
    [1, 1],
    [1, 3],
    [1, 5],
    [1, 7],
    [2, 1]
]
def doTrip(trip):
    [down, over] = trip
    currentPostion = 0
    found = 0
    for val in input[::down]:
        if val[currentPostion] == "#": found += 1
        currentPostion += over
        if currentPostion >= len(val): currentPostion -= len(val)
    return found
print(f"Answer is: {math.prod(list(map(doTrip, trips)))}")
