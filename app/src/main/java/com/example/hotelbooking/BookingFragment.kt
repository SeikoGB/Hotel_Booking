package com.example.hotelbooking

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hotelbooking.databinding.FragmentBookingBinding
import com.google.android.material.button.MaterialButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        var binding=FragmentBookingBinding.inflate(inflater,container,false)
        var dialog = Dialog(requireContext())
        var dialogView=layoutInflater.inflate(R.layout.dialog,null)
        var btnyes=dialogView.findViewById<MaterialButton>(R.id.btnyes)
        var btnno=dialogView.findViewById<MaterialButton>(R.id.btnno)
        var price=dialogView.findViewById<TextView>(R.id.price)

        binding.toBook.setOnClickListener {
            if (binding.bookingDate.text!=null&&binding.daysAmount.text!=null){
                dialog.setContentView(dialogView)

                price.text=(param1?.times(binding.daysAmount.text.toString().toFloat())).toString()+"$"
                dialog.window?.setBackgroundDrawable(ColorDrawable(Color.GRAY))

                dialog.show()



            }
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
         * @return A new instance of fragment BookingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            BookingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}