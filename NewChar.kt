
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main (){
    var thisChar = Character()
    thisChar.name = getName()
    println("Name: ${thisChar.name}")
    thisChar.clan = getClan()
    println("Clan Ring: ${thisChar.clan.clanring}")
    thisChar.family = getClanFamilies(thisChar.clan)
}

fun getName (): String {
    //return random name
    val names : Array<String> = arrayOf("Adachi", "Aika", "Akagi", "Akamatsu", "Akane", "Akari", "Akechi", "Akemi", "Aki", "Akihiko", "Akiko", "Akimoto", "Akinari", "Akira", "Akita", "Akiyama", "Akizuki", "Amago", "Amane", "Amakusa", "Amano", "Amaya", "Anayama", "Andou", "Anenokoji", "Aoi", "Aoki", "Aoyama", "Arai", "Arima", "Asai", "Asakura", "Asano", "Ashikage", "Ashitaka", "Ashina", "Aso", "Asami", "Asukai", "Atagi", "Atsushi", "Aya", "Ayaka", "Ayame", "Ayane", "Ayano", "Azora", "Azuma", "Chieko", "Chiharu", "Chihiro", "Chikusa", "Chiyo", "Daikichi", "Daisetsu", "Daisuke", "Daiyu", "Dairu", "Daiki", "Eiji", "Eisuke", "Emi", "Emiko", "Endou", "Enomoto", "Enya", "Fuji", "Fujii", "Fujinami", "Fujioji", "Fujioka", "Fujita", "Fujitani", "Fujiwara", "Fukui", "Fukuro", "Fumi", "Funabashi", "Furuta", "Futaba", "Genbu", "Genichi", "Gojou", "Gosanke", "Gosankyo", "Gotou", "Hachi", "Hachiro", "Hachisuka", "Haga", "Hagiwara", "Haitaka", "Hajime", "Hakaku", "Hamatsu", "Hamuro", "Hanzo", "Hara", "Harada", "Haruhi", "Haruka", "Haruki", "Haruo", "Haruto", "Hasegawa", "Hashiba", "Hashimoto", "Hatakeyama", "Hatano", "Hatoka", "Hayashi", "Hayato", "Hibi", "Hibiki", "Hideaki", "Higashikaze", "Higashijou", "Hijikata", "Hikari", "Hikaru", "Hiki", "Hineno", "Hino", "Hinoka", "Hina", "Hiraga", "Hirano", "Hirata", "Hiroaki", "Hiroshi", "Hisamatsu", "Hizaya", "Hojo", "Hondou", "Houjou", "Honma", "Honomi", "Hori", "Horio", "Hoshina", "Hosokawa", "Houjou", "Hozumi", "Ichibashi", "Ichijo", "Ichiro", "Ikaru", "Ikeda", "Ikejiri", "Ikoma", "Imagawa", "Imai", "Inaba", "Inagaki", "Inoue", "Irie", "Isamu", "Ise", "Ishibashi", "Ishida", "Ishikawa", "Ishimaki", "Ishino", "Ishiyama", "Ishiki", "Isuka", "Itagaki", "Itakura", "Itami", "Itsuki", "Itsutsuji", "Iwaki", "Iwakura", "Iwamura", "Iwasaki", "Iwashita", "Izara", "Izumi", "Jikouji", "Jimyouin", "Jiro", "Jun", "Junjii", "Junpei", "Kaede", "Kagae", "Kagami", "Kagawa", "Kaharu", "Kajiwara", "Kamei", "Kamizeshi", "Kamome", "Kanamaru", "Kanamori", "Kaneko", "Kanou", "Kaori", "Kaoru", "Kasahashi", "Karasumaru", "Kasumi", "Katakura", "Katano", "Kataoka", "Katashi", "Katou", "Katsuo", "Katsura", "Kawabe", "Kawada", "Kawahire", "Kawakami", "Kawamura", "Kawguchi", "Kazue", "Kazuhiko", "Kazuki", "Kazuya", "Kei", "Keita", "Kenji", "Kenmi", "Kenzo", "Kieko", "Kirina", "Kiji", "Kikawa", "Kiko", "Kikuchi", "Kikyo", "Kimiko", "Kimura", "Kinoshita", "Kira", "Kiro", "Kiso", "Kitabatake", "Kitagaki", "Kitajo", "Kitanokouji", "Kiyoko", "Kiyooka", "Kiyowara", "Kobayakawa", "Kodama", "Koga", "Kohaku", "Koharu", "Koide", "Koji", "Kokoro", "Koma", "Komatsu", "Konishi", "Kono", "Konoe", "Kosuke", "Kotone", "Kou", "Kouno", "Kouriki", "Kuchiki", "Kudo", "Kuina", "Kujaku", "Kujo", "Kiki", "Kumagaya", "Kumo", "Kurina", "Kuroda", "Kuroki", "Kurumi", "Kushizu", "Kusunoki", "Kuzuyama", "Kyo", "Madoka", "Maeda", "Mai", "Makino", "Makoto", "Mana", "Manabe", "Manami", "Mariko", "Maru", "Masahiko", "Mashiro", "Matsuda", "Matsudaira", "Matsui", "Matsukura", "Matsumae", "Matsura", "Matsushita", "Matsuura", "Mayu", "Mayumi", "Mibu", "Michi", "Midori", "Mika", "Mikumo", "Minagawa", "Minamoto", "Minoru", "Mio", "Mirai", "Misago", "Misaki", "Mitsuru", "Miura", "Miyabe", "Miyake", "Miyoshi", "Miyu", "Mizoguchi", "Mizuki", "Mizuno", "Mizutani", "Mogami", "Moro", "Mori", "Morikawa", "Morioka", "Mouri", "Mozuru", "Minakata", "Murakami", "Murata", "Mutatsu", "Nabeshima", "Nagai", "Nagao", "Nagasaki", "Nagatani", "Naitou", "Nakagawa", "Nakajima", "Nakamikado", "Nakamura", "Nakanoin", "Nakatomi", "Nakayama", "Nakazono", "Nanami", "Nao", "Naoha", "Naoki", "Naota", "Naoto", "Naruse", "Nasu", "Natsuki", "Natsumi", "Nawakano", "Nijou", "Nikaidou", "Nikki", "Nishi", "Nishina", "Nishio", "Nishiouji", "Nishisanjou", "Nishitouin", "Nitta", "Niwa", "Nomiya", "Nomura", "Ochi", "Oda", "Ogasawara", "Ogawa", "Ogura", "Okabe", "Okazaki", "Oku", "Okuda", "Okudaira", "Orihime", "Osamu", "Oshinokouji", "Otagi", "Oyama", "Rei", "Reizei", "Reizo", "Renjaku", "Rika", "Rin", "Rokkaku", "Rokujou", "Ruka", "Ryota", "Ryuuzouji", "Saboten", "Saburo", "Saga", "Sagara", "Sagi", "Saigou", "Saionji", "Saito", "Saitou", "Sakai", "Sakakibara", "Sakuma", "Sakura", "Sakurai", "Sanada", "Sanjo", "Sanjou", "Sannosuke", "Sano", "Sanzeni", "Saori", "Sasaki", "Satake", "Satomi", "Satori", "Satoru", "Satou", "Sayuri", "Sazai", "Seiji", "Seikanji", "Seki", "Sen", "Sengoku", "Shiba", "Shibata", "Shibukawa", "Shigahide", "Shigenoi", "Shigeru", "Shiho", "Shijou", "Shimazu", "Shimokoube", "Shinichi", "Shinakawa", "Shinjou", "Shinmen", "Shion", "Shizuru", "Shotaro", "Shoubin", "Shouni", "Shunsuke", "Soejima", "Sonoda", "Sora", "Souma", "Souta", "Suganuma", "Sugawara", "Sugi", "Sugihara", "Sui", "Suiren", "Suisen", "Sumika", "Sumire", "Sumiyo", "Suzaku", "Suzu", "Suzuki", "Suzune", "Tadashi", "Tae", "Taguchi", "Taira", "Taichiro", "Taka", "Takahashi", "Takako", "Takamatsu", "Takanashi", "Takano", "Takaoka", "Takara", "Takatsuji", "Takatsukasa", "Takayama", "Takeda", "Takenaka", "Takeya", "Takigawa", "Takumi", "Takuya", "Tamura", "Tana", "Tanaka", "Tanegashima", "Tani", "Tamotsu", "Tanuma", "Terazawa", "Terukazu", "Toda", "Togawa", "Toki", "Tokudaiji", "Tokugawa", "Tomoe", "Tomomi", "Torayuki", "Torii", "Touji", "Toudou", "Toyoshige", "Tozawa", "Tsorika", "Tsubaki", "Tsubame", "Tsuchimikado", "Tsugaru", "Tsuki", "Tsukika", "Tsukushi", "Tsutsui", "Tsutsuji", "Tsutsuki", "Uesugi", "Ukita", "Umewaka", "Urakami", "Usa", "Usami", "Utsunomiya", "Utushi", "Uzura", "Wada", "Wakiya", "Wakizaka", "Washi", "Watanabe", "Wataru", "Yagyu", "Yamada", "Yamagata", "Yamaguchi", "Yamamoto", "Yamane", "Yamanoi", "Yamanouchi", "Yamaoka", "Yamashina", "Yanagi", "Yanagizawa", "Yashiro", "Yasu", "Yonezu", "Yoriko", "Yoshiaki", "Yoshiharu", "Yoshida", "Yoshi", "Yousuke", "Yuka", "Yukari", "Yuki", "Yukino", "Yuuki", "Yuzuhime", "Zennosuke", "Zetsuha");
    return getRandom(names)
}

fun getClan(): Clan {
    //selects Clan from input
    println ("Enter Clan Name")
    var selectedClan = readLine()

    var thisClan : Clan

    when (selectedClan){
        "Crab" -> thisClan = Clans.Crab
        "Crane" -> thisClan = Clans.Crane

        else -> thisClan = Clans.Crane
    }

    return thisClan
}

fun getClanFamilies(clan: Clan): Family {


}



