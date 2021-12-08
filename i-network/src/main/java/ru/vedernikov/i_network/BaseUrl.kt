package ru.vedernikov.i_network


/**
 * Класс для описания базовой части Url сервера api
 */
class BaseUrl(base: String, apiVersion: String?) {

    val base: String = base.replaceFirst(END_SLASH.toRegex(), "")
    private var apiVersion: String? = null

    override fun toString(): String {
        return if (apiVersion != null) {
            "$base/$apiVersion/"
        } else base
    }

    companion object {
        private const val START_SLASH = "^/"
        private const val END_SLASH = "/$"
    }

    init {
        if (apiVersion != null) {
            this.apiVersion = apiVersion
                .replaceFirst(START_SLASH.toRegex(), "")
                .replaceFirst(END_SLASH.toRegex(), "")
        }
    }
}