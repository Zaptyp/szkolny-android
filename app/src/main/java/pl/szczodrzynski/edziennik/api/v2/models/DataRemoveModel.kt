/*
 * Copyright (c) Kuba Szczodrzyński 2019-10-2.
 */

package pl.szczodrzynski.edziennik.api.v2.models

import pl.szczodrzynski.edziennik.data.db.modules.grades.GradeDao
import pl.szczodrzynski.edziennik.data.db.modules.timetable.TimetableDao
import pl.szczodrzynski.edziennik.utils.models.Date

open class DataRemoveModel {
    class Timetable(private val dateFrom: Date?, private val dateTo: Date?) : DataRemoveModel() {
        companion object {
            fun from(dateFrom: Date) = Timetable(dateFrom, null)
            fun to(dateTo: Date) = Timetable(null, dateTo)
            fun between(dateFrom: Date, dateTo: Date) = Timetable(dateFrom, dateTo)
        }
        fun commit(profileId: Int, dao: TimetableDao) {
            if (dateFrom != null && dateTo != null) {
                dao.clearBetweenDates(profileId, dateFrom, dateTo)
            }
            else {
                dateFrom?.let { dateFrom -> dao.clearFromDate(profileId, dateFrom) }
                dateTo?.let { dateTo -> dao.clearToDate(profileId, dateTo) }
            }
        }
    }
    class Grades(val all: Boolean, val semester: Int?) : DataRemoveModel() {
        companion object {
            fun all() = Grades(true, null)
            fun semester(semester: Int) = Grades(false, semester)
        }
        fun commit(profileId: Int, dao: GradeDao) {
            if (all) {
                dao.clear(profileId)
            }
            semester?.let { dao.clearForSemester(profileId, it) }
        }
    }
}