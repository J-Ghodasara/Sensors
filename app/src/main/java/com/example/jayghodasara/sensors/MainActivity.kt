package com.example.jayghodasara.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager: SensorManager
    lateinit var accelerometer: Sensor
    lateinit var magno: Sensor
    lateinit var gyroscope: Sensor
    lateinit var pressure: Sensor
    lateinit var temp: Sensor
    lateinit var lightt: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        magno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        //pressure= sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
        lightt = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        // temp= sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)


        Log.i("Max light range", lightt.maximumRange.toString())

        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, magno, SensorManager.SENSOR_DELAY_NORMAL)
        //  sensorManager.registerListener(this,pressure,SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, lightt, SensorManager.SENSOR_DELAY_NORMAL)
        // sensorManager.registerListener(this,temp,SensorManager.SENSOR_DELAY_NORMAL)
    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Toast.makeText(applicationContext, "Accuracy Changed to $accuracy", Toast.LENGTH_LONG).show()
    }

    override fun onSensorChanged(event: SensorEvent?) {

        var sensor: Sensor = event!!.sensor


        if (sensor.type == Sensor.TYPE_ACCELEROMETER) {
            x.text = event!!.values[0].toString()
            y.text = event.values[1].toString()
            z.text = event.values[2].toString()
        } else if (sensor.type == Sensor.TYPE_GYROSCOPE) {
            xgyro.text = event!!.values[0].toString()
            ygyro.text = event.values[1].toString()
            zgyro.text = event.values[2].toString()
        } else if (sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
            xmagno.text = event!!.values[0].toString()
            ymagno.text = event.values[1].toString()
            zmagno.text = event.values[2].toString()
        } else if (sensor.type == Sensor.TYPE_LIGHT) {
            light.text = event.values[0].toString()
        }
//        else if(sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
//            Toast.makeText(applicationContext, event.values[0].toString(), Toast.LENGTH_SHORT).show()
//}
//        else if(sensor.type == Sensor.TYPE_PRESSURE)
//        {
//            tv_pressure.text=event.values[0].toString()
//        }

    }

}
