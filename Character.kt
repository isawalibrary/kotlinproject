class Character {
    var name: String? = null
    var clan: Clan? = null
    var family: Family? = null
    var clanring: String? = null
}

enum class Clan (
        val clanname : String = "",
        val clanring : String = "",
        val clanskill : String = "",
        val clanstatus : Int = 0
) {
        Crab ("Crab","Earth", "Fitness", 30),
        Crane ("Crane","Air","Culture",35)
}

enum class Family(
        val familyname: String = "",
        val familyrings: List<String> = listOf(""),
        val familyskills: List<String> = listOf(""),
        val glory: Int = 0,
        val wealth: Int = 0,
        val clan: String? = ""
){
        Hida ("Hida",listOf("Earth", "Fire"), listOf("Command", "Tactics"), 44, 4, "Crab"),
        Hiruma ("Hiruma",listOf("Air", "Water"), listOf("Skulduggery", "Survival"), 39, 3, "Crab"),
        Asahina ("Asahina",listOf("Water", "Void"), listOf("Aesthetics", "Theology"), 40, 6, "Crane"),
        Daidoji ("Daidoji",listOf("Earth", "Water"), listOf("Fitness", "Tactics"), 40, 7, "Crane")
}

enum class School(
        val schoolname: String = "",
        val family: String = "",
        val clan: String = "",
        val schoolrings: List<String> = listOf(""),
        val schoolskills: List<String> = listOf(""),
        val honor: Int = 0,
        val techniquetypes: List<String> = listOf(""),
        val roles: List<String> = listOf(""),
        val startingtechs: List<String> = listOf(""),
        val startingtechoptions: List<List<String>> = listOf(listOf("")),
        val optionchoices: List<Int> = listOf(0),
        val rank1techs: List<String> = listOf("")
){
    HidaDefender ("Hida Defender","Hida","Crab",listOf("Earth","Water"),
            listOf("Fitness", "Melee", "Ranged", "Unarmed", "Meditation", "Survival", "Tactics"),
            40,listOf("Kata", "Rituals", "Shuji"),listOf("Bushi"),listOf("Lord Hida's Grasp (Crab)"),
            listOf(listOf("Striking as Earth", "Striking as Water")),listOf(1),
            listOf("Rushing Avalanche Style","Honest Assessment")
    )
}

