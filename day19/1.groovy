def data = (new File('./input.txt') as String[]).toList()
def rules = data[0..(data.indexOf("")-1)]
    .collectEntries{
        [it.substring(0,it.indexOf(":")), 
        it.substring(it.indexOf(":")+2,it.size()).split(" ")]
    }
def regex = /^${buildRegex("0",rules)}$/
println regex
println "Answer is ${data[(data.indexOf("")+1)..-1].count{it.matches(regex)}}"

def buildRegex(ruleNum, rules){
    def regex = ""
    rules[ruleNum].each{
        if("|" == it || it.startsWith("\"")){
            regex += it.replaceAll("\"","")
        } else {
            regex += buildRegex(it, rules)
        }
    }
    return rules[ruleNum].contains("|") ? "(?:$regex)" : regex
}