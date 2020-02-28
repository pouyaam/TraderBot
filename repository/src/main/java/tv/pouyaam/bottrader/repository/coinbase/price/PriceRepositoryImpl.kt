package tv.pouyaam.bottrader.repository.coinbase.price

import tv.pouyaam.bottrader.network.api.coinbase.PriceApi
import tv.pouyaam.bottrader.network.model.coinbase.price.ResponsePrice

class PriceRepositoryImpl(private val priceApi: PriceApi) : PriceRepository(priceApi) {
    override suspend fun invoke(parameter: String): ResponsePrice = priceApi.price(parameter)
}