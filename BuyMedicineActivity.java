package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
  private String[][] packages={
          {"lisinopril (Zestril)","","","","50"},
          {"levothyroxine (Synthroid)","","","","350"},
          {"atorvastatin (Lipitor)","","","","480"},
          {"metformin (Glucophage)","","","","539"},
          {"simvastatin (Zocor) ","","","","30"},
          {"omeprazole (Prilosec) ","","","","50"},
          {"amlodipine (Norvasc) ","","","","100"},
          {"metoprolol (Lopressor) ","","","","40"},
          {"acetaminophen plus hydrocodone ","","","","350"},
  };
  private String[] packages_details={
    "Lisinopril oral tablet is a generic prescription drug\n"+
            " It’s approved by the Food and Drug Administration (FDA) to:\n"+
            "Reduce the risk in adults for dying after a heart attack.\n"+
            " Lisinopril is taken with other drugs for this use.",
            "Levothyroxine oral tablet is available as brand-name drugs.\n"+
                    "It’s also available in a generic form. Brand names: Levoxyl, Synthroid, and Unithroid.\n"+
            "Levothyroxine comes in three forms: an oral tablet, an oral capsule, and an injectable solution.",
          "Atorvastatin oral tablet is available as both a generic drug and a brand-name drug. Brand name: Lipitor.\n"+
                  "Atorvastatin only comes in the form of a tablet you take by mouth.\n",
          "Metformin is a medication people with type 2 diabetes take to control blood sugar levels.\n"+
                  "Although most people tolerate metformin well, some experience side effects including diarrhea, nausea, and vomiting.\n",
          "Zocor is a brand-name prescription medication. It’s FDA-approved to:\n" +
                  "lower high cholesterol (along with a healthy diet) in adults\n"+
                  "lower the risk of cardiovascular problems and death in adults\n",
          "Omeprazole oral capsule is available as a generic drug. It doesn’t have a brand-name version.\n"+
                  "Omeprazole also comes as a liquid suspension you take by mouth.\n",
          "Amlodipine oral tablet is available as a brand-name drug and a generic drug. Brand name: Norvasc.\n"+
                  "Amlodipine comes only as a tablet you take by mouth.\n",
          "Metoprolol oral tablet is available as generic drugs and as brand-name drugs. Brand names: Lopressor and Toprol XL.\n"+
                  "Metoprolol comes as immediate-release and extended-release tablets, and an extended-release capsule.\n",
          "Acetaminophen-hydrocodone oral tablet is available as a generic drug and a brand-name drug. Brand names: Norco.\n"+
                  "Acetaminophen-hydrocodone comes as an oral tablet and an oral solution."
  };
  HashMap<String ,String >item;
  ArrayList list;
  SimpleAdapter sa;
  ListView lst;
  Button btnBack, btnGOToCart;

   // @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGOToCart = findViewById(R.id.buttonBMGotoCard);

        btnGOToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0; i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.mulit_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}