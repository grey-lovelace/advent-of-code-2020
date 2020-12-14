String[][] data = (new File('../resources/day11.txt') as String[]).collect{it.chars}
def rowIndex = 0
def changed = [false, data]
do {
    changed = processChanges(changed[1])
} while (!changed[0])
println "Answer is ${changed[1].collect{it.count("#")}.sum()}"

def processChanges(data){
    def rowIndex = 0
    def changed = data.collect{row ->
        def itemIndex = 0
        def newRow = row.collect{item ->
            def surroundingSeats = getSurroundingSeats(rowIndex, itemIndex, data)
            itemIndex++
            if(item == "L" && surroundingSeats.collect{it.count("#")}.sum() == 0) {
                return "#"
            } else if(item == "#" && surroundingSeats.collect{it.count("#")}.sum() >= 4){
                return "L"
            } else {
                return item
            }
        }
        rowIndex++
        return newRow
    }
    return [data == changed, changed]
}

def getSurroundingSeats(rowIndex, itemIndex, data){
    return (Math.max(0, rowIndex-1)..Math.min(data.size()-1, rowIndex+1)).collect{sr ->
        return (Math.max(0, itemIndex-1)..Math.min(data[rowIndex].size()-1, itemIndex+1)).collect{sc ->
            if(sr==rowIndex && sc==itemIndex) {
                return "X"
            } else {
                return data[sr][sc]
            }
        }
    }
}