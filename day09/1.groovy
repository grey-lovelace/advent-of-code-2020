def fileArray = (new File('./input.txt') as String[]).collect{it as BigInteger}
fileArray.eachWithIndex{it, i ->
    if(i > 25){
        def last25 = fileArray[(i-26)..(i-1)]
        println last25
        def isValid = last25.any{ x ->
            def last25NoX = last25.collect()
            last25NoX.removeElement(x)
            return last25NoX.contains(it - x)
        }
        if(!isValid){
            println "Answer is $it"
            System.exit(0)
        }
    }
}