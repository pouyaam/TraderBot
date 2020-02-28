package tv.pouyaam.bottrader.domain.usecase.coinbase.price

import tv.pouyaam.bottrader.domain.model.coinbase.price.ResponsePriceDomain
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.PriceTransformation
import tv.pouyaam.bottrader.domain.usecase.UseCase
import tv.pouyaam.bottrader.network.model.coinbase.price.ResponsePrice
import tv.pouyaam.bottrader.repository.coinbase.price.PriceRepository

class PriceUseCase(priceRepository: PriceRepository, priceTransformation: PriceTransformation) : UseCase<String, ResponsePrice, ResponsePriceDomain>(priceRepository, priceTransformation)