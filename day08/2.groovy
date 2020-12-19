def fileArray = new File('./input.txt') as String[]
def commands = fileArray.collect { 
    [it.substring(0,3), it.substring(4,5), it.substring(5,it.size()) as Integer]}
commands.eachWithIndex{ it, i ->
    if(["nop","jmp"].contains(it[0])){
        def reachesEnd = doesReachEnd(i)
        if(reachesEnd[0]){
            println "Answer is: ${reachesEnd[1]}"
            System.exit(0)
        }
    }
}

def doesReachEnd(replaceIndex){
    def commands = (new File('../resources/day8.txt') as String[]).collect { 
        [it.substring(0,3), it.substring(4,5), it.substring(5,it.size()) as Integer]}
    def replacedCommand = commands[replaceIndex]
    replacedCommand[0] = replacedCommand[0] == "nop" ? "jmp" : "nop"
    def acc = 0
    def executedIndexes = []
    for(int i = 0; i < commands.size(); i++){
        println i
        def command = commands[i]
        if(executedIndexes.contains(i)){
            return [false, acc]
        } else {
            executedIndexes.add(i)
        }
        if(command[0] == "acc"){
            acc += (command[2] * (command[1] == "-" ? -1 : 1))
        } else if (command[0] == "jmp"){
            i += (command[2] * (command[1] == "-" ? -1 : 1)) -1
        }
    }
    return [true, acc]
}
