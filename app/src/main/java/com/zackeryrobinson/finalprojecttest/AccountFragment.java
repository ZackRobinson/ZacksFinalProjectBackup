package com.zackeryrobinson.finalprojecttest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.zackeryrobinson.finalprojecttest.R.drawable.ic_chevron_right_black_24dp;
import static com.zackeryrobinson.finalprojecttest.R.drawable.ic_expand_more_black_24dp;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AccountFragment extends Fragment implements  PayFragment.OnFragmentInteractionListener, View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    ConstraintLayout clLodging;
    ScrollView svLodging;
    ImageView ivLodgingChevron;
    CardView cvLodging;

    ConstraintLayout clAccounts;
    ScrollView svAccounts;
    ImageView ivAccountsChevron;
    CardView cvAccounts;



    ConstraintLayout clContacts;
    ScrollView svContacts;
    ImageView ivContactsChevron;
    CardView cvContacts;


    ConstraintLayout clTeam;
    ImageView ivTeamChevron;
    CardView cvTeam;
    LinearLayout llTeamList;
    LinearLayout llTeamHide;

    private int tabOpen;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        clContacts = (ConstraintLayout) rootView.findViewById(R.id.clContacts);
        svContacts = (ScrollView) rootView.findViewById(R.id.svContacts);
        ivContactsChevron = (ImageView) rootView.findViewById(R.id.ivContactsChevron);
        cvContacts = (CardView) rootView.findViewById(R.id.cvContact);


        clAccounts = (ConstraintLayout) rootView.findViewById(R.id.clAccount);
        svAccounts = (ScrollView) rootView.findViewById(R.id.svAccounts);
        ivAccountsChevron = (ImageView) rootView.findViewById(R.id.ivAccountChevron);
        cvAccounts = (CardView) rootView.findViewById(R.id.cvAccount);



        clLodging = (ConstraintLayout) rootView.findViewById(R.id.clLodging);
        svLodging = (ScrollView) rootView.findViewById(R.id.svLodging);
        ivLodgingChevron = (ImageView) rootView.findViewById(R.id.ivLodgingChevron);
        cvLodging = (CardView) rootView.findViewById(R.id.cvLodging);

        clTeam = (ConstraintLayout) rootView.findViewById(R.id.clTeam);
        ivTeamChevron = (ImageView) rootView.findViewById(R.id.ivTeamChevron);
        cvTeam = (CardView) rootView.findViewById(R.id.cvTeam);
        llTeamList = (LinearLayout) rootView.findViewById(R.id.llTeamlist);
        llTeamHide = (LinearLayout) rootView.findViewById(R.id.llTeamHide) ;


        ArrayList<String> teamList = new ArrayList<>();
        teamList.add("JohnnyRotten");
        teamList.add("Wolverine");
        teamList.add("Tindor DoubleDukes");
        teamList.add("Oreos");
        teamList.add("nightman");
        teamList.add("dayman");
        teamList.add("trolltoll");
        teamList.add("Bird");
        createTeam(teamList);



        clContacts.setOnClickListener(this);
        clAccounts.setOnClickListener(this);
        clLodging.setOnClickListener(this);
        clTeam.setOnClickListener(this);
        tabOpen=1;
        return rootView;
    }

    private void createTeam( ArrayList<String> teamList){
        int size = teamList.size();
        TextView temp;
        Context context = getContext();

        for (int i = 0; i < size; i++)
        {

            temp = new TextView(getContext());

            temp.setText(teamList.get(i)); //arbitrary task
            temp.setGravity(Gravity.CENTER);
            // add the textview to the linearlayout
            llTeamList.addView(temp);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.clContacts:
                openContacts();
                break;
            case R.id.clAccount:
                openAccount();
                break;
            case R.id.clLodging:
                openLodging();
                break;
            case R.id.clTeam:
                openTeam();
                break;
        }
    }

    private void openAccount() {
        if (tabOpen != 1) {
            svAccounts.setVisibility(View.VISIBLE);
            ivAccountsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_expand_more_black_24dp));
            svLodging.setVisibility(View.GONE);
            svContacts.setVisibility(View.GONE);
            llTeamHide.setVisibility(View.GONE);
            ivLodgingChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivContactsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivTeamChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            tabOpen = 1;
        } else {
            svAccounts.setVisibility(View.GONE);
            ivAccountsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            tabOpen = 0;
        }
    }

    private void openLodging(){
        if(tabOpen != 2) {
            svLodging.setVisibility(View.VISIBLE);
            ivLodgingChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_expand_more_black_24dp));
            svAccounts.setVisibility(View.GONE);
            svContacts.setVisibility(View.GONE);
            llTeamHide.setVisibility(View.GONE);
            ivAccountsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivContactsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivTeamChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            tabOpen = 2;
        }else{
            svLodging.setVisibility(View.GONE);
            ivLodgingChevron.setImageDrawable(ContextCompat.getDrawable(getContext(),ic_chevron_right_black_24dp));
            tabOpen = 0;
        }
    }

    private void openContacts(){
        if(tabOpen != 3) {
            svContacts.setVisibility(View.VISIBLE);
            ivContactsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_expand_more_black_24dp));
            svAccounts.setVisibility(View.GONE);
            svLodging.setVisibility(View.GONE);
            llTeamHide.setVisibility(View.GONE);
            ivLodgingChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivAccountsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivTeamChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            tabOpen = 3;
        }else{
            svContacts.setVisibility(View.GONE);
            ivContactsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(),ic_chevron_right_black_24dp));
            tabOpen = 0;
        }
    }

    private void openTeam(){
        if(tabOpen != 4) {
            llTeamHide.setVisibility(View.VISIBLE);
            ivTeamChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_expand_more_black_24dp));
            svAccounts.setVisibility(View.GONE);
            svLodging.setVisibility(View.GONE);
            svContacts.setVisibility(View.GONE);
            ivLodgingChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivAccountsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            ivContactsChevron.setImageDrawable(ContextCompat.getDrawable(getContext(), ic_chevron_right_black_24dp));
            tabOpen = 4;
        }else{
            llTeamHide.setVisibility(View.GONE);
            ivTeamChevron.setImageDrawable(ContextCompat.getDrawable(getContext(),ic_chevron_right_black_24dp));
            tabOpen = 0;
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

