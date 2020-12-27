def data = new File('./input.txt').text.split(",").collect{it as Integer}
(data.size()..2019).each{
    data << Math.max(0,data[0..-2].reverse().indexOf(data[it-1])+1)
}
println "Answer is ${data.last()}"
