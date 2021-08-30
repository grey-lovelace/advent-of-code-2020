def fileArray = new File('./input.txt') as String[]
def pattern = /(\d+)-(\d+) (.): (.+)/
int found = 0
fileArray.each {
    def matcher = it =~ pattern
    matcher.find()
    int lowInt = matcher.group(1) as Integer
    int highInt = matcher.group(2) as Integer
    def matchLetter = matcher.group(3)
    def password = matcher.group(4)
    int count = password.chars().filter(ch -> ch == matchLetter).count()
    if (lowInt <= count && count <= highInt) {
        found++
    }
}
println "Finished: ${found}"
