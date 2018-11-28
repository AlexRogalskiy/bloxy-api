package io.api.bloxy.model.dto.token

import com.beust.klaxon.Json
import io.api.bloxy.model.IModel
import io.api.bloxy.model.ITokenModel
import io.api.bloxy.model.dto.TokenType


/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 17.11.2018
 */
data class TokenStatistic(
    val first_transfer: String = "",
    val latest_transfer: String = "",
    val transfers: Long = 0,
    val senders: Long = 0,
    val receivers: Long = 0,
    val transfered_amount: Double = .0,
    val token_annotation: String = "",
    val address: String = "",
    val name: String = "",
    val symbol: String = "",
    val decimals: Int = 0,
    @Json(name = "type")
    val typeAsString: String = "",
    val holders_count: Long = 0,
    val circulating_supply: Double = .0
) : IModel, ITokenModel {

    override val tokenType: TokenType = TokenType.parse(typeAsString)

    override fun isEmpty(): Boolean {
        return address.isEmpty() && first_transfer.isEmpty() && latest_transfer.isEmpty()
                && name.isEmpty() && symbol.isEmpty() && transfers == 0L && decimals == 0
    }
}