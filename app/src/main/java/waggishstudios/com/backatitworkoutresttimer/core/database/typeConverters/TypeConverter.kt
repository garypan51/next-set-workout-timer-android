package waggishstudios.com.backatitworkoutresttimer.core.database.typeConverters

import androidx.room.TypeConverter
import waggishstudios.com.backatitworkoutresttimer.core.TimerStatus

class TimerTypeConverter {
    @TypeConverter
    fun timersListToString(timersList: ArrayList<Int>): String? {
        var timersListString = ""
        for (i in 0 until timersList.size){
            timersListString += if(i != timersList.size - 1) timersList[i].toString() + "," else timersList[i].toString()

        }
        return timersListString
    }

    @TypeConverter
    fun stringToTimerList(stringTimersList: String): ArrayList<Int>? {
        val timersList = ArrayList<Int>()
        for (i in stringTimersList.split(",")){
            timersList.add(Integer.parseInt(i))
        }
        return timersList
    }

    @TypeConverter
    fun timerStatusToInt(status: TimerStatus) : Int? {
        return status.status
    }

    @TypeConverter
    fun intToTimerStatus(integer: Int) : TimerStatus? {
        return TimerStatus.getStatusByInt(integer)
    }
}