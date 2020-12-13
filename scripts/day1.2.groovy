def fileArray = new File('../resources/day1.txt') as String[]
fileArray.eachWithIndex { it, i ->
    int currentInt = it as Integer
    fileArray.eachWithIndex { it2, i2 ->
        if (i2 > i) {
            int currentInt2 = it2 as Integer
            fileArray.eachWithIndex { it3, i3 ->
                if (i3 != i && i3 != i2) {
                    int currentInt3 = it3 as Integer
                    if (currentInt + currentInt2 + currentInt3 == 2020) {
                        println "Matching nums are:\n${i} - ${it}\n${i2} - ${it2}\n${i3} - ${it3}"
                        int answer = currentInt * currentInt2 * currentInt3
                        println "Answer is: ${answer}"
                        System.exit(0)
                    }
                }
            }
        }
    }
}
