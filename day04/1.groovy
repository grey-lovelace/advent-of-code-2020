def fileString = new File('./input.txt').text
def pattern = /(?s).+?\r?\n\r?\n/
def requiredFields = ['byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid']
def validPassports = (fileString =~ pattern).findAll()
    .findAll {
        def passport = it.trim()
        return requiredFields.every { field ->
            return passport =~ /\b$field:[^\s]+\b/
        }
}
println "Answer is: ${validPassports.size()}"
