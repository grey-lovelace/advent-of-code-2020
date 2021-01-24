def data = (new File('./input.txt') as String[]).collect{it as BigInteger}
BigInteger subject = 7
BigInteger divValue = 20201227
BigInteger value = 1
BigInteger loopsize = 0
while(!data.contains(value)){
    loopsize++
    value = (value*subject).remainder(divValue)
    println "Loop1: ${loopsize}, $value"
}
data.remove(value)
subject = data[0]
value = 1
(1..loopsize).each{
    value = (value*subject).remainder(divValue)
    println "Loop2: ${it}, $value"
}
println "Answer is ${value}" 

// Runs for over an hour, but works.