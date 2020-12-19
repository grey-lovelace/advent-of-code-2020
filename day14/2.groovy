def data = new File('./input.txt') as String[]
def memPattern = /mem\[(\d+)\]\s+=\s+(\d+)/
def register = [:]
def masks = []
data.each{
    def matcher = it =~ memPattern
    if(matcher.find()){
        char[] binary =  String.format("%36s",Integer.toBinaryString(matcher.group(1) as Integer)).replaceAll(" ", "0").chars
        masks.each{binary[it[1]] = it[0]}
        recursiveAddToRegister(String.valueOf(binary), matcher.group(2), register)
    } else {
        masks = it.substring(it.size()-36).chars.toList().withIndex().findAll{it[0]!="0"}
    }
}
println "Answer is ${register*.value.sum()}"

def recursiveAddToRegister(binary, value, register){
    [0,1].each{
        def newBinary = binary.replaceFirst("X", it.toString())
        if(newBinary.contains("X")){
            recursiveAddToRegister(newBinary,value,register)
        } else {
            register[Long.parseLong(newBinary, 2)] = value as Long
        }
    }
} 
