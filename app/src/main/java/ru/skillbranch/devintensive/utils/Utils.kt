package ru.skillbranch.devintensive.utils

object Utils{
    fun parseFullName(fullName:String?) : Pair<String?,String?>{
        val parts : List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)

        val lastName = parts?.getOrNull(1)

        if (firstName == "" && lastName == "") return null to null
        else if (firstName == "") return null to lastName
        else if (lastName == "") return firstName to null
        else return firstName to lastName
    }

    fun transliteration(payLoad: String, divider : String = " "): String {
       val answ = payLoad.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюя ]")) {
            when (it.value) {
                "а"-> "a"
                "б"-> "b"
                "в"-> "v"
                "г"->"g"
                "д"-> "d"
                "е"-> "e"
                "ё"-> "e"
                "ж"-> "zh"
                "з"-> "z"
                "и"-> "i"
                "й"-> "i"
                "к"-> "k"
                "л"-> "l"
                "м"-> "m"
                "н"-> "n"
                "о"-> "o"
                "п"-> "p"
                "р"-> "r"
                "с"-> "s"
                "т"-> "t"
                "у"-> "u"
                "ф"-> "f"
                "х"-> "h"
                "ц"-> "c"
                "ч"-> "ch"
                "ш"-> "sh"
                "щ"-> "sh'"
                "ъ"-> ""
                "ы"-> "i"
                "ь"-> ""
                "э"-> "e"
                "ю"-> "yu"
                "я"-> "ya"
                " "-> divider
                else -> it.value
        }
    }
        return answ
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val l1 = if(firstName?.length != 0)firstName?.get(0)?.toUpperCase() else null
        val l2 = if(lastName?.length != 0)lastName?.get(0)?.toUpperCase() else null
        if (firstName.isNullOrBlank() && lastName.isNullOrBlank()) return null
        else if (l1 == null && l2 != null) return l2.toString()
        else if (l1 != null && l2 == null) return l1.toString()
        else return l1.toString()+l2.toString()



    }
}