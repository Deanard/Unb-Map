package mappypal.headhallmappyboi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Dean on 3/31/2018.
 */


public class UnbFragment extends Fragment {
    private Spinner spinner1;
    private Button button;
    private Spinner spinner2;
    static ArrayAdapter<CharSequence> adapter;
    static ArrayAdapter<CharSequence> adapter2;
    static Intent myIntent;

    public static UnbFragment newInstance() {
        UnbFragment fragment = new UnbFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.unb_mapping_fragment, container, false);


        return inflater.inflate(R.layout.unb_mapping_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        button = (Button) getView().findViewById(R.id.button2);
        spinner1 = (Spinner) getView().findViewById(R.id.spinner);
        spinner2 = (Spinner) getView().findViewById(R.id.spinner2);

        adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.start_points, android.R.layout.simple_spinner_item);

        adapter2 = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.destinations, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(getActivity().getApplicationContext(),
                        MapsActivity.class);
                myIntent.putExtra("startLocation", spinner1.getSelectedItem().toString());
                myIntent.putExtra("destination", spinner2.getSelectedItem().toString());
                startActivity(myIntent);
            }
        });
    }

}