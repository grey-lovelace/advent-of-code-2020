String[] data = (new File('./input.txt') as String[])[1].split(",")
int[][] dataWithIndex = data.toList().withIndex().findAll{it[0]!="x"}.collect{[it[0] as Integer,it[1] as Integer]}.sort{-it[0]}
BigInteger[] highPair = dataWithIndex[0]
BigInteger currentTime = 0
dataWithIndex[1..-1].each{
    while(true){
        BigInteger number = currentTime-(highPair[1]-it[1])
        int remainder = number % it[0]
        if(remainder == 0){
            highPair[0] = highPair[0]*it[0]
            break
        }
        currentTime += highPair[0]
    }
}
println "Answer is ${currentTime-highPair[1]}"