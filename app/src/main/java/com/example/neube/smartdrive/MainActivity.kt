package com.example.neube.smartdrive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    public var LOG = Logger.getLogger(this.javaClass.name)

    val db = FirebaseFirestore.getInstance()
    var janela1 = db.collection("smartmodel").document("motores")
    val pararRef = db.collection("smartmodel").document("motores")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        janela1.whereEqualTo("fcmotordoisa", 1)
                Log.i(LOG.toString(), "a 9410 9410 9410")
                fecharJanela1.background = getDrawable(R.mipmap.jesqpretae)
                fecharJanela1.isEnabled = false
                pararButton.isEnabled = false
                Log.i(LOG.toString(), "b 9411 9411 9411")
        janela1.whereEqualTo("fcmotordoisa", 0)
                fecharJanela1.isEnabled = true
                pararButton.isEnabled = true
                Log.i(LOG.toString(), "c 9412 9412 9412")


        pararRef.whereEqualTo("PararUm", 1)
            if (fecharJanela1.isEnabled) {
                Log.i(LOG.toString(),"c 9413 9413 9413")
                fecharJanela1.background=getDrawable(R.mipmap.janelafrentee)
                pararButton.background=getDrawable(R.mipmap.stopbb)
                Log.i(LOG.toString(),"c 9414 9414 9414")
            }
        pararRef.whereEqualTo("PararUm", 0)
             if (fecharJanela1.isEnabled) {
                pararButton.background = getDrawable(R.mipmap.stopaa)
                fecharJanela1.background = getDrawable(R.mipmap.jesqpretae)
                Log.i(LOG.toString(), "c 9415 9415 9415")
            }

        fecharJanela1.setOnClickListener {

            pararRef.whereEqualTo("state", 1)
                var data = hashMapOf("DirecaoUm" to 1)

                var data2 = hashMapOf("PararUm" to 0)

                db.collection("smartmodel").document("motores").set(data, SetOptions.merge())
                db.collection("smartmodel").document("motores").set(data2, SetOptions.merge())
        }

        pararButton.setOnClickListener {

            var data3 = hashMapOf("PararUm" to 1
            )
            db.collection("smartmodel").document("motores").set(data3, SetOptions.merge())

            Log.i(LOG.toString(), "c 9416 9416 9416")

            pararButton.background = getDrawable(R.mipmap.stopbb)
            Log.i(LOG.toString(), "g 9417 9417 9417")

        }
    }
}

private fun DocumentReference.whereEqualTo(s: String,s1: Int) {

}