package mappypal.headhallmappyboi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Dean on 3/31/2018.
 */

public class AddLocationFragment extends Fragment {

    public static final int MAPS_REQUEST_CODE = 0;
    public double latNew;
    public double longNew;
    int newRotate = 0;

    public static AddLocationFragment newInstance() {
        AddLocationFragment fragment = new AddLocationFragment();
        return fragment;

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_location_fragment, container, false);
        return inflater.inflate(R.layout.add_location_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        final EditText text1;
        TextView text2;
        Button btn;
        Button btn2;



        text1 = (EditText) getView().findViewById(R.id.editText5);
        text2 = (TextView) getView().findViewById(R.id.textView);
        btn = (Button) getView().findViewById(R.id.button6);
        btn2 = (Button) getView().findViewById(R.id.button7);
        text1.setText("Location Name");
        text2.setText("Coordinates");
        btn.setText("Set");
        btn2.setText("Save");
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(getActivity().getApplicationContext(),
                        MapsActivity3.class);
                //getActivity().setResult(RESULT_OK, myIntent);
                startActivityForResult(myIntent, MAPS_REQUEST_CODE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        switch(newRotate){
                                            case 0:

                                                newRotate++;
                                                break;
                                            case 1:
                                               // editor.putString(getString(R.string.user_local_2), text1.getText().toString());
                                                newRotate++;
                                                break;
                                            case 2:
                                               // editor.putString(getString(R.string.user_local_3), text1.getText().toString());
                                                newRotate++;
                                                break;
                                            case 3:
                                               // editor.putString(getString(R.string.user_local_4), text1.getText().toString());
                                                newRotate++;
                                                break;
                                            case 4:
                                               // editor.putString(getString(R.string.user_local_5), text1.getText().toString());
                                                newRotate++;
                                                break;
                                            default:
                                                //editor.putString(getString(R.string.user_local_1), text1.getText().toString());
                                                newRotate = 1;
                                                break;
                                        }
                                    }
        }
        );


    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == MAPS_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // get String data from Intent
                double return1 = data.getDoubleExtra("longKey", longNew);
                double return2String = data.getDoubleExtra("latKey", latNew);
                latNew = return2String;
                longNew = return1;

                // set text view with string
                TextView textView = (TextView) getView().findViewById(R.id.textView);
                textView.setText(latNew + ", " + longNew);
            }
        }
    }
    @Override
    public void onResume(){

        super.onResume();

    }
}