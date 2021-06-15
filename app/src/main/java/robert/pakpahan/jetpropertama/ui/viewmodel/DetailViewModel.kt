package robert.pakpahan.jetpropertama.ui.viewmodel

import androidx.lifecycle.ViewModel
import robert.pakpahan.jetpropertama.data.MovieEntity
import robert.pakpahan.jetpropertama.utils.DataDummy

class DetailViewModel: ViewModel() {
    companion object {
        const val TV_SHOW = "tvShow"
        const val MOVIE = "movie"
    }

    private lateinit var film: MovieEntity

    fun setFilm(id: String, category: String) {
        when (category) {
            TV_SHOW -> {
                for (tvShow in DataDummy.getTvShows()) {
                    if (tvShow.id == id) film = tvShow
                }
            }

            MOVIE -> {
                for (movie in DataDummy.getMovies()) {
                    if (movie.id == id) film = movie
                }
            }
        }
    }

    fun getFilmDetail() = film

}