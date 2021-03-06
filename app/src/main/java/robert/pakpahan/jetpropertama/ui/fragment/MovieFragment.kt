package robert.pakpahan.jetpropertama.ui.fragment

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import robert.pakpahan.jetpropertama.databinding.FragmentMovieBinding
import robert.pakpahan.jetpropertama.ui.adapter.MovieAdapter
import robert.pakpahan.jetpropertama.ui.viewmodel.MovieViewModel
import robert.pakpahan.jetpropertama.utils.MarginItemDecoration

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movies = viewModel.getMovies()

            val movieAdapter = MovieAdapter()
            movieAdapter.setMovies(movies)

            val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragmentMovieBinding.rvMovies) {
                addItemDecoration(MarginItemDecoration(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

}