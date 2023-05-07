package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
            {"Doctor name: Ajit Saste", "Hospital Address:Panvel","Exp:Syrs", "Mobile No: 9898345678","600"},
            {"Doctor name: Naya", "Hospital Address:Solapur","Exp:Syrs", "Mobile No: 7058180061","300"},
            {"Doctor name: jai", "Hospital Address:Pune","Exp:Syrs", "Mobile No: 9356861763","400"},
            {"Doctor name: Shyla", "Hospital Address:Latur","Exp:Syrs", "Mobile No: 9422652796","500"},
            {"Doctor name: Amar", "Hospital Address:Nagpur","Exp:Syrs", "Mobile No: 9834637406","600"}
    };
    private String[][] doctor_details2 ={
            {"Doctor name: Ajay", "Hospital Address:Nashik","Exp:Syrs", "Mobile No: 92847542115","500"},
            {"Doctor name: Ananaya", "Hospital Address:Thane","Exp:Syrs", "Mobile No: 7774057227","600"},
            {"Doctor name: Tenzin", "Hospital Address:Jalgaon","Exp:Syrs", "Mobile No: 9573752033","300"},
            {"Doctor name: Aditi", "Hospital Address:Amravati","Exp:Syrs", "Mobile No: 9021551145","600"},
            {"Doctor name: Anjali", "Hospital Address:Kolhapur","Exp:Syrs", "Mobile No: 9954725899","700"}
    };
    private String[][] doctor_details3 ={
            {"Doctor name: Dhruv", "Hospital Address:Akola","Exp:Syrs", "Mobile No: 9421485800","400"},
            {"Doctor name: Ananya", "Hospital Address:Malagaon","Exp:Syrs", "Mobile No: 8850053468","800"},
            {"Doctor name: Jaya", "Hospital Address:Dhule","Exp:Syrs", "Mobile No: 9960438622","200"},
            {"Doctor name: Agastya", "Hospital Address:Ahmednagar","Exp:Syrs", "Mobile No: 992274899","100"},
            {"Doctor name: Ishaan", "Hospital Address:Parbhani","Exp:Syrs", "Mobile No: 9960094954","300"}
    }; private String[][] doctor_details4 ={
            {"Doctor name: Divya", "Hospital Address:Jalna","Exp:Syrs", "Mobile No: 985088146","600"},
            {"Doctor name: Avan", "Hospital Address:Beed","Exp:Syrs", "Mobile No: 73456784567","500"},
            {"Doctor name: Deven", "Hospital Address:Barshi","Exp:Syrs", "Mobile No: 9767345678","400"},
            {"Doctor name: Jasleen", "Hospital Address:Satara","Exp:Syrs", "Mobile No: 89458345678","200"},
            {"Doctor name: Ishani", "Hospital Address:Udgir","Exp:Syrs", "Mobile No: 9284542115","300"}
    };
    private String[][] doctor_details5 ={
            {"Doctor name: Ashwin", "Hospital Address:Wardha","Exp:Syrs", "Mobile No: 9960880573","800"},
            {"Doctor name: Salina", "Hospital Address:Gondia","Exp:Syrs", "Mobile No: 706618783","500"},
            {"Doctor name: Raghav", "Hospital Address:Yavatmal","Exp:Syrs", "Mobile No: 8862060791","400"},
            {"Doctor name: Varun", "Hospital Address:Bhusawal","Exp:Syrs", "Mobile No: 9767433120","1000"},
            {"Doctor name: Vivan", "Hospital Address:Raigad","Exp:Syrs", "Mobile No: 9422643410","900"}
    };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgron")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Con Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.mulit_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);


       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               Intent it = new Intent(DoctorDetailsActivity.this,BookappoinmentActivity.class);
               it.putExtra("text1",title);
               it.putExtra("text2", doctor_details[i][0]);
               it.putExtra("text3", doctor_details[i][1]);
               it.putExtra("text4", doctor_details[i][3]);
               it.putExtra("text5", doctor_details[i][4]);
               startActivity(it);
           }
       });
    }


}