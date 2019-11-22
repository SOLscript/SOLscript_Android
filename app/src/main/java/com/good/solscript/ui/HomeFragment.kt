package com.good.solscript.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.good.solscript.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var nowFrag: Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fab_homefrag_chatbtn.setOnClickListener {
            startActivity<ChatActivity>()
        }

        callFragment(1)
        setClickListener()
    }

    fun setClickListener() {
        rl_homefragment_calender.setOnClickListener {
            callFragment(1)
        }

        rl_homefragment_subscript.setOnClickListener {
            callFragment(2)
        }

        rl_homefragment_used.setOnClickListener {
            callFragment(3)
        }

    }

    private fun callFragment(frag: Int) {

        when (frag) {
            1 -> {
                nowFrag = HomeCalenderFragment()
            }

            2 -> {
                nowFrag = HomeSubscriptFragment()
            }

            3 -> {
                nowFrag = HomeUsedFragment()
            }
        }

        Log.d("callFragment", "  ")

        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_homefragment_container, nowFrag)
        transaction.commit()
    }
}

