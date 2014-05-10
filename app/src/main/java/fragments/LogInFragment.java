package fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.barnett.blackie.gotmilk.app.R;
import com.barnett.blackie.gotmilk.app.activities.HomeActivity;

import Constants.Constants;

public class LogInFragment extends Fragment {

    public LogInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        Log.w(Constants.GOTMILKLOGTAG, "you are cool " + view.getClass().toString());
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = (TextView) view.findViewById(R.id.login_welcome);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(Constants.GOTMILKLOGTAG, "you have clicked");
            }
        });
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(Constants.GOTMILKLOGTAG, "you have long clicked");
                return true;
            }
        });
        Button loginButton = (Button) view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidEmail() && isValidPassword()) {
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean isValidEmail() {
        EditText emailField = (EditText) getView().findViewById(R.id.login_email);
        String email = emailField.getText().toString();
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    private boolean isValidPassword() {
        EditText passwordField = (EditText) getView().findViewById(R.id.login_password);
        String password = passwordField.getText().toString();
        if (password.length() >= 6) {
            return true;
        }
        return false;
    }
}
