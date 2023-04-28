package com.example.hotelbooking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelbooking.Model.*
import com.example.hotelbooking.databinding.FragmentMenuBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MenuFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        var binding=FragmentMenuBinding.inflate(inflater,container,false)
        var BigHotels= mutableListOf<Hotel>()
        for (i in 0..3)
        {
            BigHotels.add(Hotel("Emeralda Da Hotel","Paris,France",3244,29,
            R.drawable.hotel1_mini,false,R.drawable.hotel1 ,4.8,"Lorem",true,true,true,true))
            BigHotels.add(Hotel("President Hotel","Paris,France",4546,33,
            R.drawable.hotel2_mini,true,R.drawable.hotel2, 4.8,"Lorem",true,true,true,true))

        }

        var anotherHotels= mutableListOf<Hotel>()
        for (i in 0..5){
            anotherHotels.add(Hotel("Royal Hotel","Amserdam,Netherlad",3377,31,R.drawable.hotel3_mini,true,R.drawable.hotel3_mini,4.3,"Lorem",true,false
            ,true,true))
        }
        var categories= mutableListOf<Category>()
        var BigHotelManager= GridLayoutManager(this.requireContext(),1,LinearLayoutManager.HORIZONTAL, false)
        var bigHotelAdapter=BigHotelAdapter(BigHotels,object :BigHotelAdapter.onClick{
            override fun setOnClick(temp: Hotel) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_bottom, HotelFragment.newInstance(temp))
                    .commit()
            }
        })
        binding.bigHotelRv.layoutManager=BigHotelManager
        binding.bigHotelRv.adapter=bigHotelAdapter

        for (i in 0..3){
            categories.add(Category(anotherHotels,"Popular",false))
            categories.add(Category(BigHotels,"Trending",false))
        }
        var CategoriesManager=GridLayoutManager(this.requireContext(),1,LinearLayoutManager.HORIZONTAL,false)
        var CategoriesAdapter=CategoryAdapter(categories,object:CategoryAdapter.onClick{
            override fun setOnClick(temp: Category) {
                for (i in categories){
                    i.isChecked=false
                }
                temp.isChecked=true
                var categoryBigAdapter=BigHotelAdapter(temp.hotels,object :BigHotelAdapter.onClick{
                    override fun setOnClick(temp: Hotel) {
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.main_bottom, HotelFragment.newInstance(temp))
                            .commit()
                    }
                })
                binding.bigHotelRv.adapter=categoryBigAdapter
            }

        })
        binding.categoryRv.layoutManager=CategoriesManager
        binding.categoryRv.adapter=CategoriesAdapter




        var miniHotelManager=GridLayoutManager(this.requireContext(),1,LinearLayoutManager.VERTICAL,false)
        var miniHotelAdapter=MiniHotelAdapter(BigHotels,object:MiniHotelAdapter.onClick{
            override fun setOnClick(temp: Hotel) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_bottom, HotelFragment.newInstance(temp))
                    .commit()
            }
        })
        binding.miniHotelRv.layoutManager=miniHotelManager
        binding.miniHotelRv.adapter=miniHotelAdapter



        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Hotel, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}