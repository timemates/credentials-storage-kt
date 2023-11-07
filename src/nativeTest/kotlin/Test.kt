//import io.timemates.credentials.native.Lib_setString
import io.timemates.credentials.native.Lib_getString
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.cstr
import kotlinx.cinterop.toKStringFromUtf8
import kotlin.test.Test
import kotlin.test.assertEquals

public class TestS {
    @OptIn(ExperimentalForeignApi::class)
    @Test
    public fun a() {
        val value = Lib_getString("".cstr)
        assertEquals("", value?.toKStringFromUtf8())
    }
}