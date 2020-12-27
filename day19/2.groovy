def data = (new File('./input2.txt') as String[]).toList()
def rules = data[0..(data.indexOf("")-1)]
    .collectEntries{
        [it.substring(0,it.indexOf(":")), 
        it.substring(it.indexOf(":")+2,it.size()).split(" ")]
    }

def loopOverride = [:]
def regex = /^${buildRegex("0",rules,loopOverride)}$/
def numOfMatches = 0
def timesMatched = 0
// Loop until number stabilizes around 4 times in a row. Replace the REPLACE strings with a copy of the rule to make more restrictive each time.
while(timesMatched < 4){
    loopOverride.each{
        regex = regex.replaceAll(/\~REPLACE${it.key}\~\.\*/, it.value)
    }
    def newNumOfMatches = data[(data.indexOf("")+1)..-1].count{it.matches(regex.replaceAll(/\~REPLACE(\d+)\~/, ""))}
    if(newNumOfMatches == numOfMatches){
        timesMatched++
    } else {
        numOfMatches = newNumOfMatches
        timesMatched = 0
    }
}
println "Answer is $numOfMatches"

def buildRegex(ruleNum, rules, loopOverride){
    def regex = ""
    rules[ruleNum].each{
        if("|" == it || it.startsWith("\"")){
            regex += it.replaceAll("\"","")
        } else if (ruleNum == it){
            regex += "~REPLACE$ruleNum~.*"
        } else {
            regex += buildRegex(it, rules, loopOverride)
        }
    }
    regex = rules[ruleNum].contains("|") ? "(?:$regex)" : regex
    if(regex.contains("REPLACE")){
        loopOverride[ruleNum] = regex
    }
    return regex
}