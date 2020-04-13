package com.example.rpiclient;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;

public class LedModeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SettingsManager settings = new SettingsManager();
    private LedController ledController;
    private ColorPicker picker;
    private OpacityBar opacityBar;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private LedModeFragment.OnFragmentInteractionListener mListener;

    public LedModeFragment() {
        // Required empty public constructor
    }

    public static ScreenFragment newInstance(String param1, String param2) {
        ScreenFragment fragment = new ScreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private static final String SWITCH_LED_STATE = "switchLedState";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String SWITCH_STATE = "switchstate";
    private static final String MANUAL_STATE = "manualstate";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mode, container, false);

        String sServerIp = settings.getString("PREF_SERVER_IP","");
        int iPort = settings.getInt("PREF_LED_PORT", 0);

        ledController = new LedController(sServerIp, iPort);
        final Button ManualButton = (Button)view.findViewById(R.id.manualBut);
        final Button SpotifyButton = (Button)view.findViewById(R.id.spotifyBut);
        final Switch onOffSwitch = (Switch)view.findViewById(R.id.onOffSwitch);
        final RelativeLayout layoutbar = (RelativeLayout)view.findViewById(R.id.layoutbar);
        final RelativeLayout layoutpicker = (RelativeLayout)view.findViewById(R.id.layoutpicker);

        sharedPreferences = this.getContext().getSharedPreferences("com.example.rpiclient", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        onOffSwitch.setChecked(sharedPreferences.getBoolean(SWITCH_LED_STATE, false));

        String sMode = settings.getString("transition","");
        if(sMode == ""){
            sMode = "default";
        }

        // CONNECT COLORPICKER AND OPACITYBAR
        picker = (ColorPicker) view.findViewById(R.id.picker);
        opacityBar = (OpacityBar) view.findViewById(R.id.opacitybar);
        picker.addOpacityBar(opacityBar);
        //SET COLORPICKER LISTENER
        if(sMode.equals("default")){
            picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
                @Override
                public void onColorChanged(int color) {
                    ledController.changeColor(color);
                    onOffSwitch.setChecked(true);
                }
            });
        }

        if(sMode.equals("fade")){
            picker.setOnColorSelectedListener(new ColorPicker.OnColorSelectedListener() {
                @Override
                public void onColorSelected(int color) {
                    ledController.changeColor(color);
                    onOffSwitch.setChecked(true);
                }
            });

            opacityBar.setOnOpacityChangedListener(new OpacityBar.OnOpacityChangedListener() {
                @Override
                public void onOpacityChanged(int opacity) {
                    ledController.changeColor(picker.getColor());
                    onOffSwitch.setChecked(true);
                }
            });
        }

        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean(SWITCH_LED_STATE, isChecked).commit();
                if (isChecked) {
                    editor.putBoolean(SWITCH_STATE, true);
                    editor.apply();
                    //ManualButton.setVisibility(View.VISIBLE);
                    //SpotifyButton.setVisibility(View.VISIBLE);
                    //layoutbar.setVisibility(View.VISIBLE);
                    //layoutpicker.setVisibility(View.VISIBLE);
                    ledController.changeColor(picker.getColor());
                } else {
                    editor.putBoolean(SWITCH_STATE, false);
                    editor.apply();
                    //ManualButton.setVisibility(View.INVISIBLE);
                    //SpotifyButton.setVisibility(View.INVISIBLE);
                    layoutbar.setVisibility(View.INVISIBLE);
                    layoutpicker.setVisibility(View.INVISIBLE);
                    ledController.switchOff();
                }
            }
        });

        ManualButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                editor.putBoolean(MANUAL_STATE, true);
                editor.apply();
                if(sharedPreferences.getBoolean(SWITCH_STATE, true)){
                    if (sharedPreferences.getBoolean(MANUAL_STATE, true)) {
                        layoutbar.setVisibility(View.VISIBLE);
                        layoutpicker.setVisibility(View.VISIBLE);
                    } else {
                        layoutbar.setVisibility(View.INVISIBLE);
                        layoutpicker.setVisibility(View.INVISIBLE);
                    }
                } else {
                    layoutbar.setVisibility(View.INVISIBLE);
                    layoutpicker.setVisibility(View.INVISIBLE);
                }

            }
        });


        super.onViewCreated(view, savedInstanceState);


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main_controller, container, false);
        return view;
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
        if (context instanceof LedModeFragment.OnFragmentInteractionListener) {
            mListener = (LedModeFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

