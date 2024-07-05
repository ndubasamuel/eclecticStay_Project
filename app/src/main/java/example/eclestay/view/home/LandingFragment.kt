package example.eclestay.view.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import example.eclestay.R
import example.eclestay.data.repository.Repository
import example.eclestay.databinding.FragmentLandingBinding
import example.eclestay.view.base.BaseFragment
import example.eclestay.viewModel.ViewModelClass


class LandingFragment : Fragment() {

    lateinit var binding: FragmentLandingBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLandingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}