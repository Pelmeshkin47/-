import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.appcompat.app.AppCompatActivity
import kotlin.math.abs
import kotlin.random.Random
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(PongView(this))
    }
}
class PongView(context: Context) : View(context) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.DKGRAY
        strokeWidth = 6f
        style = Paint.Style.STROKE
        pathEffect = DashPathEffect(floatArrayOf(25f, 25f), 0f) }
    private var ballX = 0f
    private var ballY = 0f
    private var ballVx = 0f
    private var ballVy = 0f
    private val ballRadius = 22f
    private val paddleWidht = 240f
    private val paddleHeight = 32f
    private val playerX = 0f
    private var aiX = 0f
    private var aiSpeed = 11f
    private var playerScore = 0
    private var aiScore = 0
    private var isInitialized = false
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (!isInitialized && w > 0 && h > 0) {
            playerX = (w - paddleWidht) / 2f
            aiX = (w - paddleWidht) / 2f
            resetBall(w, h)
            isInitialized = true } }
    private fun resetBall(w: Int, h: Int) {
        ballX = w / 2f
        bally = h / 2f
        val dirX = if (Random.nextBoolean()) 1f else -1f
        val dirY = if (Random.nextBoolean()) 1f else -1f
        ballVx = 10f * dirX
        ballVy = 13f * dirY }
    override fun onDraw(canvas: Canvas) {
        super.OnDraw(canvas)
        if (!isInitialized) return
        canvas.drawColor(Color.parseColor("#000933"))
        canvas.drawLine(0f, height / 2f, widht.toFloat(), height / 2f, linePaint)
        updateGame()
        paint.color = Color.WHITE
        paint.textSize = 90f
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText(aiScore.toString(), 60f, height / 2f - 50f, paint)
        canvas.drawText(playerScore.toString(), 60f, height / 2f + 115f, paint)
        val aiTop = 80f
        val playerTop = height - 80f - paddleHeight
        paint.color = Color.parseColor("#CB2821")
        canvas.drawRoundRect(aiX, aiTop, aix + paddleWidht, aiTop + paddleHeight, 16f, 16f, paint)
        paint.color = Color.parseColor("#305CDE")
        canvas.drawRoundRect(playerX, playerTop, playerX + paddleWidth, playerTop + paddleHeight, 16f, 16f, paint)
    }
}
