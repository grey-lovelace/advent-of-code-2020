def fileArray = new File('./input.txt') as String[]
def bagToFind = "shiny gold"
def pattern = /^(.+?) bags contain (.+)$/
BagDef[] bagDefs = fileArray.collect { line ->
    def matcher = line =~ pattern
    matcher.find()
    def bagDef = new BagDef()
    bagDef.bagType = matcher.group(1)
    bagDef.childBagDefs = (matcher.group(2) =~ /(\d+) (.+?) bag/).findAll()
        .collect{ 
            def childBagDef = new ChildBagDef()
            childBagDef.bagType = it[2]
            childBagDef.amount = it[1] as Integer
            return childBagDef
        }
    return bagDef
}
BagDef[] bagOptions = bagsContainingType(bagDefs, bagToFind)
println "Answer is: ${bagOptions*.bagType.unique().size()}"

////////////
public class BagDef{
    String bagType
    ChildBagDef[] childBagDefs
}

public class ChildBagDef {
    String bagType
    int amount
}

BagDef[] bagsContainingType(BagDef[] bagDefs, String bagType){
    BagDef[] bagsWithType = bagDefs.findAll{
        it.childBagDefs.any{it.bagType == bagType}
    }
    BagDef[] parentsOfTheseBags = bagsWithType.collect{
        bagsContainingType(bagDefs, it.bagType)
    }.flatten()
    return bagsWithType + parentsOfTheseBags
}