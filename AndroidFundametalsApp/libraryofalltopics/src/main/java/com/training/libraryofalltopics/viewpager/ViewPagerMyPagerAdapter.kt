package com.training.libraryofalltopics.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerMyPagerAdapter(frameManager: FragmentManager, lifeCycle: Lifecycle)
    : FragmentStateAdapter(frameManager, lifeCycle) {

    var fragmentList:ArrayList<Fragment> = ArrayList()
    fun addFragments(fragment: Fragment){
        fragmentList.add(fragment)
    }
    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
}