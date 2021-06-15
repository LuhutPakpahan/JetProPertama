package robert.pakpahan.jetpropertama.ui.viewmodel

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movie = viewModel.getMovies()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }
}