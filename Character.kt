class Character {
    var name: String? = null
    var clan: Clan = Clan("String","String",0)
    var family: Family = Family(listOf("String"),listOf("String"),0,0,"String")
    var clanring: String? = null
}

data class Clan (
    val clanring : String? = null,
    val clanskill : String? = null,
    val clanstatus : Int = 0
)

class Clans {
    companion object {
        val Crab = Clan("Earth", "Fitness", 30)
        val Crane = Clan("Air","Culture",35)
    }

}

data class Family(
        val familyrings: List<String>? = (null),
        val familyskills: List<String>? = (null),
        val glory: Int = 0,
        val wealth: Int = 0,
        val clan: String? = null
)

class Families {
    companion object {
        val Hida = Family(listOf("Earth", "Fire"), listOf("Command", "Tactics"), 44, 4, "Crab")
        val Hiruma = Family(listOf("Air", "Water"), listOf("Skulduggery", "Survival"), 39, 3, "Crab")
        val Asahina = Family(listOf("Water", "Void"), listOf("Aesthetics", "Theology"), 40, 6, "Crane")
        val Daidoji = Family(listOf("Earth", "Water"), listOf("Fitness", "Tactics"), 40, 7, "Crane")
    }
}