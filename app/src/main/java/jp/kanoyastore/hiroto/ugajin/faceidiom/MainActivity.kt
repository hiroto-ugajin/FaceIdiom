package jp.kanoyastore.hiroto.ugajin.faceidiom

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
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

        val shuffledArray = questionArray.toMutableList().apply { shuffle() }.toTypedArray()

        var currentIndex = 0

        binding.textView.text = shuffledArray[0]

        mediaPlayer1 = MediaPlayer.create(this, R.raw.nice)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.boo)

        binding.imageView.setImageResource(R.drawable.ladyface)

        binding.imageView.setOnTouchListener { view, event ->

            val width = binding.imageView.width
            val height = binding.imageView.height
            val x = event.x
            val y = event.y
//            val centerX = binding.imageView.width / 2 // X座標の中心点
//            val centerY = binding.imageView.height / 2 // Y座標の中心点


            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    Log.d("face", "$x, $y")
                    val currentItem = shuffledArray[currentIndex] // 現在表示されている要素
                    val originalIndex = questionArray.indexOf(currentItem) // 元のquestionArrayでのインデックス
                    // タッチが開始された時の処理
                    if ((x <= 0.139*width || x >= 0.854*width) && y >= height/2 - width/2 && y <= height/2 + width/2) {
                        if (originalIndex/4 == 0) {
                            mediaPlayer1.start()
//                            Log.d("face", "$x, $y")
//                            Log.d("face", "$width, $height")
//                            Log.d("face", "$centerX, $centerY")
                            currentIndex += 1
                            binding.textView.text = shuffledArray[currentIndex]
                        }
                        else {
                            mediaPlayer2.start()
                            currentIndex += 1
                            binding.textView.text = shuffledArray[currentIndex]
                        }
                    }
                    if ((x > 0.139*width && x < 0.854*width) && (y >= height/2 - width/2 && y <= height/2 - 0.177*width))
                    {   if (originalIndex/4 == 1) {
                        mediaPlayer1.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    else {
                        mediaPlayer2.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    }
                    if (( 0.645*width < x && x < 0.775*width) && ( 0.801*width <= y && y <= 0.963*width ))
                    {   if (originalIndex/4 == 2) {
                        mediaPlayer1.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    else {
                        mediaPlayer2.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    }
                    if ((( 0.139*width < x && x <= 0.259*width) && (height/2 - 0.177*width < y && y < height/2 + width/2))
                                || (( 0.645*width <= x && x < 0.854*width) && (height/2 - 0.177*width < y && y < height/2 + width/2))
                        && !(( 0.645*width < x && x < 0.775*width) && ( 0.801*width <= y && y <= 0.963*width  )))
                    {   if (originalIndex/4 == 3) {
                        mediaPlayer1.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    else {
                        mediaPlayer2.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    }
                    if ((0.259*width < x && x < 0.645*width) && (height/2 - 0.177*width < y && y <= height/2 - 0.073*width))
                    {   if (originalIndex/4 == 4) {
                        mediaPlayer1.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    else {
                        mediaPlayer2.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    }
                    if ((0.259*width < x && x < 0.645*width) && (height/2 - 0.073*width < y && y <= height/2 + 0.044*width))
                    {   if (originalIndex/4 == 5) {
                        mediaPlayer1.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    else {
                        mediaPlayer2.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    }
                    if ((0.259*width < x && x < 0.645*width) && (height/2 + 0.044*width < y && y <= height/2 + 0.221*width))
                    {   if (originalIndex/4 == 6) {
                        mediaPlayer1.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    else {
                        mediaPlayer2.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    }
                    if ((0.259*width < x && x < 0.645*width) && (height/2 + 0.221*width < y && y <= height/2 + width/2))
                    {   if (originalIndex/4 == 7) {
                        mediaPlayer1.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    else {
                        mediaPlayer2.start()
                        currentIndex += 1
                        binding.textView.text = shuffledArray[currentIndex]
                    }
                    }
                    else {
                        Log.d("face", "リスナーが設定されていません")
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