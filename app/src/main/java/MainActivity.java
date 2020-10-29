import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.moro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Shania leger lidt, men proever ikke t fucke noget op
        Hvad hvad = new Hvad();
        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction().add(R.id.mainLayout,hvad).commit();
    }
}