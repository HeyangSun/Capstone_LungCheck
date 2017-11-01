package com.example.heyang.lungcheck;

        import java.util.HashMap;
        import java.util.Map;
        import org.json.JSONObject;
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;

        import com.example.heyang.lungcheck.R;

        import com.example.heyang.lungcheck.util.DialogUtil;

public class InstructionsOne extends Activity {
    Button bnNextPage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_one);
        bnNextPage = (Button) findViewById(R.id.NextPageButton);
        bnNextPage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructionsOne.this
                        , RecordingPage1.class);
                startActivity(intent);
                finish();
            }
        });
    }

}