package mappypal.headhallmappyboi;



import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import android.support.annotation.ColorRes;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;


public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Spinner spinner1;
    Spinner spinner2;
    BottomNavigationView bottomNavigation;
    private TextView testText;
    FragmentPagerAdapter adapterViewPager;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter3;
    ArrayAdapter<CharSequence> adapter4;
    public double newCoor1 = 0.0;
    public double newCoor2= 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {



                switch (position){

                    case 0:
                        //do UNB initialization here

                        break;

                    case 1:
                        //do Headhall stuff
                        button2 = (Button) findViewById(R.id.button3);
                        spinner1 = (Spinner) findViewById(R.id.spinner3);
                        spinner2 = (Spinner) findViewById(R.id.spinner4);

                        adapter3 = ArrayAdapter.createFromResource(getApplicationContext(),
                                R.array.start_points, android.R.layout.simple_spinner_item);

                        adapter4 = ArrayAdapter.createFromResource(getApplicationContext(),
                                R.array.destinations, android.R.layout.simple_spinner_item);

                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        spinner1.setAdapter(adapter3);
                        spinner2.setAdapter(adapter4);
                        button2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View arg0) {

                                // Start NewActivity.class
                                Intent myIntent = new Intent(MainActivity.this,
                                        MapsActivity2.class);
                                //myIntent.putExtra("startLocation", spinner1.getSelectedItem().toString());
                                //myIntent.putExtra("destination", spinner2.getSelectedItem().toString());
                                startActivity(myIntent);
                            }
                        });
                        break;

                    case 2:
                        break;

                    default:
                        break;
                }

            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

       /* bottomNavigation = findViewById(R.id.navigation);
        bottomNavigation.setBackgroundColor(Color.argb(100,160, 10, 10));
        testText = findViewById(R.id.textView3);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.navigation_unb) {
                    testText.setText("UNB");
                } else if (itemId == R.id.navigation_head_hall) {
                    testText.setText("HEAD HALL");
                } else if (itemId == R.id.navigation_add_location) {
                    testText.setText("ADD");

                }
                //finish();

            return true;
            }
        });
*/
       /* button = (Button) findViewById(R.id.button2);
        button2 = (Button) findViewById(R.id.button3);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.start_points, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.destinations, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        MapsActivity.class);
                myIntent.putExtra("startLocation", spinner1.getSelectedItem().toString());
                myIntent.putExtra("destination", spinner2.getSelectedItem().toString());
                startActivity(myIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        MapsActivity2.class);
                //myIntent.putExtra("startLocation", spinner1.getSelectedItem().toString());
                //myIntent.putExtra("destination", spinner2.getSelectedItem().toString());
                startActivity(myIntent);
            }
        });
      */
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return UnbFragment.newInstance();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return HeadHallFragment.newInstance();
                case 2: // Fragment # 1 - This will show SecondFragment
                    return AddLocationFragment.newInstance();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            String temp = "";
            switch (position){
                case 0:
                    temp = "Unb Map";
                    break;
                case 1:
                    temp = "Head Hall Map";
                    break;
                case 2:
                    temp = "Add Location";
                    break;
                default:
                    temp = "ERROR";
                    break;
            }
            return temp;
        }

    }

}

