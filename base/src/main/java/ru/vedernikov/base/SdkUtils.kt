package ru.vedernikov.base

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

/**
 * Утилиты для проверки версии Api
 */
object SdkUtils {

    fun isPreLollipop(): Boolean = Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.LOLLIPOP)
    fun isAtLeastLollipop(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.M)
    fun isAtLeastMarshmallow(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N)
    fun isAtLeastNougat(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O)
    fun isAtLeastOreo(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.P)
    fun isAtLeastPie(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P

    /**
     * Запускает блок кода на устройствах с андроид версии KitKat и ниже
     *
     * @param block запускаемый блок кода
     */
    fun runOnPreLollipop(block: () -> Unit) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            block()
        }
    }

    /**
     * Запускает блок кода на устройствах с андроид версии Lollipop и выше
     *
     * @param block запускаемый блок кода
     */
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.LOLLIPOP, lambda = 0)
    fun runOnLollipop(block: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            block()
        }
    }

    /**
     * Запускает блок кода на устройствах с андроид версии Marshmallow и выше
     *
     * @param block запускаемый блок кода
     */
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.M, lambda = 0)
    fun runOnMarshmallow(block: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            block()
        }
    }

    /**
     * Запускает блок кода на устройствах с андроид версии Noughat и выше
     *
     * @param block запускаемый блок кода
     */
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N, lambda = 0)
    fun runOnNoughat(block: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            block()
        }
    }

    /**
     * Запускает блок кода на устройствах с андроид версии Oreo и выше
     *
     * @param block запускаемый блок кода
     */
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O, lambda = 0)
    fun runOnOreo(block: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            block()
        }
    }

    /**
     * Запускает блок кода на устройствах с андроид версии Pie и выше
     *
     * @param block запускаемый блок кода
     */
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.P, lambda = 0)
    fun runOnPie(block: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            block()
        }
    }

    /**
     * Запускает ту, или иную лямбду в зависимости какая версия api на устройстве
     */
    fun doIfSdk(atLeast: Boolean, ifTrue: () -> Unit, ifFalse: () -> Unit) =
        if (atLeast) ifTrue() else ifFalse()
}
