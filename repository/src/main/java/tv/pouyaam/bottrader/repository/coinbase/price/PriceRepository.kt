package tv.pouyaam.bottrader.repository.coinbase.price
import tv.pouyaam.bottrader.network.api.coinbase.PriceApi
import tv.pouyaam.bottrader.network.model.coinbase.price.ResponsePrice
import tv.pouyaam.bottrader.repository.Repository

abstract class PriceRepository(private val priceApi: PriceApi) : Repository<String, ResponsePrice>