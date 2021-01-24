def data = new File('./input.txt').text.collect{it as Integer}.toList()
data += (data.max()..1000000)
def current = data[0]
(0..99).each{
    println it
    //println data
    //println current
    def currentIndex = data.indexOf(current)
    def range = [currentIndex+1,currentIndex+3].collect{it >= data.size() ? it - data.size() : it}
    def subset = range[0]<range[1] ? data[range[0]..range[1]] : data[range[0]..-1] + data[0..range[1]]
    //println subset
    data -= subset
    def dest = current-1
    while(!data.contains(dest)){
        dest = dest == 0 ? data.max() : dest-1
    }
    data.addAll(data.indexOf(dest)+1, subset)
    current = current == data[-1] ? data[0] : data[currentIndex+1]
}
def range = [data.indexOf(current)+1,data.indexOf(current)+2].collect{it >= data.size() ? it - data.size() : it}
def subset = range[0]<range[1] ? data[range[0]..range[1]] : data[range[0]..-1] + data[0..range[1]]
println "Answer is ${range}"