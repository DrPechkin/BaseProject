package ru.vedernikov.i_network

import ru.vedernikov.i_network.type.ServerType
import ru.vedernikov.i_network.type.ServerTypeContainer

/**
 * Базовые url для всех запросов к серверу
 * todo Заполни урлы
 */
object BaseUrls {

    val baseUrl: String
        get() = when (ServerTypeContainer.serverType) {
            ServerType.MOCK -> Mock.API
            ServerType.TEST -> Test.API
            ServerType.PROD -> Prod.API
        }

    object Prod {
        const val API = ""
        const val VERSION = "v1/"
    }

    object Test {
        const val API = ""
        const val VERSION = "v1/"
    }

    object Mock {
        const val API = ""
        const val VERSION = ""
    }
}