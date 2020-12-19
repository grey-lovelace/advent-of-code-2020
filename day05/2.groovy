def fileArray = new File('./input.txt') as String[]
def maxRows = 127
def maxColumns = 7
int[] allSeats = 0..(maxRows * 8) + maxColumns
int[] seatIds = fileArray.collect { line ->
    int[] rows = 0..maxRows
    int[] columns = 0..maxColumns
    line.chars.each {
        switch (it) {
            case 'F':
                rows = rows[0..(rows.size() / 2 - 1)]
                break
            case 'B':
                rows = rows[(rows.size() / 2)..(rows.size() - 1)]
                break
            case 'L':
                columns = columns[0..(columns.size() / 2 - 1)]
                break
            case 'R':
                columns = columns[(columns.size() / 2)..(columns.size() - 1)]
                break
        }
    }
    int seatId = (rows[0] as Integer * 8) + columns[0] as Integer
    return seatId
}.sort()
allSeats = allSeats.findAll {
    return !seatIds.contains(it) && seatIds[0] < it && seatIds.last() > it
}
println "Finished: ${allSeats}"
