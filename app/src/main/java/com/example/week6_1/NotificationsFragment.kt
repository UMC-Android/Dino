package com.example.week6_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week6_1.R

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 프래그먼트의 UI를 생성하고 반환하는 코드 작성
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    // 필요한 경우 추가적인 프래그먼트 동작이나 로직을 작성
}
