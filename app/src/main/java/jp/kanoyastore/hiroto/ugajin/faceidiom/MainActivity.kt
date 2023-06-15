package jp.kanoyastore.hiroto.ugajin.faceidiom

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.Toast
import jp.kanoyastore.hiroto.ugajin.faceidiom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // 追加

    private lateinit var mediaPlayer1: MediaPlayer
    private lateinit var mediaPlayer2: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 追加
        val view = binding.root // 追加
        setContentView(view) // 変更

        val questionArray = arrayOf(
            "　◯色をうかがう", "厚◯無恥", "何食わぬ◯", "浮かぬ◯",
            "竜◯蛇尾", "　◯角を現す", "　◯隠して尻隠さず", "黒い◯のネズミ",
            "壁に◯あり障子に目あり", "　◯寄りの話し", "馬◯東風", "聞き◯を立てる",
            "　◯結いの亭主", "白◯三千丈", "間一◯", "後ろ◯を引かれる",
            "鬼の◯にも涙", "　◯が点になる", "　◯からウロコが落ちる", "　◯が飛び出る",
            "　◯歌まじり", "　◯息があらい", "　◯を明かす", "　◯っ柱が強い",
            "　◯は災いの元", "開いた◯が塞がらない", "　◯裏を合わせる", "憎まれ◯を叩く",
            "　◯が回らない", "鬼の◯を取ったような", "雁◯を揃える", "小◯を傾げる"
        )

        val answerArray = arrayOf("顔色をうかがう", "厚顔無恥", "何食わぬ顔", "浮かぬ顔",
                "竜頭蛇尾", "頭角を現す", "頭隠して尻隠さず", "黒い頭のネズミ",
                "壁に耳あり障子に目あり", "耳寄りの話し", "馬耳東風", "聞き耳を立てる",
                "髪結いの亭主", "白髪三千丈", "間一髪", "後ろ髪を引かれる",
                "鬼の目にも涙", "目が点になる", "目からウロコが落ちる", "目が飛び出る",
                "鼻歌まじり", "鼻息があらい", "鼻を明かす", "鼻っ柱が強い",
                "口は災いの元", "開いた口が塞がらない", "口裏を合わせる", "憎まれ口を叩く",
                "首が回らない", "鬼の首を取ったような", "雁首を揃える", "小首を傾げる"
        )

        val shuffledArray = questionArray.toMutableList().apply { shuffle() }.toTypedArray()

        var currentIndex = 0

        binding.textView.text = shuffledArray[0]

        mediaPlayer1 = MediaPlayer.create(this, R.raw.nice)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.boo)

        val message = "この部位はリスナーが設定されていません"
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)

        binding.imageView.setImageResource(R.drawable.ladyface)

        var touchEnabled = true

        binding.imageView.setOnTouchListener { view, event ->

            val width = binding.imageView.width
            val height = binding.imageView.height
            val x = event.x
            val y = event.y

            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    Log.d("face", "$x, $y")
                    val currentItem = shuffledArray[currentIndex] // 現在表示されている要素
                    val originalIndex = questionArray.indexOf(currentItem) // 元のquestionArrayでのインデックス

                    mediaPlayer1.reset()
                    mediaPlayer1 = MediaPlayer.create(this, R.raw.nice)

                    mediaPlayer2.reset()
                    mediaPlayer2 = MediaPlayer.create(this, R.raw.boo)

                    // タッチが開始された時の処理
                    if (touchEnabled) {
                        if ((x <= 0.139 * width || x >= 0.854 * width) && y >= height / 2 - width / 2 && y <= height / 2 + width / 2) {
                            if (originalIndex / 4 == 0) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                        if ((x > 0.139 * width && x < 0.854 * width) && (y >= height / 2 - width / 2 && y <= height / 2 - 0.177 * width)) {
                            if (originalIndex / 4 == 1) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                        if ((0.645 * width < x && x < 0.775 * width) && (0.801 * width <= y && y <= 0.963 * width)) {
                            if (originalIndex / 4 == 2) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                        if (((0.139 * width < x && x <= 0.259 * width) && (height / 2 - 0.177 * width < y && y < height / 2 + width / 2))
                            || ((0.645 * width <= x && x < 0.854 * width) && (height / 2 - 0.177 * width < y && y < height / 2 + width / 2))
                            && !((0.645 * width < x && x < 0.775 * width) && (0.801 * width <= y && y <= 0.963 * width))
                        ) {
                            if (originalIndex / 4 == 3) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                        if ((0.259 * width < x && x < 0.645 * width) && (height / 2 - 0.177 * width < y && y <= height / 2 - 0.073 * width)) {
                            if (originalIndex / 4 == 4) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                        if ((0.259 * width < x && x < 0.645 * width) && (height / 2 - 0.073 * width < y && y <= height / 2 + 0.044 * width)) {
                            if (originalIndex / 4 == 5) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                        if ((0.259 * width < x && x < 0.645 * width) && (height / 2 + 0.044 * width < y && y <= height / 2 + 0.221 * width)) {
                            if (originalIndex / 4 == 6) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                        if ((0.259 * width < x && x < 0.645 * width) && (height / 2 + 0.221 * width < y && y <= height / 2 + width / 2)) {
                            if (originalIndex / 4 == 7) {
                                touchEnabled = false
                                mediaPlayer1.start()
                                binding.textView.text = answerArray[originalIndex]
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 2000)
                            } else {
                                touchEnabled = false
                                mediaPlayer2.start()
                                currentIndex += 1
                                Handler(Looper.getMainLooper()).postDelayed({
                                    // 2秒後の処理を記述
                                    binding.textView.text = shuffledArray[currentIndex]
                                    touchEnabled = true
                                }, 1000)
                            }
                        }
                    }
                }
                MotionEvent.ACTION_MOVE -> {
                    // タッチが移動した時の処理
                }
                MotionEvent.ACTION_UP -> {
                    // タッチが終了した時の処理
                    if (x <= width/2 && x >= -width/2) {
                        // 画像の特定の領域をタップした場合の処理
                    }
                }
            }
            true
        }
    }
}