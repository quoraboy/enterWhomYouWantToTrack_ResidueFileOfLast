package com.example.last;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.last.Sqlitedatabasecode.DatabaseHandler;
import com.example.last.Sqlitedatabasecode.otheruserinfo;


public class entertrackpeople extends Fragment {
TextInputLayout otherusername;
TextInputLayout otheruserphoneno;
TextInputLayout otheruserUID;
String name;
String phone;
String UID;
Button submit;
   public static DatabaseHandler db;
@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.entertrackpeople, container, false);
    db = new DatabaseHandler(getContext());


    otheruserphoneno =v.findViewById(R.id.otherusernumber);
     otherusername=v.findViewById(R.id.otherusername);
    otheruserUID=v.findViewById(R.id.UID);
     submit=v.findViewById(R.id.submitotheruser);


     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

                         adduser();
//             //            SharedPreferences sharedPreferencestrack=getActivity().getSharedPreferences("Trackpeople", Context.MODE_PRIVATE);
//             SharedPreferences.Editor editortrack=sharedPreferencestrack.edit();
//             editortrack.putString("OtherUserName",name);
//             editortrack.putString("OtherUserID",phone);
//             editortrack.commit();

         }
     });
return v;
    }

    private void adduser() {
          otheruserphoneno.clearFocus();
          otherusername.clearFocus();
          otheruserUID.clearFocus();
        name =otherusername.getEditText().getText().toString().trim();
//                getText().toString().trim();
        phone = otheruserphoneno.getEditText().getText().toString().trim();
       UID =otheruserUID.getEditText().getText().toString().trim();
        if(name.isEmpty())
       {
            otherusername.setError("Name can't be empty");
            otherusername.requestFocus();
          return;
       }
        else otherusername.setError("");
       if(phone.isEmpty())
       {
           otheruserphoneno.setError("You must enter phone number of user to track location");
           otheruserphoneno.requestFocus();
       return;
       }
       else otheruserphoneno.setError("");
       if(UID.isEmpty())
       {
           otheruserUID.setError("You must enter UID of user to track location");
           otheruserUID.requestFocus();
           return;
       }
       else otheruserUID.setError("");
         Boolean t= db.addotheruser(new otheruserinfo(name, phone,UID));
        if (!t)
        {
            Toast.makeText(getContext(), "Data not saved", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(), "Data saved", Toast.LENGTH_SHORT).show();

        otheruserUID.getEditText().setText("");
//                setText("");
        otherusername.getEditText().setText("");
        otheruserphoneno.getEditText().setText("");
        }



    }

}
