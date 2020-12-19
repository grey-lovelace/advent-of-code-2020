def fileArray = new File('./input.txt') as String[]
def commands = fileArray.collect { 
    [it.substring(0,3), it.substring(4,5), it.substring(5,it.size()) as Integer]}
def acc = 0
def executedIndexes = []
for(int i = 0; i < commands.size(); i++){
    println i
    def command = commands[i]
    if(executedIndexes.contains(i)){
        break;
    } else {
        executedIndexes.add(i)
    }
    if(command[0] == "acc"){
        acc += (command[2] * (command[1] == "-" ? -1 : 1))
    } else if (command[0] == "jmp"){
        i += (command[2] * (command[1] == "-" ? -1 : 1)) -1
    }
}
println "Answer is: ${acc}"
