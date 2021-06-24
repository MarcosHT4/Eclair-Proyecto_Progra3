package com.example.eclair_hospitalsearcher

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getCount(): Int {

        return 2

    }

    override fun getItem(position: Int): Fragment {

        return when(position) {

            0-> {

                ConsultFragment()

            }
            1-> DeleteFragment()

            else -> {

                return DeleteFragment()

            }


        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {

            0-> "Consult"
            1-> "Delete"
            else -> {

                return "Delete"

            }


        }
    }


}