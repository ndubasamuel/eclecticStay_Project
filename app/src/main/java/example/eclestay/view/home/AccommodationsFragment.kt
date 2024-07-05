package example.eclestay.view.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import example.eclestay.R
import example.eclestay.data.network.DataApi
import example.eclestay.data.repository.Repository
import example.eclestay.databinding.FragmentAccomodationBinding
import example.eclestay.databinding.FragmentLandingBinding
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelClass


class AccomodationsFragment : BaseFragment<ViewModelClass, FragmentAccomodationBinding, Repository>() {
    override fun getViewModel(): Class<ViewModelClass> {
        return ViewModelClass::class.java
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentAccomodationBinding {
        return FragmentAccomodationBinding.inflate(inflater, container, false)

    }
    override fun getFragmentRepository(): Repository {
        return Repository(remoteDataStore.buildApi(DataApi::class.java), userPreferences)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            toolBar.setOnClickListener {
                when (it.id) 
                findNavController().navigate(R.id.action_accomodationsFragment_to_landingFragment)
            }
        }


    }


}
