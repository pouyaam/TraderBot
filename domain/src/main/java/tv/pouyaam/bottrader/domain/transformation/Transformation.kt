package tv.pouyaam.bottrader.domain.transformation

interface Transformation<in MODEL, out DOMAIN> {
    fun transform(response: MODEL) : DOMAIN
}