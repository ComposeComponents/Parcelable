import cl.emilym.kmp.parcelable.Parcelable
import cl.emilym.kmp.parcelable.Parcelize

@Parcelize
data class GreetingMessage(
    val message: String
): Parcelable