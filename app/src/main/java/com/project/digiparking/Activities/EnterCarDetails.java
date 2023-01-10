package com.project.digiparking.Activities;

import static com.project.digiparking.DBmain.TABLENAME;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.digiparking.Authentication.SignUpActivity;
import com.project.digiparking.DBmain;
import com.project.digiparking.MainActivity;
import com.project.digiparking.R;

import java.io.ByteArrayOutputStream;

public class EnterCarDetails extends AppCompatActivity {
    EditText EdCar,EdType,EdColor,EdPlate;
    ImageView imageV;
    AppCompatButton submitBtn,uploadBtn;
    public static final int REQUEST_CODE_IMAGE=101;
    Uri imageUri;
    boolean isImageAdded= false;
    DBmain dBmain;
    int id = 0;
    SQLiteDatabase sqLiteDatabase;
    String[]storagePermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_car_details);
        dBmain = new DBmain(this);

        EdCar = findViewById(R.id.car_name);
        EdType = findViewById(R.id.car_type);
        EdColor = findViewById(R.id.car_color);
        EdPlate = findViewById(R.id.car_plate);
        imageV = findViewById(R.id.car_image);
        submitBtn = findViewById(R.id.submit_btn);
        uploadBtn = findViewById(R.id.car_btn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_CODE_IMAGE);

            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        SharedPreferences preference= getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        String FirstTime= preference.getString("FirstTimeInstall","");
        if (FirstTime.equals("Yes")){
            Intent intent=new Intent(   EnterCarDetails.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else {
            SharedPreferences.Editor editor= preference.edit();
            editor.putString("FirstTimeInstall","Yes");
            editor.apply();


        }
    }

    private void insertData() {
        ContentValues  cv = new ContentValues();
        cv.put("avatar",ImageViewToByte(imageV));
        cv.put("name",EdCar.getText().toString());
        cv.put("plate",EdPlate.getText().toString());
        cv.put("type",EdType.getText().toString());
        cv.put("color",EdColor.getText().toString());
        sqLiteDatabase = dBmain.getWritableDatabase();
        Long recinsert = sqLiteDatabase.insert(TABLENAME,null,cv);
        if (recinsert!= null){
            Toast.makeText(EnterCarDetails.this,"Details entered successfully",Toast.LENGTH_SHORT).show();
            imageV.setImageResource(R.drawable.car_24);
            EdCar.setText("");
            EdPlate.setText("");
            EdType.setText("");
            EdColor.setText("");
            startActivity(new Intent(EnterCarDetails.this, MainActivity.class));
            finish();

        }
    }
    private boolean checkStoragePermission(){
        boolean result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)==(PackageManager.PERMISSION_GRANTED);
        return result;

    }

    private byte[] ImageViewToByte(ImageView imageV) {
        Bitmap bitmap = ((BitmapDrawable)imageV.getDrawable()).getBitmap();
        ByteArrayOutputStream  stream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,stream);
        byte[]bytes= stream.toByteArray();
        return bytes;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && data != null) {
            imageUri = data.getData();
            isImageAdded = true;
            imageV.setImageURI(imageUri);

        }
    }
}