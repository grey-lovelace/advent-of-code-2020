def data = new File('./input.txt').text.split(",").collect{it as Integer}
def cache = [int:int]
data.eachWithIndex{it, i -> cache[it] = i}
def currentNum = 0
def lastNum = data.last()
cache.remove(lastNum)
int index = data.size()
while (index < 30000000) {
    // Dont print anything in here unless you want this to take over an hour
    currentNum = cache.containsKey(lastNum) ? index-cache[lastNum]-1 : 0
    cache[lastNum] = index-1
    lastNum = currentNum
    index++
}
println "Answer is ${currentNum}"