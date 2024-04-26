package com.example.sensory
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Informacje o czujnikach obecnych na urządzeniu
    // są dostarczane przez Menedżera czujników urządzenia
    // (Sensor Manager of the device)
    private lateinit var sensorManager: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inicjalizacja zmiennej sensorManager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        // getSensorList(Sensor.TYPE_ALL)
        //lista wszystkich czujników obecnych w urządzeniu
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        // Text View w którym wyświetlimy listę czujników
        val textView = findViewById<TextView>(R.id.textView)
        // Zamiana Listy na String oraz wyświetlenie każdego czujnika
        // oraz informacji o nim
        textView.text=""
        for (sensors in deviceSensors) {
            textView.append(sensors.toString() + "\n-----------------------------------------------------\n")
        }
    }
}