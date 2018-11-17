package io.api.bloxy.core

import io.api.bloxy.model.dto.token.*
import java.time.LocalDateTime


/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.11.2018
 */
interface ITokenApi {

    fun holders(
        address: String,
        limit: Int = 100
    ): List<Holder>

    // NO OFFSET, JUST DO NEEDED AMOUNT OF CYCLES WITH LIMIT & OFFSET TILL RETURN EMPTY
    fun holderDetails(
        address: String,
        limit: Int = 100,
        minBalance: Double = 1.0e-6,
        minReceived: Int = 1,
        minSend: Int = 0
    ): List<HolderDetails>

    fun holderCorrelations(
        addresses: List<String>
    ): List<TokenCorrelation>

    fun holderSimilar(
        address: String
    ): List<HolderSimilar>

    fun tokenByNameOrSymbol(
        nameOrSymbol: String,
        limit:Int
    ): List<Token>

    fun tokenDetails(
        addresses: List<String>
    ) : List<TokenDetails>

    fun tokenStatistic(
        address: String
    ) : List<TokenStatistic>

    // NO OFFSET, JUST DO NEEDED AMOUNT OF CYCLES WITH LIMIT & OFFSET TILL RETURN EMPTY
    fun tokenTransfers(
        address: String,
        limit: Int = 100,
        fromTime: LocalDateTime = LocalDateTime.MIN,
        tillTime: LocalDateTime = LocalDateTime.MAX
    ): List<TokenTransfer>
}