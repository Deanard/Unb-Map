package mappypal.headhallmappyboi;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dean on 3/31/2018.
 */

public class HeadHallFragment extends Fragment {
    public static HeadHallFragment newInstance() {
        HeadHallFragment fragment = new HeadHallFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.head_hall_fragment, container, false);
        return inflater.inflate(R.layout.head_hall_fragment, container, false);
    }
}