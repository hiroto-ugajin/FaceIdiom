package jp.kanoyastore.hiroto.ugajin.faceidiom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import jp.kanoyastore.hiroto.ugajin.faceidiom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // 追加

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // 追加
        val view = binding.root // 追加
        setContentView(view) // 変更

        binding.imageView.setImageResource(R.drawable.ladyface)

        binding.imageView.setOnTouchListener { view, event ->

            val width = binding.imageView.width
            val height = binding.imageView.height
            val x = event.x
            val y = event.y

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // タッチが開始された時の処理
                    Log.d("face", "$x, $y")
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