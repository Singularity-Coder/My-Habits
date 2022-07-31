package com.singularitycoder.myhabits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.singularitycoder.myhabits.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding

    private val habitAdapter = HabitsAdapter()
    private val habitList = ArrayList<Habit>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupUI()
    }

    private fun FragmentHomeBinding.setupUI() {
        rvHabits.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = habitAdapter
        }
        habitAdapter.habitList = habitList.apply {
            add(Habit(0, "30 min Pranayama", true))
            add(Habit(1, "10 min side kick", true))
            add(Habit(2, "30 min Read Manga", false))
            add(Habit(3, "1 hr break", false))
            add(Habit(4, "3 hr Work", true))
            add(Habit(5, "1 hr break", false))
            add(Habit(6, "4 hr Work", false))
        }
        habitAdapter.notifyDataSetChanged()
    }
}