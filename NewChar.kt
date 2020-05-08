import kotlin.reflect.full.memberProperties

fun main () {
    var thisChar = Character()
    thisChar.name = getName()
    println("Name: ${thisChar.name}")

    //set Clan, Family and School
    var clanlist: MutableList<String> = getClanList()
    thisChar.clan = getClan()
    var clanname: String = run { thisChar.clan!!.clanname }
    var clanfamilies: MutableList<Family> = getClanFamilies(run { thisChar.clan!!.clanname })
    thisChar.family = getFamily(clanfamilies)
    println("Family selected is " + thisChar.family!!.familyname)
    var clanschools: MutableList<School> = getClanSchools(run { thisChar.clan!!.clanname })
    thisChar.school = getSchool(clanschools)
    println("School selected is " + thisChar.school!!.schoolname)

    //set Rings and Skills
    var clanring: String = thisChar.clan!!.clanring
    println("Clan ring is $clanring")
    thisChar.rings = raiseRing(clanring,thisChar.rings)
    println(thisChar.rings)
    println("School rings are ${thisChar.school!!.schoolrings[0]} and ${thisChar.school!!.schoolrings[1]}")
    var schoolRing1 = thisChar.school!!.schoolrings[0].toString()
    var schoolRing2 = thisChar.school!!.schoolrings[1].toString()
    thisChar.rings = raiseRing(schoolRing1, thisChar.rings)
    thisChar.rings = raiseRing(schoolRing2, thisChar.rings)
    println(thisChar.rings)
    var family: Family = thisChar.family!!
    var familyRing: String = getFamilyRing(family, thisChar.rings)
    thisChar.rings = raiseRing(familyRing, thisChar.rings)
    println(thisChar.rings)
    println("Select one ring to raise")
    var selectedRing = readLine().toString()
    thisChar.rings = raiseRing(selectedRing,thisChar.rings)
    var clanskill = thisChar.clan!!.clanskill
    thisChar.skills = raiseSkill(clanskill,thisChar.skills)
    println(thisChar.skills)
    println("Family skills are ${thisChar.family!!.familyskills[0]} and ${thisChar.family!!.familyskills[1]}")
    for (each in thisChar.family!!.familyskills){
        thisChar.skills = raiseSkill(each, thisChar.skills)
    }
    println(thisChar.skills)
    var skillnumber = thisChar.school!!.skillnumber
    thisChar.skills = selectSchoolSkills(skillnumber,thisChar.school!!.schoolskills, thisChar.skills)
    println(thisChar.skills)

    //set starting Techniques

    //set Honor, Status and Glory
    thisChar.honor = thisChar.school!!.honor
    println("Honor: ${thisChar.honor}")
    thisChar.status = thisChar.clan!!.status
    println("Status: ${thisChar.status}")
    thisChar.glory = thisChar.family!!.glory
    println("Glory: ${thisChar.glory}")

    //Q7
    thisChar = question7(thisChar)
    println("Glory: ${thisChar.glory}")

    //Q8
    thisChar = question8(thisChar)
    println("Honor: ${thisChar.honor}")

    //Advantages and Disadvantages


    //Q17
    thisChar = question17(thisChar)
    println(thisChar.skills)

}

fun getName (): String {
    //return random name
    val names : Array<String> = arrayOf("Adachi", "Aika", "Akagi", "Akamatsu", "Akane", "Akari", "Akechi", "Akemi", "Aki", "Akihiko", "Akiko", "Akimoto", "Akinari", "Akira", "Akita", "Akiyama", "Akizuki", "Amago", "Amane", "Amakusa", "Amano", "Amaya", "Anayama", "Andou", "Anenokoji", "Aoi", "Aoki", "Aoyama", "Arai", "Arima", "Asai", "Asakura", "Asano", "Ashikage", "Ashitaka", "Ashina", "Aso", "Asami", "Asukai", "Atagi", "Atsushi", "Aya", "Ayaka", "Ayame", "Ayane", "Ayano", "Azora", "Azuma", "Chieko", "Chiharu", "Chihiro", "Chikusa", "Chiyo", "Daikichi", "Daisetsu", "Daisuke", "Daiyu", "Dairu", "Daiki", "Eiji", "Eisuke", "Emi", "Emiko", "Endou", "Enomoto", "Enya", "Fuji", "Fujii", "Fujinami", "Fujioji", "Fujioka", "Fujita", "Fujitani", "Fujiwara", "Fukui", "Fukuro", "Fumi", "Funabashi", "Furuta", "Futaba", "Genbu", "Genichi", "Gojou", "Gosanke", "Gosankyo", "Gotou", "Hachi", "Hachiro", "Hachisuka", "Haga", "Hagiwara", "Haitaka", "Hajime", "Hakaku", "Hamatsu", "Hamuro", "Hanzo", "Hara", "Harada", "Haruhi", "Haruka", "Haruki", "Haruo", "Haruto", "Hasegawa", "Hashiba", "Hashimoto", "Hatakeyama", "Hatano", "Hatoka", "Hayashi", "Hayato", "Hibi", "Hibiki", "Hideaki", "Higashikaze", "Higashijou", "Hijikata", "Hikari", "Hikaru", "Hiki", "Hineno", "Hino", "Hinoka", "Hina", "Hiraga", "Hirano", "Hirata", "Hiroaki", "Hiroshi", "Hisamatsu", "Hizaya", "Hojo", "Hondou", "Houjou", "Honma", "Honomi", "Hori", "Horio", "Hoshina", "Hosokawa", "Houjou", "Hozumi", "Ichibashi", "Ichijo", "Ichiro", "Ikaru", "Ikeda", "Ikejiri", "Ikoma", "Imagawa", "Imai", "Inaba", "Inagaki", "Inoue", "Irie", "Isamu", "Ise", "Ishibashi", "Ishida", "Ishikawa", "Ishimaki", "Ishino", "Ishiyama", "Ishiki", "Isuka", "Itagaki", "Itakura", "Itami", "Itsuki", "Itsutsuji", "Iwaki", "Iwakura", "Iwamura", "Iwasaki", "Iwashita", "Izara", "Izumi", "Jikouji", "Jimyouin", "Jiro", "Jun", "Junjii", "Junpei", "Kaede", "Kagae", "Kagami", "Kagawa", "Kaharu", "Kajiwara", "Kamei", "Kamizeshi", "Kamome", "Kanamaru", "Kanamori", "Kaneko", "Kanou", "Kaori", "Kaoru", "Kasahashi", "Karasumaru", "Kasumi", "Katakura", "Katano", "Kataoka", "Katashi", "Katou", "Katsuo", "Katsura", "Kawabe", "Kawada", "Kawahire", "Kawakami", "Kawamura", "Kawguchi", "Kazue", "Kazuhiko", "Kazuki", "Kazuya", "Kei", "Keita", "Kenji", "Kenmi", "Kenzo", "Kieko", "Kirina", "Kiji", "Kikawa", "Kiko", "Kikuchi", "Kikyo", "Kimiko", "Kimura", "Kinoshita", "Kira", "Kiro", "Kiso", "Kitabatake", "Kitagaki", "Kitajo", "Kitanokouji", "Kiyoko", "Kiyooka", "Kiyowara", "Kobayakawa", "Kodama", "Koga", "Kohaku", "Koharu", "Koide", "Koji", "Kokoro", "Koma", "Komatsu", "Konishi", "Kono", "Konoe", "Kosuke", "Kotone", "Kou", "Kouno", "Kouriki", "Kuchiki", "Kudo", "Kuina", "Kujaku", "Kujo", "Kiki", "Kumagaya", "Kumo", "Kurina", "Kuroda", "Kuroki", "Kurumi", "Kushizu", "Kusunoki", "Kuzuyama", "Kyo", "Madoka", "Maeda", "Mai", "Makino", "Makoto", "Mana", "Manabe", "Manami", "Mariko", "Maru", "Masahiko", "Mashiro", "Matsuda", "Matsudaira", "Matsui", "Matsukura", "Matsumae", "Matsura", "Matsushita", "Matsuura", "Mayu", "Mayumi", "Mibu", "Michi", "Midori", "Mika", "Mikumo", "Minagawa", "Minamoto", "Minoru", "Mio", "Mirai", "Misago", "Misaki", "Mitsuru", "Miura", "Miyabe", "Miyake", "Miyoshi", "Miyu", "Mizoguchi", "Mizuki", "Mizuno", "Mizutani", "Mogami", "Moro", "Mori", "Morikawa", "Morioka", "Mouri", "Mozuru", "Minakata", "Murakami", "Murata", "Mutatsu", "Nabeshima", "Nagai", "Nagao", "Nagasaki", "Nagatani", "Naitou", "Nakagawa", "Nakajima", "Nakamikado", "Nakamura", "Nakanoin", "Nakatomi", "Nakayama", "Nakazono", "Nanami", "Nao", "Naoha", "Naoki", "Naota", "Naoto", "Naruse", "Nasu", "Natsuki", "Natsumi", "Nawakano", "Nijou", "Nikaidou", "Nikki", "Nishi", "Nishina", "Nishio", "Nishiouji", "Nishisanjou", "Nishitouin", "Nitta", "Niwa", "Nomiya", "Nomura", "Ochi", "Oda", "Ogasawara", "Ogawa", "Ogura", "Okabe", "Okazaki", "Oku", "Okuda", "Okudaira", "Orihime", "Osamu", "Oshinokouji", "Otagi", "Oyama", "Rei", "Reizei", "Reizo", "Renjaku", "Rika", "Rin", "Rokkaku", "Rokujou", "Ruka", "Ryota", "Ryuuzouji", "Saboten", "Saburo", "Saga", "Sagara", "Sagi", "Saigou", "Saionji", "Saito", "Saitou", "Sakai", "Sakakibara", "Sakuma", "Sakura", "Sakurai", "Sanada", "Sanjo", "Sanjou", "Sannosuke", "Sano", "Sanzeni", "Saori", "Sasaki", "Satake", "Satomi", "Satori", "Satoru", "Satou", "Sayuri", "Sazai", "Seiji", "Seikanji", "Seki", "Sen", "Sengoku", "Shiba", "Shibata", "Shibukawa", "Shigahide", "Shigenoi", "Shigeru", "Shiho", "Shijou", "Shimazu", "Shimokoube", "Shinichi", "Shinakawa", "Shinjou", "Shinmen", "Shion", "Shizuru", "Shotaro", "Shoubin", "Shouni", "Shunsuke", "Soejima", "Sonoda", "Sora", "Souma", "Souta", "Suganuma", "Sugawara", "Sugi", "Sugihara", "Sui", "Suiren", "Suisen", "Sumika", "Sumire", "Sumiyo", "Suzaku", "Suzu", "Suzuki", "Suzune", "Tadashi", "Tae", "Taguchi", "Taira", "Taichiro", "Taka", "Takahashi", "Takako", "Takamatsu", "Takanashi", "Takano", "Takaoka", "Takara", "Takatsuji", "Takatsukasa", "Takayama", "Takeda", "Takenaka", "Takeya", "Takigawa", "Takumi", "Takuya", "Tamura", "Tana", "Tanaka", "Tanegashima", "Tani", "Tamotsu", "Tanuma", "Terazawa", "Terukazu", "Toda", "Togawa", "Toki", "Tokudaiji", "Tokugawa", "Tomoe", "Tomomi", "Torayuki", "Torii", "Touji", "Toudou", "Toyoshige", "Tozawa", "Tsorika", "Tsubaki", "Tsubame", "Tsuchimikado", "Tsugaru", "Tsuki", "Tsukika", "Tsukushi", "Tsutsui", "Tsutsuji", "Tsutsuki", "Uesugi", "Ukita", "Umewaka", "Urakami", "Usa", "Usami", "Utsunomiya", "Utushi", "Uzura", "Wada", "Wakiya", "Wakizaka", "Washi", "Watanabe", "Wataru", "Yagyu", "Yamada", "Yamagata", "Yamaguchi", "Yamamoto", "Yamane", "Yamanoi", "Yamanouchi", "Yamaoka", "Yamashina", "Yanagi", "Yanagizawa", "Yashiro", "Yasu", "Yonezu", "Yoriko", "Yoshiaki", "Yoshiharu", "Yoshida", "Yoshi", "Yousuke", "Yuka", "Yukari", "Yuki", "Yukino", "Yuuki", "Yuzuhime", "Zennosuke", "Zetsuha");
    return getRandom(names)
}

fun getClanList(): MutableList<String> {
    var clanList : MutableList<String> = mutableListOf()
    println("Select clan from: ")

    for (clan in Clan.values() ){
        clanList.add(clan.clanname)
        println(clan.clanname)
    }
    return clanList
}

fun getClan(): Clan {
    //selects Clan from input
    var inputClan = readLine()
    var thisClan : Clan

    when (inputClan){
        "Crab" -> thisClan = Clan.CrabClan
        "Crane" -> thisClan = Clan.CraneClan
        "Dragon" -> thisClan = Clan.DragonClan
        "Lion" -> thisClan = Clan.LionClan
        "Phoenix" -> thisClan = Clan.PhoenixClan
        "Scorpion" -> thisClan = Clan.ScorpionClan
        "Unicorn" -> thisClan = Clan.UnicornClan

        else -> thisClan = Clan.CraneClan
    }
    return thisClan
}

fun getClanFamilies (clan: String): MutableList<Family> {
    var clanFamilies : MutableList<Family> = mutableListOf()

    for (fam in Family.values() ){
        var clan = clan.toString()

        if (fam.clan == clan){
            clanFamilies.add(fam)
        }
    }
    return clanFamilies
}

fun getFamily(clanfamilies: MutableList<Family>) : Family {
    println("Select family from:")
    for (each in clanfamilies){
        println(each.familyname)
    }

    var inputFamily = readLine()
    var selectedFamily : Family = Family.HidaFamily

    for (each in Family.values()) {
        if (each.familyname == inputFamily) {
            selectedFamily = each
        }
    }
    return selectedFamily
}

fun getClanSchools(clan : String) : MutableList<School> {
    var clanSchools : MutableList<School> = mutableListOf()

    for (school in School.values() ){

        var clan = clan.toString()

        if (school.clan == clan){
            clanSchools.add(school)
        }
    }
    return clanSchools
}

fun getSchool(clanschools: MutableList<School>) : School {
    println("Select school from:")

    for (each in clanschools){
        for (school in School.values()) {
            if (school == each) {
                println(school.schoolname)
            }
        }
    }
    var inputSchool = readLine()
    var selectedSchool : School = School.HidaDefender

    for (each in School.values()) {
        if (each.schoolname == inputSchool) {
            selectedSchool = each
        }
    }
    return selectedSchool
}

fun raiseRing (ring: String, ringset: MutableMap<String, Int>) : MutableMap<String, Int> {
    for (each :MutableMap.MutableEntry<String, Int> in ringset){
        if (ring == each.key){
            each.setValue(each.value+1)
        }
    }
    return ringset
}

fun getFamilyRing (family: Family, ringset: MutableMap<String, Int>) : String {
    println("Family rings are:")

    for (familyring in family.familyrings){
        for (ring in ringset){
            if (ring.key == familyring && ring.value > 2){
                println("${ring.key} is already at 3")
            }
            else if (ring.key == familyring && ring.value <= 2){
                println("${ring.key} can be raised")
            }
        }
    }

    println("Select family ring")
    var selectedRing : String = readLine().toString()

    return selectedRing
}

fun raiseSkill (skill: String, skillset: MutableMap<String, Int>) : MutableMap<String, Int> {
    for (each in skillset){
        if (each.key == skill){
            each.setValue(each.value+1)
        }
    }
    return skillset
}

fun selectSchoolSkills (skillnumber: Int, schoolskills: List<String>, skillset: MutableMap<String, Int>) : MutableMap<String, Int> {
    println("Select $skillnumber skills from:")
    for (each in schoolskills) {
        println(each)
    }

    var raisedskillset = skillset

    for (i in 1..skillnumber){
        println("Select school skill #$i")
        var selectedSkill = readLine().toString()
        raisedskillset = raiseSkill(selectedSkill, raisedskillset)
    }

    return raisedskillset
}

fun question7 (character: Character) : Character {
    println("Q7 What is your character's relationship with their clan?")
    println("a) If your character believes firmly in the precepts of their clan and the values it holds dear,\n" +
            "gain +5 glory based on their reputation as an upstanding member of their community.")
    println("b) If your character has a fundamental disagreement with their clan’s beliefs, policies, or practices\n" +
            "and has defied these in the past, gain a rank in a skill in which you have 0 ranks. Consider\n" +
            "why this skill represents a divergence from the clan’s training or values.")
    println("Select a or b")

    var selection = readLine().toString()

    if (selection == "a"){
        character.glory = character.glory + 5
    } else if (selection == "b"){
        println("Select a skill from skills at zero to gain a rank in.")
        for (each in character.skills){
            if (each.value == 0){
                println(each.key)
            }
        }
        selection = readLine().toString()

        character.skills = raiseSkill(selection,character.skills)
        println(character.skills)
    }
    return character
}

fun question8 (character: Character) :Character {
    println("Q7 What does your character think of Bushido?")
    println("a) If your character’s belief in living by an orthodox interpretation of Bushidō is very staunch,\n" +
            "gain +10 honor.")
    println("b) If your character diverges from some or all common beliefs about how samurai should\n" +
            "behave honorably, gain 1 rank in one of the following skills to reflect past behavior that was\n" +
            "unbefitting of a samurai or deeply defied the norm: Commerce, Labor, Medicine, Seafaring,\n" +
            "Skulduggery, or Survival.")
    println("Select a or b")

    var selection = readLine().toString()

    if (selection == "a"){
        character.honor = character.honor + 10
    } else if (selection == "b"){
        println("Select a skill from the following list to gain a rank in.")

        var list = listOf<String>("Commerce", "Labor", "Medicine", "Seafaring", "Skulduggery", "Survival")
        for (each in list){
            println(each)
        }
        selection = readLine().toString()

        character.skills = raiseSkill(selection,character.skills)
        println(character.skills)
    }
    return character
}

fun question17 (character: Character) : Character {
    println("Q17 How would your character's family members describe them?")
    println("Gain a rank in a skill in which you have 0 ranks.")
    for (each in character.skills){
        if (each.value == 0){
            println(each.key)
        }
    }
    var selectedSkill = readLine().toString()

    character.skills = raiseSkill(selectedSkill, character.skills)
    return character
}