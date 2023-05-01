package com.example.CWWPRO

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainAppFragment : Fragment() {
    var bottomNavigation: BottomNavigationView? = null
    // TODO: Rename and change types of parameters
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
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_app, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFragment(HomeModel())
        val bottomNavigation = view.findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigation!!.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeModel -> loadFragment(HomeModel())
                R.id.floodMap -> loadFragment(FloodMap())
                R.id.rainPredict -> loadFragment(RainPredict())
                R.id.dam -> loadFragment(Dam())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            if (fragment != null) {
                replace(R.id.fl_container, fragment)
                commit()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainAppFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainAppFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}