def data = (new File('./input.txt') as String[]).toList()
def p1 = data[1..(data.indexOf("Player 2:")-2)].collect{it as Integer}
def p2 = data[(data.indexOf("Player 2:")+1)..-1].collect{it as Integer}
while(!p1.empty && !p2.empty){
    def winLose = p1[0] > p2[0] ? [p1,p2] : [p2,p1]
    winLose[0] << winLose[0][0] << winLose[1][0]
    winLose.each{it.removeAt(0)}
}
println "Answer is ${(!p1.empty?p1:p2).reverse().withIndex().collect{it[0]*(1+it[1])}.sum()}"