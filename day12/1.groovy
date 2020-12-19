def data = new File('./input.txt') as String[]
String[] directions = ["N", "E", "S", "W"]
int[] currentVals = [0 ,0, 1]
data.each {
    String command = (it.chars[0] == "F") ? directions[currentVals[2]] : it.chars[0]
    int amount = it.substring(1,it.size()) as Integer
    if(["R","L"].contains(command)){
        currentVals[2] += amount/90 * (command=="L"?-1:1)
        if(currentVals[2] >= directions.size())
            currentVals[2] -= directions.size()
        if(currentVals[2] < 0)
            currentVals[2] += directions.size()
    } else if(["E","W"].contains(command)){
        currentVals[0] += amount * (command=="W"?-1:1)
    } else if(["N","S"].contains(command)){
        currentVals[1] += amount * (command=="S"?-1:1)
    } 
}
println "Answer is ${Math.abs(currentVals[0]) + Math.abs(currentVals[1])}"