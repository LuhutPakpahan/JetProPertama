package robert.pakpahan.jetpropertama.ui.viewmodel

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import robert.pakpahan.jetpropertama.utils.DataDummy

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getMovies()[0]
    private val dummyMovieId = dummyMovie.id

    private val dummyTvShow = DataDummy.getTvShows()[0]
    private val dummyTvShowId = dummyTvShow.id

    // Get Data Movie Testing
    @Before
    fun setUpMovie() {
        viewModel = DetailViewModel()
        viewModel.setFilm(dummyMovieId, "movie")
    }

    @Test
    fun getMovieDetail() {
        viewModel.setFilm(dummyMovie.id, "movie")
        val movie = viewModel.getFilmDetail()
        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.overview, movie.overview)
        assertEquals(dummyMovie.duration, movie.duration)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.poster, movie.poster)
    }

    // Get Data TV Show Testing
    @Before
    fun setupTvShow() {
        viewModel = DetailViewModel()
        viewModel.setFilm(dummyTvShowId, "tvShow")
    }

    @Test
    fun getTvShowDetail() {
        viewModel.setFilm(dummyTvShow.id, "tvShow")
        val tvShow = viewModel.getFilmDetail()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.id, tvShow.id)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.overview, tvShow.overview)
        assertEquals(dummyTvShow.duration, tvShow.duration)
        assertEquals(dummyTvShow.genre, tvShow.genre)
        assertEquals(dummyTvShow.poster, tvShow.poster)
    }
}