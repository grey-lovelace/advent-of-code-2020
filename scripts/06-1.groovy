def fileString = new File('../resources/day6.txt').text
def pattern = /(?s).+?\r\n\r\n/
def answers = (fileString =~ pattern).findAll()
    .collect { group ->
        return group.chars
            .findAll{it.isLetter()}
            .unique()
        }
    
println "Answer is: ${answers*.size().sum()}"
