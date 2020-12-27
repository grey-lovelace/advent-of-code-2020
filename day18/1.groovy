def data = new File('./input.txt') as String[]
def parenthPattern = /\(([^\(\)]+)\)/
def answerArray = data.collect{
    def expression = it
    def matcher = expression =~ parenthPattern
    while(matcher.find()){
        expression = expression.replaceFirst(parenthPattern, eval(matcher.group(1)))
        matcher = expression =~ parenthPattern
    }
    return eval(expression)
}
println "The answer is ${answerArray.collect{it as BigInteger}.sum()}"

def eval(expression){
    def pattern = /(\d+)\s*([\+\*])\s*(\d+)/
    def matcher = expression =~ pattern
    while(matcher.find()){
        BigInteger first = matcher.group(1) as BigInteger
        BigInteger second = matcher.group(3) as BigInteger
        BigInteger equals = ("+"==matcher.group(2)) ? first + second : first * second
        expression = expression.replaceFirst(pattern, equals.toString())
        matcher = expression =~ pattern
    }
    return expression    
}