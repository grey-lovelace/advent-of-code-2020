def fileArray = new File('../resources/day3.txt') as String[]
int over = 3
int currentOverIndex = 0
int found = 0
fileArray.eachWithIndex { it, i ->
    if (it.chars[currentOverIndex] == '#') {
        println "hit tree on line ${i} overIndex ${currentOverIndex}\n${it}"
        found++
    }
    currentOverIndex += over
    if (currentOverIndex >= it.size()) currentOverIndex -= it.size()
}
println "Finished: ${found}"
