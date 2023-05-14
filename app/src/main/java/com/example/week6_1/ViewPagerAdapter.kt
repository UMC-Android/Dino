package com.example.week6_1
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.week6_1.HomeFragment
import com.example.week6_1.DashboardFragment
import com.example.week6_1.NotificationsFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            2 -> NotificationsFragment()
            else -> HomeFragment()
        }
    }
}
