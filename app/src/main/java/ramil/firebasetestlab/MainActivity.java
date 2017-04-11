package ramil.firebasetestlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login_tv)    EditText uiLoginTv;
    @BindView(R.id.password_tv) EditText uiPasswordTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_btn)
    public void loginClick() {
        String login = uiLoginTv.getText().toString();
        String password = uiPasswordTv.getText().toString();

        if (!login.isEmpty() && login.equals(password)) {
            startActivity(new Intent(this, UserActivity.class));
        }
    }
}
