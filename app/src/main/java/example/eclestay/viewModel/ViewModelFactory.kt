package example.eclestay.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import example.eclestay.data.repository.BaseRepository
import example.eclestay.data.repository.Repository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: BaseRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ViewModelClass::class.java) -> ViewModelClass(repository as Repository) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}