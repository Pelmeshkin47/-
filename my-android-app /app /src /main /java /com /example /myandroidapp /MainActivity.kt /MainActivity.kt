package com.example.myandroidapp
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val rootLayout = LinearLayout(this).apply {
      orientation = LinearLayout.VERTICAL
      gravity = Gravity.CENTER
      setPadding(32, 32, 32, 32)
      setBackgroundColor(Color.WHITE) }

    val textViewTitle = TextView(this).apply {
      text = "hello world!"
      textSize = 24f
      setTextColor(Color.BLACK)
      gravity = Gravity.CENTER }
    val buttonChangeText = Button(this).apply {
      text = "change text"
      isAllCaps = false
    }
    val params = linearLayout.LayoutParams{
      LinearLayout.LayoutParams.WRAP_CONTENT,
      LinearLayout.LayoutParams.WRAP_CONTENT
    }.apply {
      bottomMargin = 32
    }
    textViewTitle.layoutParams = params
    rootLayout.addView(textViewTitle)
    rootLayout.addView(buttonChangeText)
    setContentView(rootLayout)
    var isChanged = false
    buttonChangeText.setOnClickListener {
      if (isChanged) {
        textViewTitle.text = "hello world hello world!" }
      else {
        TextViewTitle.text = "text changed !" }
      isChanged = !isChanged } } }
