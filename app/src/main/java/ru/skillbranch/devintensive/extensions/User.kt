package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView() :UserView{

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Еще ни разу не был" else if(isOnline)"online" else lastVisit.humanizeDiff()
    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status
        )
}
fun Date.humanizeDiff(date:Date = Date()): String {
    val dif :String
    val timeDif =  date.time - this.time

    if (timeDif <= 1 * SECOND && timeDif>= 0 * SECOND)  dif = "только что"
    else if (timeDif<= 45* SECOND && timeDif> 1* SECOND) dif = "несколько секунд назад"
    else if (timeDif<= 75* SECOND && timeDif> 45* SECOND) dif = "минуту назад"
    else if (timeDif<= 2700* SECOND && timeDif> 75* SECOND) dif = "${timeDif / MINUTE} минут назад"
    else if (timeDif<= 75* MINUTE && timeDif> 45* MINUTE) dif ="час назад"
    else if (timeDif<= 1320* MINUTE && timeDif> 75* MINUTE) dif ="${timeDif / HOUR} часов назад"
    else if (timeDif<= 26* HOUR && timeDif> 22* HOUR) dif = "день назад"
    else if (timeDif<= 8640* HOUR && timeDif> 26* HOUR) dif = "${timeDif / DAY} дней назад"

    else  dif = "более года назад"
    return dif
}
