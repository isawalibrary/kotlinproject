class Character {
    var name: String? = null
    var clan: Clan? = null
    var family: Family? = null
    var clanring: String? = null
}

enum class Clan (
        val clanname : String? = null,
        val clanring : String? = null,
        val clanskill : String? = null,
        val clanstatus : Int = 0
) {
        Crab ("Crab","Earth", "Fitness", 30),
        Crane ("Crane","Air","Culture",35)
}

enum class Family(
        val familyrings: List<String>? = (null),
        val familyskills: List<String>? = (null),
        val glory: Int = 0,
        val wealth: Int = 0,
        val clan: String? = null
){
        Hida (listOf("Earth", "Fire"), listOf("Command", "Tactics"), 44, 4, "Crab"),
        Hiruma (listOf("Air", "Water"), listOf("Skulduggery", "Survival"), 39, 3, "Crab"),
        Asahina (listOf("Water", "Void"), listOf("Aesthetics", "Theology"), 40, 6, "Crane"),
        Daidoji (listOf("Earth", "Water"), listOf("Fitness", "Tactics"), 40, 7, "Crane")
}

