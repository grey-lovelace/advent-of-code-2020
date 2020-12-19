def fileArray = new File('./input.txt') as String[]
def trips = [
    [1, 1],
    [1, 3],
    [1, 5],
    [1, 7],
    [2, 1]
]
int answer = 1
trips.each {
    int down = it[0]
    int over = it[1]
    int currentOverIndex = 0
    int found = 0
    fileArray.eachWithIndex { line, i ->
        if (i % down == 0) {
            if (line.chars[currentOverIndex] == '#') {
                found++
            }
            currentOverIndex += over
            if (currentOverIndex >= line.size()) currentOverIndex -= line.size()
        }
    }
    answer = answer * found
}
println "Answer is: ${answer}"
