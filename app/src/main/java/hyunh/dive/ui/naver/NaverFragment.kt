package hyunh.dive.ui.naver

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import hyunh.dive.R
import hyunh.dive.databinding.FragmentNaverBinding
import hyunh.dive.domain.model.SearchCategory
import hyunh.dive.ui.viewBinding

@AndroidEntryPoint
class NaverFragment : Fragment(R.layout.fragment_naver) {

    private val binding by viewBinding(FragmentNaverBinding::bind)
    private val viewModel: NaverViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.availableSearchCategory.run {
            binding.pager.adapter = CategoryAdapter(
                fragment = this@NaverFragment,
                categories = viewModel.availableSearchCategory
            )
            TabLayoutMediator(binding.tablayout, binding.pager) { tab, position ->
                tab.text = get(position).text
            }.attach()
        }
    }

    class CategoryAdapter(
        fragment: Fragment,
        private val categories: List<SearchCategory>,
    ) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int {
            return categories.size
        }

        override fun createFragment(position: Int): Fragment {
            return ContentFragment()
        }
    }
}
