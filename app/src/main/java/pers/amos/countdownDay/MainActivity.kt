package pers.amos.countdownDay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val holidays = listOf(
            Holiday("元旦", "2025-01-01"),
            Holiday("春节", "2025-01-28"),
            Holiday("清明节", "2025-04-04"),
            Holiday("劳动节", "2025-05-01")
        )

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HolidayAdapter(holidays)
    }
}