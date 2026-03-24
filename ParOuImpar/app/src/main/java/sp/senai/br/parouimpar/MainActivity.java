package sp.senai.br.parouimpar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout tela;
    RadioButton rdPar, rdImpar, zero, um, dois, tres, quatro, cinco;
    ImageView imgVc, imgRobo;
    TextView txtResultVc, txtResultRobo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tela = findViewById(R.id.tela);
        imgRobo = findViewById(R.id.imgRobo);
        imgVc = findViewById(R.id.imgVc);
        txtResultRobo = findViewById(R.id.txtResultRobo);
        txtResultVc = findViewById(R.id.txtResultVc);
        rdPar = findViewById(R.id.rdPar);
        rdImpar = findViewById(R.id.rdImpar);
        zero = findViewById(R.id.zero);
        um = findViewById(R.id.um);
        dois = findViewById(R.id.dois);
        tres = findViewById(R.id.tres);
        quatro = findViewById(R.id.quatro);
        cinco = findViewById(R.id.cinco);
        rdPar.setChecked(true);
        zero.setChecked(true);

    }

    int pontoVc = 0;
    int pontoRobo = 0;

    public void Jogar(View v){
        boolean escolhaPI = true;
        if(rdPar.isChecked()){
            Toast.makeText(this, "Você escolheu par", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "você escolheu impar", Toast.LENGTH_SHORT).show();
            escolhaPI = false;
        }

        int escolhaNum = 0;
        int num0 = 0;
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;

        if(zero.isChecked()){
            escolhaNum = num0;
            imgVc.setImageResource(R.drawable.zero);
        } else if (um.isChecked()) {
            escolhaNum = num1;
            imgVc.setImageResource(R.drawable.um);
        } else if (dois.isChecked()) {
            escolhaNum = num2;
            imgVc.setImageResource(R.drawable.dois);
        } else if (tres.isChecked()) {
            escolhaNum = num3;
            imgVc.setImageResource(R.drawable.tres);
        } else if (quatro.isChecked()) {
            escolhaNum = num4;
            imgVc.setImageResource(R.drawable.quatro);
        } else if (cinco.isChecked()) {
            escolhaNum = num5;
            imgVc.setImageResource(R.drawable.cinco);
        }

        int sorteado = (int) (Math.random() * 6);

        if(sorteado == 0){
            imgRobo.setImageResource(R.drawable.zero);
        } else if (sorteado == 1) {
            imgRobo.setImageResource(R.drawable.um);
        } else if (sorteado == 2) {
            imgRobo.setImageResource(R.drawable.dois);
        } else if (sorteado == 3) {
            imgRobo.setImageResource(R.drawable.tres);
        } else if (sorteado == 4) {
            imgRobo.setImageResource(R.drawable.quatro);
        } else if (sorteado == 5) {
            imgRobo.setImageResource(R.drawable.cinco);
        }

        if((escolhaNum + sorteado) % 2 == 0){
            if(escolhaPI){
                pontoVc++;
                Toast.makeText(this, "Você ganhou!", Toast.LENGTH_SHORT).show();
            } else {
                pontoRobo++;
                Toast.makeText(this, "Robô ganhou!", Toast.LENGTH_SHORT).show();
            }
        } else {
            if(!escolhaPI){
                pontoVc++;
                Toast.makeText(this, "Você ganhou!", Toast.LENGTH_SHORT).show();
            } else {
                pontoRobo++;
                Toast.makeText(this, "Robô ganhou!", Toast.LENGTH_SHORT).show();
            }
        }

        txtResultVc.setText("Você: " + pontoVc);
        txtResultRobo.setText("Robô: " + pontoRobo);

    }

    public void Limpar(View v){
        pontoVc = 0;
        pontoRobo = 0;
        txtResultVc.setText("Você: " + pontoVc);
        txtResultRobo.setText("Robô: " + pontoRobo);
    }
}