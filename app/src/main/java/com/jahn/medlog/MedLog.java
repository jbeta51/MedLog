package com.jahn.medlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;


public class MedLog extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medlog);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        Bundle bundle = getIntent().getExtras();
        boolean machineLearning = bundle.getBoolean("machine_learning");
        // Adding child data
        listDataHeader.add("Clonidine");
        listDataHeader.add("Warfarin");
        listDataHeader.add("Tylenol");
        if(machineLearning) {
            listDataHeader.add("Cardizem");
        }

        // Adding child data
        List<String> clonidine = new ArrayList<String>();
        clonidine.add("Dosage: 0.1 mg");
        clonidine.add("Once every 8 hours");
        clonidine.add("Avoid taking along with decongestants");


        List<String> warfarin = new ArrayList<String>();
        warfarin.add("Dosage: 2 mg");
        warfarin.add("once every 24 hours");
        warfarin.add("Regulate vitamin K intake");


        List<String> tylenol = new ArrayList<String>();
        tylenol.add("Dosage: 750 mg");
        tylenol.add("once every 6 hours");
        tylenol.add("Avoid taking along with cold medicine");



        listDataChild.put(listDataHeader.get(0), clonidine); // Header, Child data
        listDataChild.put(listDataHeader.get(1), warfarin);
        listDataChild.put(listDataHeader.get(2), tylenol);
        if(machineLearning) {
            List<String> cardizem = new ArrayList<String>();
            cardizem.add("Dosage: 30 mg");
            cardizem.add("4 times a day");
            listDataChild.put(listDataHeader.get(3), cardizem);
        }
    }
}
