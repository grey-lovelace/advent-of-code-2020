def fileArray = (new File('../resources/day10.txt') as String[]).collect{it as Integer}
fileArray << 0 << fileArray.max()+3
fileArray = fileArray.sort()
def optionsArray = fileArray.collect{
    fileArray.count{x -> (1..3).contains(x - it)} 
}
println "Answer is: ${1 + countRecursive(0, optionsArray)}"

def countRecursive(startingIndex, optionsArray){
    addedSpawns = 0
    optionsArray[startingIndex..optionsArray.size()-1].eachWithIndex{ numOfOptions, index ->
        if(numOfOptions > 1){
            (2..numOfOptions).each{optionNumber ->
                addedSpawns += 1 + countRecursive(startingIndex + index + optionNumber, optionsArray)
            }
        }
    }
    return addedSpawns
}
