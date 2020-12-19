def data = (new File('../resources/day15.txt') as String[])[0].split(",").collect{it as Integer}
(data.size()..2019).each{
    data << Math.max(0,data[0..data.size()-2].reverse().indexOf(data[it-1])+1)
}
println "Answer is ${data.last()}"
