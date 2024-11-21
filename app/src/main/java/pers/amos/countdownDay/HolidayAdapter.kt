package pers.amos.countdownDay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class HolidayAdapter(private val holidays: List<Holiday>) :
    RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {

    class HolidayViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.holiday_name)
        val dateText: TextView = view.findViewById(R.id.holiday_date)
        val daysLeftText: TextView = view.findViewById(R.id.days_left)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holiday_item, parent, false)
        return HolidayViewHolder(view)
    }

    override fun onBindViewHolder(holder: HolidayViewHolder, position: Int) {
        val holiday = holidays[position]
        holder.nameText.text = holiday.name
        holder.dateText.text = holiday.date
        holder.daysLeftText.text = "剩余: ${calculateDaysLeft(holiday.date)} 天"
    }

    override fun getItemCount() = holidays.size

    private fun calculateDaysLeft(holidayDate: String): Long {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val targetDate = LocalDate.parse(holidayDate, formatter)
        val currentDate = LocalDate.now()
        return ChronoUnit.DAYS.between(currentDate, targetDate)
    }
}