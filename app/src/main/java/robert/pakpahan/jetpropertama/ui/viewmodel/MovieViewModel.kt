package robert.pakpahan.jetpropertama.ui.viewmodel

import androidx.lifecycle.ViewModel
import robert.pakpahan.jetpropertama.utils.DataDummy

class MovieViewModel: ViewModel() {
    fun getMovies () = DataDummy.getMovies()
}