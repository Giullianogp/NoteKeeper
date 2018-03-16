package com.giulliano.notekeeper


class CourseInfo(val courseId: String, val title: String, val modules: List<ModuleInfo>) {

    var modulesCompletionStatus: BooleanArray
        get() {
            val status = BooleanArray(modules.size)

            for (i in modules.indices)
                status[i] = modules[i].isComplete

            return status
        }
        set(status) {
            for (i in modules.indices)
                modules[i].isComplete = status[i]
        }

    fun getModule(moduleId: String): ModuleInfo? {
        for (moduleInfo in modules) {
            if (moduleId == moduleInfo.moduleId)
                return moduleInfo
        }
        return null
    }

    override fun toString(): String {
        return title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as CourseInfo?

        return courseId == that!!.courseId

    }

    override fun hashCode(): Int {
        return courseId.hashCode()
    }

}
