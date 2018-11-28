package io.api.bloxy.core.tokesale

import io.api.bloxy.core.Tester
import io.api.bloxy.error.ParamException
import org.junit.Test


/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 25.11.2018
 */
class StatsAddressTests : Tester() {

    @Test
    fun `valid with sale`() {
        val sale = SalesTests.getRandomTokenSale(api)
        if (!sale.isEmpty()) {
            val result = api.tokenSale.statsAddress(sale)
            assertNotNull(result)
            assertFalse(result.isEmpty())
            assertFalse(result[0].isEmpty())
            assertNotNull(result[0].eth_amount)
            assertNotNull(result[0].ether_receiver)
            assertNotNull(result[0].from_time_as_string)
            assertNotNull(result[0].from_time)
            assertNotNull(result[0].till_time_as_string)
            assertNotNull(result[0].till_time)
            assertNotNull(result[0].token_buyers)
            assertNotNull(result[0].transactions)
            assertNotNull(result[0].token_buyers)
            assertNotNull(result[0].token_amount)
            assertNotNull(result[0].token_sender)
        }
    }

    @Test
    fun `non exist address empty result`() {
        val contract = "0xf1b0a3efb8e8e4c201e2a935f110eaaf3ffecb8d"
        val result = api.tokenSale.statsAddress(contract)
        assertNotNull(result)
        assertTrue(result.isEmpty())
    }

    @Test(expected = ParamException::class)
    fun `invalid address param error`() {
        val contract = "0x1b0a3efb8e8e4c201e2a935f110eaaf3ffecb8d"
        api.tokenSale.statsAddress(contract)
    }
}