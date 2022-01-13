package ran.am.mysqlitedbexpl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ename,eloc,ena2;
    String sname, slocation,sna2;
    TextView tv;
    DbHplr dbHplr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ename=findViewById(R.id.editTextTextPersonName);
        eloc=findViewById(R.id.editTextTextPersonName2);
        ena2=findViewById(R.id.idname);
        tv=findViewById(R.id.tv);
        dbHplr=new DbHplr(this);
    }

    public void savetodb(View view) {
        sname=ename.getText().toString();
        slocation=eloc.getText().toString();
        Toast.makeText(getApplicationContext(), sname+"\n"+slocation, Toast.LENGTH_SHORT).show();

        dbHplr.savedataa(sname,slocation);
        Toast.makeText(getApplicationContext(), "Data saved successfully!!", Toast.LENGTH_SHORT).show();

    }

    public void retr(View view) {
        sna2=ena2.getText().toString();
        String dbloc = dbHplr.retrvloc(sna2);
        tv.setText(dbloc);
    }
}