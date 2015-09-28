package etbrady.todo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import etbrady.todo.models.Chore;

public class MainActivity extends AppCompatActivity {

    List<Chore> chores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chores = new ArrayList<>();
    }

    private void createChore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("New Chore");
        LayoutInflater inflater = getLayoutInflater();
        final View view = inflater.inflate(R.layout.alertdialog_newchore, null, false);
        builder.setView(view);

        builder.setPositiveButton("Create Chore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editText = (EditText) view.findViewById(R.id.edittext_title);
                String title = editText.getText().toString();
                Chore chore = new Chore(title);
                chores.add(chore);
            }
        });

        builder.setNegativeButton("Cancel", null);

        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.action_newChore) {
            createChore();
        }

        return super.onOptionsItemSelected(item);
    }
}
