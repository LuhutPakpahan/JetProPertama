package robert.pakpahan.jetpropertama.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*
import robert.pakpahan.jetpropertama.R
import robert.pakpahan.jetpropertama.ui.adapter.ViewPagerAdapter
import robert.pakpahan.jetpropertama.ui.fragment.MovieFragment
import robert.pakpahan.jetpropertama.ui.fragment.TvShowFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setViewPager()
    }

    private fun setViewPager() {
        val fragmentList = listOf(MovieFragment(), TvShowFragment())
        val tabTitle = listOf("Movie", "Tv Show")

        viewpager.adapter = ViewPagerAdapter(fragmentList, this.supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout2, viewpager){tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}