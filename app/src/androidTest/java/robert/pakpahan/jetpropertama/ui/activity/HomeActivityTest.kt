package robert.pakpahan.jetpropertama.ui.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers
import org.junit.*
import robert.pakpahan.jetpropertama.R
import robert.pakpahan.jetpropertama.utils.DataDummy

class HomeActivityTest {

    private val dummyMovie = DataDummy.getMovies()
    private val dummyTvShow = DataDummy.getTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        Espresso.onView(withId(R.id.rv_movies))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.iv_detail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.iv_detail))
            .check(ViewAssertions.matches(ViewMatchers.withTagValue(CoreMatchers.equalTo(dummyMovie[0].poster))))
        Espresso.onView(withId(R.id.collapsing))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.collapsing))
            .check(ViewAssertions.matches(withContentDescription(dummyMovie[0].title)))
        Espresso.onView(withId(R.id.tv_detail_genre_duration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_genre_duration))
            .check(ViewAssertions.matches(ViewMatchers.withText("${dummyMovie[0].genre} | ${dummyMovie[0].duration}")))
        Espresso.onView(withId(R.id.tv_detail_overview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_overview))
            .check(ViewAssertions.matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadTvShows() {
        Espresso.onView(ViewMatchers.withText("TV SHOW")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_shows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        Espresso.onView(ViewMatchers.withText("TV SHOW")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(withId(R.id.iv_detail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.iv_detail))
            .check(ViewAssertions.matches(ViewMatchers.withTagValue(CoreMatchers.equalTo(dummyTvShow[0].poster))))
        Espresso.onView(withId(R.id.collapsing))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.collapsing))
            .check(ViewAssertions.matches(withContentDescription(dummyTvShow[0].title)))
        Espresso.onView(withId(R.id.tv_detail_genre_duration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_genre_duration))
            .check(ViewAssertions.matches(ViewMatchers.withText("${dummyTvShow[0].genre} | ${dummyTvShow[0].duration}")))
        Espresso.onView(withId(R.id.tv_detail_overview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_detail_overview))
            .check(ViewAssertions.matches(withText(dummyTvShow[0].overview)))
    }
}