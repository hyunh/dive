package hyunh.dive.ui.naver

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hyunh.dive.domain.usecase.GetAvailableSearchCategory
import javax.inject.Inject

@HiltViewModel
class NaverViewModel @Inject constructor(
    getAvailableSearchCategory: GetAvailableSearchCategory
) : ViewModel() {

    val availableSearchCategory = getAvailableSearchCategory()
}
