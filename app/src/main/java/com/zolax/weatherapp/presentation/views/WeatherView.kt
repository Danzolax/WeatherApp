package com.zolax.weatherapp.presentation.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class WeatherView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    enum class WeatherType {
        SUN,
        RAIN,
        CLOUDS;
    }


    private var type: WeatherType = WeatherType.SUN

    fun setWeatherType(typeNew: WeatherType) {
        type = typeNew
        invalidate()
    }


    override fun onDraw(canvas: Canvas?) {
        when(type){
            WeatherType.SUN -> drawSun(canvas)
            WeatherType.RAIN -> drawRain(canvas)
            WeatherType.CLOUDS -> drawClouds(canvas)
        }
    }

    private fun drawClouds(canvas: Canvas?) {

    }

    private fun drawRain(canvas: Canvas?) {
        val paint = Paint().apply {
            isAntiAlias = true
            color = Color.parseColor("#5181b8")
            style = Paint.Style.FILL_AND_STROKE
        }
        val path = Path().apply {
            moveTo(width / 2f - 150f, height / 2f)
            lineTo(width / 2f + 150f,height / 2f)
            lineTo(width / 2f,height / 2f + 150f)
            lineTo(width / 2f - 150f,height / 2f + 150f)

            close()

        }
        rotation = 135f
        canvas?.drawCircle(width / 2f, height / 2f, 150f, paint)
        canvas?.drawPath(path,paint)

    }

    private fun drawSun(canvas: Canvas?) {
        val paint = Paint().apply {
            isAntiAlias = true
            color = Color.YELLOW
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 10f
        }
        rotation = 0f
        canvas?.drawCircle(width / 2f, height / 2f, 150f, paint)
        canvas?.drawLine(0f, 0f, width / 2f, height / 2f, paint)
        canvas?.drawLine(width.toFloat(), height.toFloat(), width / 2f, height / 2f, paint)
        canvas?.drawLine(width / 2f, height / 2f, width / 2f, 0f, paint)
        canvas?.drawLine(width / 2f, height / 2f, width / 2f, height.toFloat(), paint)
        canvas?.drawLine(width / 2f, height / 2f, width.toFloat(), 0f, paint)
        canvas?.drawLine(width / 2f, height / 2f, width.toFloat(), height / 2f, paint)
        canvas?.drawLine(width / 2f, height / 2f, 0f, height / 2f, paint)
        canvas?.drawLine(width / 2f, height / 2f, 0f, height.toFloat(), paint)
    }
}