def fileString = new File('../resources/day6.txt').text
def pattern = /(?s).+?\r\n\r\n/
def answers = (fileString =~ pattern).findAll()
    .collect { group ->
        def persons = group.split("\r\n")
        return persons[0].chars.findAll{c -> persons.every{p -> p.chars.contains(c)}}
    }
    
println "Answer is: ${answers*.size().sum()}"
