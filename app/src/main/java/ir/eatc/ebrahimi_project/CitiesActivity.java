package ir.eatc.ebrahimi_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CitiesActivity extends AppCompatActivity {
    TextView txtprovince;
    String province;
    Spinner spshahr;
    Button btnReturnProvince;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cities);
        Button btnReturnProvince=(Button)findViewById(R.id.btnGoToProvince);

        TextView txtprovince = (TextView) findViewById(R.id.txtostan);
            Bundle extras = getIntent().getExtras();
            String province = extras.getString("ostan");
            txtprovince.setText("یکی از شهرهای استان " + province + " را انتخاب نمائید");

            if (province.equals("آذربایجان شرقی")){
                spshahr=(Spinner)findViewById(R.id.spCity);
                String[] provinces=getResources().getStringArray(R.array.arrayEastAzarbaijan);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,provinces);
                spshahr.setAdapter(adapter);
            }

       else if (province.equals("فارس")){
            spshahr=(Spinner)findViewById(R.id.spCity);
            String[] provinces=getResources().getStringArray(R.array.arrayFars);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,provinces);
            spshahr.setAdapter(adapter);
        }


        btnReturnProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("shahr",(String)spshahr.getSelectedItem());
                setResult(1,i);
                finish();
            }
        });
    }
}
