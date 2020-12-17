def data = new File('../resources/day13.txt') as String[]
def idAndFirstTime = data[1].split(",").findAll{"x"!=it}.collect{
    it = it as Integer
    def remainder = data[0] as Integer % it
    return [it, (remainder > 0) ? (it - remainder) : 0]
}.sort{it[1]}
println "Answer is ${idAndFirstTime[0][0]*idAndFirstTime[0][1]}"