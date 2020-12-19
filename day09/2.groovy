def fileArray = (new File('./input.txt') as String[]).collect{it as BigInteger}
def target = 14360655
fileArray.eachWithIndex{it, i ->
    BigInteger counter = 0
    int i2 = i
    while(counter < target){
        counter += fileArray[i2]
        if(counter == target){
            println "Answer is ${fileArray[i..i2].min() + fileArray[i..i2].max()}"
            System.exit(0)
        } else {
            i2++
        }
    }
}