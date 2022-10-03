package hyunh.dive.ui.naver

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hyunh.dive.domain.usecase.GetAvailableSearchCategory
import hyunh.dive.domain.usecase.SearchBlogItemUseCase
import javax.inject.Inject

@HiltViewModel
class NaverViewModel @Inject constructor(
    getAvailableSearchCategory: GetAvailableSearchCategory,
    private val searchBlogItemUseCase: SearchBlogItemUseCase
) : ViewModel() {

    val availableSearchCategory = getAvailableSearchCategory()
}
