def data = (new File('./input.txt') as String[]).toList()
def p1 = data[1..(data.indexOf("Player 2:")-2)].collect{it as Integer}
def p2 = data[(data.indexOf("Player 2:")+1)..-1].collect{it as Integer}
println "Answer is ${playGame(p1, p2)[1].reverse().toList().withIndex().collect{it[0]*(1+it[1])}.sum()}"

def playGame(p1, p2){
    def cachedHands = []
    while(!p1.empty && !p2.empty){
        def winLose = [p1,p2]
        if(cachedHands.contains([p1,p2])){
            return [true, p1]
        } else if(p1.size() > p1[0] && p2.size() > p2[0]){
            winLose = (playGame(p1[1..p1[0]],p2[1..p2[0]])[0]) ? winLose : winLose.reverse()
        } else if (p1[0] < p2[0]){
            winLose = winLose.reverse()
        }
        cachedHands << [p1[0..-1],p2[0..-1]]
        winLose[0] << winLose[0][0] << winLose[1][0]
        winLose.each{it.removeAt(0)}
        
    }
    // Return bool for if p1 won, and also winning deck
    return [!p1.empty, (p1.empty) ? p2 : p1]
}

// Not performant, but works correctly