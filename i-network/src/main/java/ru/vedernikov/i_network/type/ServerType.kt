package ru.vedernikov.i_network.type

/**
 * Тип сервера, доступный в приложении
 */
enum class ServerType(val id: Int) {
    MOCK(0),
    TEST(1),
    PROD(2);

    companion object {
        fun getById(id: Int) = values().find { it.id == id } ?: TEST
    }
}
