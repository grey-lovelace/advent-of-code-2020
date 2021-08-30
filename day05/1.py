input = open('input.txt').read().splitlines()


def determineSeatId(val):
    rows = range(0, 128)
    columns = range(0, 8)
    for c in val:
        if c == "F":
            rows = rows[0:len(rows) // 2:]
        elif c == "B":
            rows = rows[len(rows) // 2:len(rows):]
        elif c == "L":
            columns = columns[0:len(columns) // 2:]
        elif c == "R":
            columns = columns[len(columns) // 2:len(columns):]
    return (rows[0] * 8) + columns[0]


seatIds = list(map(determineSeatId, input))
seatIds.sort()
print(f"Answer is: {seatIds[-1]}")
