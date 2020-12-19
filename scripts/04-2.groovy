def fileString = new File('../resources/day4.txt').text
def pattern = /(?s).+?\r\n\r\n/
String[] validPassports = (fileString =~ pattern).findAll().findAll  { passport ->
    passport = passport.trim()

    def matcher = passport =~ /\bbyr:(\d{4})\b/
    if (!(matcher.find() &&
        (1920..2002).contains(matcher.group(1) as Integer))) {
        return false
    }

    matcher = passport =~ /\biyr:(\d{4})\b/
    if (!(matcher.find() &&
        (2010..2020).contains(matcher.group(1) as Integer))) {
        return false
    }

    matcher = passport =~ /\beyr:(\d{4})\b/
    if (!(matcher.find() &&
        (2020..2030).contains(matcher.group(1) as Integer))) {
        return false
    }

    matcher = passport =~ /\bhgt:(\d+)(cm|in)\b/
    if (!(matcher.find() && (
            (matcher.group(2) == 'in' &&
            (59..76).contains(matcher.group(1)  as Integer))
            ||
            (matcher.group(2) == 'cm' &&
            (150..193).contains(matcher.group(1)  as Integer))
        ))) {
        return false
    }

    matcher = passport =~  /\bhcl:\#[0-9a-f]{6}\b/
    if (!(matcher.find())) {
        return false
    }

    matcher = passport =~  /\becl:(?:amb|blu|brn|gry|grn|hzl|oth)\b/
    if (!(matcher.find())) {
        return false
    }

    matcher = passport =~  /\bpid:\d{9}\b/
    if (!(matcher.find())) {
        return false
    }

    // If it made it here, it deserves it
    return true
}
println "Answer is: ${validPassports.size()}"
