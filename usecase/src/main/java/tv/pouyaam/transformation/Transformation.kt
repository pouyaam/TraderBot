package tv.pouyaam.transformation

interface Transformation<in MODEL, out DOMAIN> {
    fun transform(response: MODEL) : DOMAIN
}