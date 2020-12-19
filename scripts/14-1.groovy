def data = new File('../resources/day14.txt') as String[]
def memPattern = /mem\[(\d+)\]\s+=\s+(\d+)/
def register = [:]
def masks = []
data.each{
    def matcher = it =~ memPattern
    if(matcher.find()){
        char[] binary =  String.format("%36s",Integer.toBinaryString(matcher.group(2) as Integer)).replaceAll(" ", "0").chars
        masks.each{binary[it[1]] = it[0]}
        register[matcher.group(1)] = Long.parseLong(String.valueOf(binary), 2)
    } else {
        masks = it.substring(it.size()-36).chars.toList().withIndex().findAll{it[0]!="X"}
    }
}
println "Answer is ${register*.value.sum()}"
