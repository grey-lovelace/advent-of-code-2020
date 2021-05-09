def data = (new File('./input.txt') as String[]).toList()

// Index rules into map with ruleName : allValidNumbers
def rulePattern = /(.*):\s+(\d+)\-(\d+) or (\d+)\-(\d+)/
def ruleRanges = [:]
data[0..(data.indexOf("your ticket:")-2)].each{
    def matcher = it =~ rulePattern
    matcher.find()
    def validNums = (matcher.group(2) as Integer)..(matcher.group(3) as Integer)
    validNums += (matcher.group(4) as Integer)..(matcher.group(5) as Integer)
    ruleRanges[matcher.group(1)] = validNums.unique()
}

// Get my ticket values for later
def myTicket = data[(data.indexOf("your ticket:")+1)].split(",").collect{field -> field as Integer}

// Filter out any invalid tickets
def allValidNums = ruleRanges.values().flatten()
def validTickets = data[(data.indexOf("nearby tickets:")+1)..(data.size()-1)]
        .collect{it.split(",").collect{field -> field as Integer}}
        .findAll{it.every{num -> allValidNums.contains(num)}}

// Make map with ruleName : everyPossibleIndexThatCouldMatch
def matchFieldToIndex = [:]
ruleRanges.keySet().each{matchFieldToIndex[it]=(0..myTicket.size()-1)}
validTickets.each { ticketVals ->
    matchFieldToIndex.each{
        matchFieldToIndex[it.key] = it.value.findAll{
            potentialIndex -> ruleRanges[it.key].contains(ticketVals[potentialIndex])
        }
    }
}

// Iterate through all possible matches left and remove option from other rules when it is locked in.
def finalMatches = [:]
ruleRanges.keySet().each{finalMatches[it]=null}
matchFieldToIndex.entrySet()
    .sort{it.value.size()}
    .each{
        def leftoverIndexes = it.value.findAll{index -> !finalMatches.values().contains(index)}
        if(leftoverIndexes.size() == 1){
            finalMatches[it.key] = leftoverIndexes[0]
        }
    }

// Do final calculations for myTicket and all rules starting with the word "departure"
long answer = 1
finalMatches.entrySet()
        .findAll { it.key.startsWith("departure") }
        .each {answer *= myTicket[it.value]}
println "Answer is ${answer}"