package com.singularitycoder.myhabits

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.singularitycoder.myhabits.databinding.ListItemHabitBinding

class HabitsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var habitList = emptyList<Habit>()
    private var itemClickListener: (habit: Habit) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ListItemHabitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HabitViewHolder).setData(habitList[position])
    }

    override fun getItemCount(): Int = habitList.size

    override fun getItemViewType(position: Int): Int = position

    fun setHabitClickListener(listener: (habit: Habit) -> Unit) {
        itemClickListener = listener
    }

    inner class HabitViewHolder(
        private val itemBinding: ListItemHabitBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(habit: Habit) {
            itemBinding.apply {
                checkbox.text = habit.name
                checkbox.isChecked = habit.isDone
                checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
                    itemClickListener.invoke(habit)
                }
            }
        }
    }
}
