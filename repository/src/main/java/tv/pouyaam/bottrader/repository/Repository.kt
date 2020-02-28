package tv.pouyaam.bottrader.repository

interface Repository<in REQUEST, out RESPONSE> {
    
    suspend fun invoke(parameter : REQUEST) : RESPONSE
}