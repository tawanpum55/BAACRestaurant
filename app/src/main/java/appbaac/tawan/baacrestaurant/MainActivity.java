package appbaac.tawan.baacrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private  UserTABLE objUserTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create & Connected Database
        createAndConnected();   // if error alt+enter จะสร้าง constructor auto

    }   //Main Method

    private void createAndConnected() {

        objUserTABLE = new UserTABLE(this);
    }

}   // Main Class
