def data = (new File('./input.txt') as String[]).toList()
def rulePattern = /.*?:\s+(\d+)\-(\d+) or (\d+)\-(\d+)/
def validNums = []
data[0..(data.indexOf("your ticket:")-2)].each{
    println it
    def matcher = it =~ rulePattern
    matcher.find()
    validNums += (matcher.group(1) as Integer)..(matcher.group(2) as Integer)
    validNums += (matcher.group(3) as Integer)..(matcher.group(4) as Integer)
    validNums = validNums.unique()
}
def answerArray = data[(data.indexOf("nearby tickets:")+1)..(data.size()-1)].collect{
    it.split(",").collect{field -> field as Integer}.findAll{field -> !validNums.contains(field)}.sum()
}.findAll{it!=null}
println "Answer is ${answerArray.sum()}"
