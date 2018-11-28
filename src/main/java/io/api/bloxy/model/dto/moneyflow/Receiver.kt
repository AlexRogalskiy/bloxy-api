package io.api.bloxy.model.dto.moneyflow

import com.beust.klaxon.Json
import io.api.bloxy.model.IAddressModel
import io.api.bloxy.model.IModel
import io.api.bloxy.model.dto.AddressType


/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 18.11.2018
 */
data class Receiver(
    val receiver: String = "",
    @Json(name = "receiver_type")
    val type_as_string: String = "",
    val amount: Double = .0,
    val transactions: Long = 0,
    val annotation: String = ""
) : IModel, IAddressModel {

    override val addressType: AddressType = AddressType.parse(type_as_string)

    override fun isEmpty(): Boolean {
        return receiver.isEmpty() && transactions == 0L && amount == .0
    }
}