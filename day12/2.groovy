def data = new File('./input.txt') as String[]
int[] shipPos= [0 ,0]
int[] waypointRelativePos = [10 ,1]
data.each {
    String command = it.chars[0]
    int amount = it.substring(1,it.size()) as Integer
    if(["R","L"].contains(command)){
        (1..amount/90).each{
            waypointRelativePos = [waypointRelativePos[1] * (command=="L"?-1:1), waypointRelativePos[0] * (command=="R"?-1:1)]
        }
    } else if(["E","W"].contains(command)){
        waypointRelativePos[0] += amount * (command=="W"?-1:1)
    } else if(["N","S"].contains(command)){
        waypointRelativePos[1] += amount * (command=="S"?-1:1)
    } else if("F" == command){
        shipPos[0] += waypointRelativePos[0]*amount
        shipPos[1] += waypointRelativePos[1]*amount
    }
}
println "Answer is ${Math.abs(shipPos[0]) + Math.abs(shipPos[1])}"