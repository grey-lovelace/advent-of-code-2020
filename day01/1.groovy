def fileArray = new File('./input.txt') as String[]
fileArray.eachWithIndex { it, i ->
    int currentInt = it as Integer
    fileArray.eachWithIndex { it2, i2 ->
        if (i2 > i) {
            int currentInt2 = it2 as Integer
            if (currentInt + currentInt2 == 2020) {
                int answer = currentInt * currentInt2
                println "Answer is: ${answer}"
            }
        }
    }
}
