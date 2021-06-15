package robert.pakpahan.jetpropertama.ui.viewmodel

import androidx.lifecycle.ViewModel
import robert.pakpahan.jetpropertama.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShows() = DataDummy.getTvShows()
}