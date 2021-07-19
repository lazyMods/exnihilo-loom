package lazy.exnihiloloom.common.util

fun <T> MutableList<T>.addAndReturn(value: T): T {
    this.add(value)
    return value
}