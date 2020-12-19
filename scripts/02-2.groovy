def fileArray = new File('../resources/day2.txt') as String[]
def pattern = /(\d+)-(\d+) (.): (.+)/
int found = 0
fileArray.each {
    def matcher = it =~ pattern
    matcher.find()
    int firstInt = matcher.group(1) as Integer
    int secondInt = matcher.group(2) as Integer
    def matchLetter = matcher.group(3)
    def password = matcher.group(4)
    def firstChar = (password.size() >= firstInt) ? password.chars[firstInt - 1] : null
    def secondChar = (password.size() >= secondInt) ? password.chars[secondInt - 1] : null
    if ((matchLetter == firstChar || matchLetter == secondChar ) && firstChar != secondChar) {
        println it
        found++
    }
}
println "Finished: ${found}"
