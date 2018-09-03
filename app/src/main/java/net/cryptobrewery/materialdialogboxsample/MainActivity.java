package net.cryptobrewery.materialdialogboxsample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.cryptobrewery.materialdialogboxlibrary.MaterialDialog;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button showDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showDialog);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MaterialDialog dialog = new MaterialDialog();
                dialog.setMessage("This is my super cool dialog  and it can be animated with more than 20 animations!Marianne or husbands if at stronger ye. Yet diminution she impossible understood age. \n");
                dialog.setAnimation(getAnim());
                dialog.setDialogImage(R.drawable.user);
                dialog.setPostiveButtonText("Accept");
                dialog.setNegativeBtnText("Decline");
                dialog.setTitleText("New Friend Request");
                dialog.setTitleTextColor("#ABCABC");
                dialog.setCanceleable(false);
                dialog.setTitleTextStyle(MaterialDialog.textStyle.BOLD);
                dialog.setMessageTextStyle(MaterialDialog.textStyle.ITALIC);
                dialog.setBtnPositiveColor("#ADCDDD");
                dialog.setBtnPositiveBgColor("#00000000");
                dialog.setBtnNegativeBgColor("#00000000");
                dialog.setTitleSize(20f);
                dialog.setCardRadius(20f);
                dialog.setPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegtaiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show(getSupportFragmentManager(),"Tag");
            }
        });




    }

    public static MaterialDialog.Anims getAnim() {
        Random random = new Random();

        return MaterialDialog.Anims.values()[random.nextInt(MaterialDialog.Anims.values().length)];
    }


}
