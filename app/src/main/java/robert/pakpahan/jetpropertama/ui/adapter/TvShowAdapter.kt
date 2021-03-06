package robert.pakpahan.jetpropertama.ui.adapter

import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import robert.pakpahan.jetpropertama.R
import robert.pakpahan.jetpropertama.data.MovieEntity
import robert.pakpahan.jetpropertama.databinding.ItemMovieBinding
import robert.pakpahan.jetpropertama.ui.activity.DetailActivity
import robert.pakpahan.jetpropertama.ui.viewmodel.DetailViewModel.Companion.TV_SHOW

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var tvShows = ArrayList<MovieEntity>()

    fun setTvShows(tvShows: ArrayList<MovieEntity>?) {
        if (tvShows.isNullOrEmpty()) return
        this.tvShows.clear()
        this.tvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    class TvShowViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: MovieEntity) {
            with(binding) {
                tvTitle.text = tvShow.title
                tvGenre.text = tvShow.genre

                Glide.with(binding.root.context)
                    .load(tvShow.poster)
                    .transform(RoundedCorners(28))
                    .into(ivPoster)

                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, tvShow.poster)

                Palette.from(bitmap).generate { palette ->
                    val defValue = itemView.resources.getColor(R.color.dark, itemView.context.theme)
                    cardItem.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, tvShow.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, TV_SHOW)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}