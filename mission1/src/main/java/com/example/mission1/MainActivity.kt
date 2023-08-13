package com.example.mission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.widget.ViewPager2
class MainActivity : AppCompatActivity(), RegisterFragment.OnContactAddedListener  {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        val fragmentAdapter = FragmentAdapter(this)
        viewPager.adapter = fragmentAdapter

        val tabTitles = listOf("등록", "조회")
        val tabIcons = listOf(R.drawable.register, R.drawable.check)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
            tab.setIcon(tabIcons[position])

        }.attach()
    }
    override fun onContactAdded(contact: RegisterFragment.Contact) {
        val viewContactsFragment = supportFragmentManager.findFragmentByTag("f2") as? ViewContactsFragment
        viewContactsFragment?.updateContactList(contact)
    }
}

