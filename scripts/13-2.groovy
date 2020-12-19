String[] data = (new File('../resources/day13.txt') as String[])[1].split(",")
int[][] dataWithIndex = data.toList().withIndex().findAll{it[0]!="x"}.collect{[it[0] as Integer,it[1] as Integer]}.sort{-it[0]}
println dataWithIndex
int[] highPair = dataWithIndex[0]
println highPair
BigInteger currentTime = 0
while(true){
    currentTime += highPair[0]
    println "processing ${currentTime}"
    boolean bool = true
    int i = 1
    while(bool){
        if(i == dataWithIndex.size()){
            println "Answer is ${currentTime-highPair[1]}"
            System.exit(0)
        } else {
            BigInteger number = currentTime-(highPair[1]-dataWithIndex[i][1])
            println number
            int remainder = number % dataWithIndex[i][0]
            println remainder
            bool = remainder == 0
            i++
        }
        
    }
}

// Works, but still not performant. No idea how long to run as I keep running OOM