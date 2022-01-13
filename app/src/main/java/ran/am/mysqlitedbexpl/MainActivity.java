package ran.am.mysqlitedbexpl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ename,eloc;
    String sname, slocation;
    DbHplr dbHplr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename=findViewById(R.id.editTextTextPersonName);
        eloc=findViewById(R.id.editTextTextPersonName2);
        dbHplr=new DbHplr(this);
    }

    public void savetodb(View view) {
        sname=ename.getText().toString();
        slocation=eloc.getText().toString();
        Toast.makeText(getApplicationContext(), sname+"\n"+slocation, Toast.LENGTH_SHORT).show();

        dbHplr.savedataa(sname,slocation);
        Toast.makeText(getApplicationContext(), "Data saved successfully!!", Toast.LENGTH_SHORT).show();

    }
}