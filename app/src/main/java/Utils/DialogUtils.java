package Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Soph on 5/10/2014.
 */
public class DialogUtils {
    public static AlertDialog getLogOutDialog(Context context, DialogInterface.OnClickListener affirmitive, DialogInterface.OnClickListener negative) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setPositiveButton("Logout", affirmitive).setNegativeButton("Cancel", negative).setTitle("Confirm Logout").setMessage("Do you want to sign out?");

        return builder.create();
    }
}
