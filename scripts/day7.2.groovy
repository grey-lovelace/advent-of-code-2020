def fileArray = new File('../resources/day7.txt') as String[]
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
println "Answer is: ${countAllChildren(bagDefs, bagToFind)}"

////////////
public class BagDef{
    String bagType
    ChildBagDef[] childBagDefs
}

public class ChildBagDef {
    String bagType
    int amount
}

long  countAllChildren(BagDef[] bagDefs, String bagType){
    BagDef bagDef = bagDefs.find{
        it.bagType == bagType
    }
    println "${bagDef.bagType} children ${bagDef.childBagDefs.size()}"
    long  childrenOfTheseBags = bagDef.childBagDefs.size() == 0 ? 0 : 
        bagDef.childBagDefs.collect{
            println "${it.bagType} amount ${it.amount}"
            (1 + countAllChildren(bagDefs, it.bagType)) * it.amount 
        }.sum()
    println childrenOfTheseBags
    return childrenOfTheseBags
}