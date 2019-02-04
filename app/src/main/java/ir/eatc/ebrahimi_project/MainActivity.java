package ir.eatc.ebrahimi_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btngotoshahr,btngotoostan;
    Spinner spostan,spshahr;
    TextView txtshahr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtshahr=(TextView)findViewById(R.id.selectedCity);
        btngotoostan=(Button)findViewById(R.id.btnGoToProvince);
        btngotoshahr=(Button)findViewById(R.id.btnGoToCity);
        spostan=(Spinner)findViewById(R.id.spProvince);
        spshahr=(Spinner)findViewById(R.id.spCity);
        String[] provinces=getResources().getStringArray(R.array.arrayProvinces);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,provinces);
        spostan.setAdapter(adapter);

        btngotoshahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,CitiesActivity.class);
                i.putExtra("ostan",(String)spostan.getSelectedItem());
                startActivityForResult(i,1);
            }
        });

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        String shahr=data.getStringExtra("shahr");
        txtshahr.setText("شما شهر "+shahr+" را انتخاب نموده اید");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mnu=getMenuInflater();
        mnu.inflate(R.menu.ebrahimi_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.aboutEbrahimi:
                Toast.makeText(MainActivity.this,"تهیه شده توسط: قربان ابراهیمی",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tamasEbrahimi:
                Toast.makeText(MainActivity.this,"شماره تماس: 09143134695" ,Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
