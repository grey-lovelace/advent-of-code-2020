def data = (new File('./input.txt') as String[]).toList()
data = data.collect{
    BigDecimal[] position = [0,0]
    for (i=0; i<it.size(); i++) {
        if(["e","w"].contains(it[i])){
            position[0] = position[0] + ("e"==it[i] ? 1 : -1)
        } else if (["n","s"].contains(it[i])){
            position[1] = position[1] + ("n"==it[i] ? 1 : -1)
            i++
            position[0] = position[0] + ("e"==it[i] ? 0.5 : -0.5)
        }
    }
    return position
}
println "Answer is ${data.count{data.count(it)%2 == 1}}"