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
data = data.findAll{data.count(it)%2 == 1}
println data
(1..100).each{day ->
    def maxX = (data.collect{it[0]}.max() + 1).setScale(0, BigDecimal.ROUND_HALF_UP)
    def minX = (data.collect{it[0]}.min() - 1).setScale(0, BigDecimal.ROUND_HALF_DOWN)
    def maxY = data.collect{it[1]}.max() +1
    def minY = data.collect{it[1]}.min() -1
    def newBlackTiles = []
    def indexY = minY
    while(indexY <= maxY){
        //println indexY
        def indexX = minX - (indexY.remainder(2 as BigDecimal)==0 ? 0 : 0.5)
        while(indexX <= maxX){
            def alreadyBlack = data.any{indexX==it[0] && indexY==it[1]}
            def surroundingTiles = data.count{
                (((indexX-1)..(indexX+1)).contains(it[0]) && indexY==it[1])
                ||
                (((indexX-0.5)..(indexX+0.5)).contains(it[0]) && ((indexY-1)..(indexY+1)).contains(it[1]))
            }
            if(surroundingTiles==2 || (alreadyBlack && surroundingTiles == 3)){
                newBlackTiles << [indexX,indexY]
            }
            indexX++
        }
        indexY++
    }
    data = newBlackTiles
    println "Day ${day} - ${data.size()}"
}
println "Answer is ${data.size()}"