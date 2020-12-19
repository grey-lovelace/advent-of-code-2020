def fileArray = (new File('./input.txt')) as String[]).collect{it as Integer}
fileArray << 0 << fileArray.max()+3
fileArray = fileArray.sort()
def answer = fileArray.collect{
    if(it > 0){
        return it - fileArray[fileArray.indexOf(it)-1]
    } else { return 0}
}
println "Answer is ${answer.count(1) * answer.count(3)}"