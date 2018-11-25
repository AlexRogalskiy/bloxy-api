package io.api.bloxy.core.transaction

import io.api.bloxy.core.Tester
import io.api.bloxy.error.ParamException
import org.junit.Test


/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 24.11.2018
 */
class TransfersTests : Tester() {

    @Test
    fun valid() {
        val list = listOf("0x52a9a7dfe6f002b7d7deb5555e356e319839fc4dc280a68de55778524a41f986")
        val transfer = api.tx().transfers(list)
        assertNotNull(transfer)
        assertFalse(transfer.isEmpty())
        assertFalse(transfer[0].isEmpty())
    }

    @Test
    fun `non exist address empty result`() {
        val list = listOf("0x12a9a7dfe6f002b7d7deb5555e356e319839fc4dc280a68de55778524a41f986")
        val transfer = api.tx().transfers(list)
        assertNotNull(transfer)
        assertTrue(transfer.isEmpty())
    }

    @Test(expected = ParamException::class)
    fun `invalid address param error`() {
        val list = listOf("0x5a9a7dfe6f002b7d7deb5555e356e319839fc4dc280a68de55778524a41f986")
        val transfer = api.tx().transfers(list)
    }

    @Test(expected = ParamException::class)
    fun `empty param error`() {
        val transfer = api.tx().transfers(emptyList())
    }
}