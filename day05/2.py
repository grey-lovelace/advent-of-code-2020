input = open('input.txt').read().splitlines()
maxRows = 127
maxColumns = 7


def determineSeatId(val):
    rows = range(0, maxRows+1)
    columns = range(0, maxColumns+1)
    for c in val:
        if c == "F":
            rows = rows[0:len(rows) // 2]
        elif c == "B":
            rows = rows[len(rows) // 2:len(rows)]
        elif c == "L":
            columns = columns[0:len(columns) // 2]
        elif c == "R":
            columns = columns[len(columns) // 2:len(columns)]
    return (rows[0] * 8) + columns[0]


seatIds = list(map(determineSeatId, input))
seatIds.sort()
allSeats = range(0, (maxRows*8) + maxColumns + 1)
possibleSeats = list(filter(lambda seat: seat not in seatIds and seatIds[0] < seat < seatIds[-1], allSeats))
print(f"Answer is: {possibleSeats[0]}")
