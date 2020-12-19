def data = new File('./input.txt').text.split(",").collect{it as Integer}
def cache = [:]
data.eachWithIndex{it, i -> cache[it] = i}
def currentNum = 0
def lastNum = data.last()
cache.remove(lastNum)
(data.size()..29999999).each{
    currentNum = cache.containsKey(lastNum) ? it-cache[lastNum]-1 : 0
    println "$it - $currentNum"
    cache[lastNum] = it-1
    lastNum = currentNum
}
println "Answer is ${currentNum}"

// Works, but still not performant. Should take about 2 hours to run.