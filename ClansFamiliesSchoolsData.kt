class Character {
    var name: String = ""
    var clan: Clan? = null
    var family: Family? = null
    var school: School? = null
}

enum class Clan (
        val clanname : String = "",
        val clanring : String = "",
        val clanskill : String = "",
        val status : Int = 0
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
    HidaDefender ("Hida Defender", "Hida", "Crab", listOf("Earth","Water"), listOf("Fitness", "Melee", "Ranged", "Unarmed", "Meditation", "Survival", "Tactics"), 40, listOf("Kata", "Rituals", "Shuji"), listOf("Bushi"), listOf("Lord Hida's Grasp (Crab)"), listOf(listOf("Striking as Earth", "Striking as Water")), listOf(1) ),
    HirumaScout ("Hiruma Scout", "Hiruma", "Crab", listOf("Air","Water"), listOf("Fitness", "Melee", "Ranged", "Skulduggery", "Survival", "Tactics", "Theology"), 35, listOf("Kata", "Rituals", "Shuji"), listOf("Bushi", "Shinobi"), listOf(), listOf(listOf("Pelting Hail Style", "Rushing Avalanche Style"), listOf("Striking as Air", "Striking as Water")), listOf(1, 1) ),
    KaiuEngineer ("Kaiu Engineer", "Kaiu", "Crab", listOf("Earth","Fire"), listOf("Command", "Design", "Labor", "Ranged", "Medicine", "Smithing", "Theology"), 40, listOf("Kata", "Rituals", "Shuji"), listOf("Bushi", "Artisan"), listOf("Tactical Assessment", "Stirring the Embers", "Stonewall Tactics"), listOf(), listOf(0) ),
    KuniPurifier ("Kuni Purifier", "Kuni", "Crab", listOf("Earth","Fire"), listOf("Melee", "Medicine", "Sentiment", "Skulduggery", "Survival", "Theology"), 40, listOf("Invocations", "Kata", "Rituals"), listOf("Shugenja", "Bushi"), listOf("Armor of Earth", "Jade Strike", "Commune with the Spirits", "Threshold Barrier"), listOf(listOf("Striking as Earth", "Striking as Fire")), listOf(1) ),
    YasukiMerchant ("Yasuki Merchant", "Yasuki", "Crab", listOf("Air","Earth"), listOf("Commerce", "Composition", "Courtesy", "Culture", "Design", "Government", "Ranged"), 40, listOf("Kata", "Rituals", "Shuji"), listOf("Courtier"), listOf("Artisan's Appraisal"), listOf(listOf("Rustling of Leaves", "Well of Desire")), listOf(1) ),
    KuniWarden ("Kuni Warden", "Kuni", "Crab", listOf("Void","Fire"), listOf("Command", "Melee", "Unarmed", "Meditation", "Performance", "Theology"), 34, listOf("Shuji", "Rituals", "Kiho"), listOf("Monk"), listOf("Truth Burns Through Lies"), listOf(listOf("Cleansing Spirit", "Flame Fist"), listOf("Cleansing Rite", "Threshold Barrier")), listOf(1, 1) ),
    YasukiYojimbo ("Yasuki Yojimbo", "Yasuki", "Crab", listOf("Earth","Water"), listOf("Melee", "Ranged", "Tactics", "Commerce", "Courtesy", "Seafaring", "Survival"), 50, listOf("Shuji", "Rituals", "Kata"), listOf("Bushi"), listOf("Crescent Moon Style"), listOf(listOf("Honest Assessment", "Well of Desire")), listOf(1) ),

    AsahinaArtificer ("Asahina Artificer", "Asahina", "Crane", listOf("Air","Fire"), listOf("Aesthetics", "Courtesy", "Culture", "Design", "Games", "Theology"), 50, listOf("Invocations", "Rituals", "Shuji"), listOf("Shugenja", "Artisan"), listOf("Commune with the Spirits", "Cleansing Rite"), listOf(listOf("Blessed Wind", "Armor of Radience", "Inari's Blessing", "Reflections of P'an Ku", "Token of Memory")), listOf(3) ),
    DaidojiIronWarrior ("Daidoji Iron Warrior", "Daidoji", "Crane", listOf("Earth","Water"), listOf("Command", "Courtesy", "Culture", "Fitness", "Government", "Melee", "Tactics"), 55, listOf("Kata", "Rituals", "Shuji"), listOf("Bushi"), listOf("Iron Forest Style"), listOf(listOf("Striking as Earth", "Striking as Water")), listOf(1) ),
    DojiDiplomat ("Doji Diplomat", "Doji", "Crane", listOf("Air","Water"), listOf("Aesthetics", "Composition", "Courtesy", "Culture", "Design", "Government", "Ranged"), 50, listOf("Kata", "Rituals", "Shuji"), listOf("Courtier"), listOf("Lady Doji's Decree (Crane)"), listOf(listOf("Cadence", "Shallow Waters", "Whispers of Court")), listOf(1)),
    KakitaDuelist ("Kakita Duelist", "Kakita", "Crane", listOf("Air","Earth"), listOf("Courtesy", "Design", "Fitness", "Melee", "Meditation", "Sentiment", "Smithing"), 50, listOf("Kata", "Rituals", "Shuji"), listOf("Bushi", "Artisan"), listOf("Iaijutsu Cut: Rising Blade"), listOf(listOf("Shallow Waters", "Weight of Duty")), listOf(1) ),
    KakitaSwordsmith ("Kakita Swordsmith", "Kakita", "Crane", listOf("Air","Fire"), listOf("Aesthetics", "Melee", "Courtesy", "Culture", "Sentiment", "Smithing", "Theology"), 55, listOf("Kata", "Rituals", "Shuji"), listOf("Artisan", "Courtier"), listOf("Artisan's Appraisal"), listOf(listOf("Soaring Slice", "Striking as Air", "Striking as Fire")), listOf(1) ),
    DaidojiSpymaster ("Daidoji Spymaster", "Daidoji", "Crane", listOf("Air","Earth"), listOf("Command", "Courtesy", "Culture", "Government", "Performance", "Sentiment", "Skulduggery"), 35, listOf("Kata", "Rituals", "Shuji"), listOf("Courtier", "Shinobi"), listOf("Ancestry Unearthed"), listOf(listOf("Like a Ghost", "Skulk"), listOf("Striking as Air", "Striking as Earth")), listOf(1, 1) ),
    DojiBureaucrat ("Doji Bureaucrat", "Doji", "Crane", listOf("Earth","Water"), listOf("Command", "Composition", "Courtesy", "Culture", "Games", "Government", "Meditation"), 55, listOf("Rituals", "Shuji"), listOf("Courtier"), listOf("Courtier's Resolve", "Stonewall Tactics"), listOf(), listOf(0) )
}
