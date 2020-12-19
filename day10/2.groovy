def fileArray = (new File('./input.txt')) as String[]).collect{it as Integer}
fileArray << 0 << fileArray.max()+3
fileArray = fileArray.sort()
def cache = [:]
// Get a list of the number of options available for each step in our array
def optionsArray = fileArray.collect{fileArray.count{x -> (1..3).contains(x - it)}}
// Run the array backwards to build up our cache
((optionsArray.size()-1)..0).each{countRecursive(it, optionsArray, cache)}
println "Answer is: ${1 + countRecursive(0, optionsArray, cache)}"

def countRecursive(startingIndex, optionsArray, cache){
    if(cache[startingIndex] == null){
        BigInteger addedSpawns = 0
        optionsArray[startingIndex..optionsArray.size()-1].eachWithIndex{ numOfOptions, index ->
            if(numOfOptions > 1){
                (2..numOfOptions).each{optionNumber ->
                    addedSpawns += 1 + countRecursive(startingIndex + index + optionNumber, optionsArray, cache)
                }
            }
        }
        cache[startingIndex] = addedSpawns
    }
    return cache[startingIndex]
}
