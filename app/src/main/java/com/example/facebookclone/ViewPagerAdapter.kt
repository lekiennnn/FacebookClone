package com.example.facebookclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> NewsFeedFragment()
            1 -> FriendFragment()
            2 -> NotificationFragment()
            3 -> MenuFragment()
            else -> NewsFeedFragment()
            //
        }
    }
}