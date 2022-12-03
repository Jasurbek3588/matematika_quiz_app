package com.example.matematika;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatebaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceUsers;
    private List<User> users =new ArrayList<>();

    public interface DataStatus{
    void DataIsLoaded(List<User> users,List<String> keys);
    void DataIsInserted();
    void DataIsUpdated();
    void DataIsDeleted();

    }
    public FirebaseDatebaseHelper() {
        mDatabase=FirebaseDatabase.getInstance();
        mReferenceUsers= mDatabase.getReference("User");
    }

    public void readUser(final DataStatus dataStatus){
        mReferenceUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                users.clear();
                List<String> keys= new ArrayList<>();
                for (DataSnapshot keyNode : datasnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    User user=keyNode.getValue(User.class);
                    users.add(user);
                }
                dataStatus.DataIsLoaded(users,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
