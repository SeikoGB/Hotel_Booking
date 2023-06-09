package com.example.hotelbooking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbooking.Model.Hotel
import com.example.hotelbooking.databinding.FragmentHotelBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HotelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HotelFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Hotel? = null
//    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as Hotel
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var binding=FragmentHotelBinding.inflate(inflater,container,false)
        binding.image.setBackgroundResource(param1!!.main_photo)
        binding.price.text="$"+param1!!.price_pernight


        binding.buy.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.main_bottom,
                BookingFragment.newInstance(param1!!.price_pernight))
                .commit()
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HotelFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: Hotel) =
                HotelFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}