package robert.pakpahan.jetpropertama.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieEntity(
    val id: String,
    val title: String,
    val overview: String,
    val duration: String,
    val genre: String,
    val poster: Int
) : Parcelable