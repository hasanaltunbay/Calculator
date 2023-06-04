package com.infoxxx.hesapmakine


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSayiTik(view: View){
        if(yeniOperator){
            sayiGoster.setText("")
        }
        yeniOperator=false
        var btnSec=view as Button
        var btnTikDeger:String=sayiGoster.text.toString()
        when(btnSec.id){
            button0.id->{
                btnTikDeger+="0"
            }
            button1.id->{
                btnTikDeger+="1"
            }
            button2.id->{
                btnTikDeger+="2"
            }
            button3.id->{
                btnTikDeger+="3"
            }
            button4.id->{
                btnTikDeger+="4"
            }
            button5.id->{
                btnTikDeger+="5"
            }
            button6.id->{
                btnTikDeger+="6"
            }
            button7.id->{
                btnTikDeger+="7"
            }
            button8.id->{
                btnTikDeger+="8"
            }
            button9.id->{
                btnTikDeger+="9"
            }
            buttonNokta.id->{
                btnTikDeger+="."
            }
        }
        sayiGoster.setText(btnTikDeger)
    }
    var operator="*"
    var eskiSayi=""
    var yeniOperator=true
    fun btnOpTik(view: View){
        var btnSec=view as Button
        when(btnSec.id){
            buttonBolme.id->{
                operator="/"
            }
            buttonCarp.id->{
                operator="X"
            }
            buttonCıkar.id->{
                operator="-"
            }
            buttonTopla.id->{
                operator="+"
            }
        }
        eskiSayi=sayiGoster.text.toString()
        yeniOperator=true
    }
    fun btnEsittirTik(view: View){
        var yeniSayi=sayiGoster.text.toString()
        var sonucSayisi:Double?=null
        when(operator){
            "/"->{
                sonucSayisi=eskiSayi.toDouble()/yeniSayi.toDouble()
            }
            "X"->{
                sonucSayisi=eskiSayi.toDouble()*yeniSayi.toDouble()
            }
            "-"->{
                sonucSayisi=eskiSayi.toDouble()-yeniSayi.toDouble()
            }
            "+"->{
                sonucSayisi=eskiSayi.toDouble()+yeniSayi.toDouble()
            }
        }
        sayiGoster.setText(sonucSayisi.toString())
        yeniOperator=true
    }
    fun btnSilTik(view: View){
        sayiGoster.setText("0")
        yeniOperator=true
    }
    fun btnYuzdeTik(view: View){
        var sayi:Double=sayiGoster.text.toString().toDouble()/100
        sayiGoster.setText(sayi.toString())
        yeniOperator=true
    }

    fun btnSayiFonk(view: View){
        yeniOperator=true
        var btnSec=view as Button
        yeniOperator=true
        when(btnSec.id){
            buttonKareAl.id->{
                var sayi:Double=sayiGoster.text.toString().toDouble()
                var x=sayi*sayi
                sayiGoster.setText(x.toString())
                yeniOperator=true
            }
            buttonKokX.id->{
                var sayi:Double=sayiGoster.text.toString().toDouble()
                var x=Math.sqrt(sayi)
                sayiGoster.setText(x.toString())
                yeniOperator=true
                eskiSayi=sayiGoster.text.toString()
                yeniOperator=true
            }
            buttonXKup.id->{
                var sayi=sayiGoster.text.toString().toDouble()
                var sonuc=sayi*sayi*sayi
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            buttonLn.id->{
                var sayi=sayiGoster.text.toString()
                var sonuc=Math.log(sayi.toDouble())
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            buttonLog.id->{
                var sayi=sayiGoster.text.toString()
                var sonuc=Math.log10(sayi.toDouble())
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            buttonSin.id->{
                var sayi=sayiGoster.text.toString()
                var sonuc=Math.sin(sayi.toDouble())
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            buttonCos.id->{
                var sayi=sayiGoster.text.toString()
                var sonuc=Math.cos(sayi.toDouble())
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            buttonTan.id->{
                var sayi=sayiGoster.text.toString()
                var sonuc=Math.tan(sayi.toDouble())
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            buttonCot.id->{
                var sayi=sayiGoster.text.toString()
                var sonuc=Math.tan(90-sayi.toDouble())
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            button1BoluX.id->{
                var sayi=sayiGoster.text.toString().toDouble()
                var sonuc:Double=1/sayi
                sayiGoster.setText(sonuc.toString())
                yeniOperator=true
            }
            buttonSil.id->{
                val uzunluk=sayiGoster.length()
                if(uzunluk>0){
                    sayiGoster.text= sayiGoster.text.subSequence(0,uzunluk-1) as Editable?
                    }
                yeniOperator=true
            }
            buttonFact.id->{
                fun facto(x: Int): Int {
                    if(x==0 || x==1){
                        return 1
                    }else{
                       return x*facto(x-1)
                    }
                }
                var sayi=sayiGoster.text.toString().toInt()
                var sonuc=facto(sayi)
                sayiGoster.setText(sonuc.toString())

            }


        }

    }



}