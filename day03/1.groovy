def fileArray = new File('./input.txt') as String[]
int over = 3
int currentOverIndex = 0
int found = 0
fileArray.eachWithIndex { it, i ->
    if (it.chars[currentOverIndex] == '#') {
        found++
    }
    currentOverIndex += over
    if (currentOverIndex >= it.size()) currentOverIndex -= it.size()
}
println "Finished: ${found}"
