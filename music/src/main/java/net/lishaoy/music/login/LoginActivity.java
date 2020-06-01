package net.lishaoy.music.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import net.lishaoy.lib_common_ui.SpreadView;
import net.lishaoy.lib_common_ui.base.BaseActivity;
import net.lishaoy.lib_network.listener.DisposeDataListener;
import net.lishaoy.music.R;
import net.lishaoy.music.api.RequestCenter;
import net.lishaoy.music.model.user.User;
import net.lishaoy.music.utils.UserManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_view)
    TextView loginView;
    @BindView(R.id.spreadView)
    SpreadView spreadView;

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_view)
    public void onLoginClicked() {
        RequestCenter.login(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                User user = (User) responseObj;
                UserManager.getInstance().saveUser(user);
                EventBus.getDefault().post(new LoginEvent());
                finish();
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }
}
