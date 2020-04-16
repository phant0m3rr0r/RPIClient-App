package com.example.rpiclient;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SettingsManager settings = new SettingsManager();
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ScreenFragment() {
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

    private static final String SWITCH_SCREEN_STATE = "switchScreenState";
    private SharedPreferences sharedPreferences;


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
        View view = inflater.inflate(R.layout.fragment_screen, container, false);

        final Switch ScreenSwitch = (Switch)view.findViewById(R.id.ScreenSwitch);

        String sServerIp = settings.getString("PREF_SERVER_IP","");
        String sServerPort = settings.getString("PREF_SCREEN_PORT","");
       String IP = "http://" + sServerIp + ":" +  sServerPort;
       //String IP = "http://192.168.8.155";
        retrofit = new Retrofit.Builder()
                .baseUrl(IP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        super.onViewCreated(view, savedInstanceState);


        sharedPreferences = this.getContext().getSharedPreferences("com.example.rpiclient", Context.MODE_PRIVATE);
        ScreenSwitch.setChecked(sharedPreferences.getBoolean(SWITCH_SCREEN_STATE, false));


        ScreenSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean(SWITCH_SCREEN_STATE, isChecked).commit();
                if (isChecked) {
                    HashMap<String, String> map = new HashMap<>();
                    Call<Void> call = retrofitInterface.executeScreenOn(map);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                            if (response.code() == 200) {

                            } else if (response.code() == 400) {

                            }
                        }
                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                        }
                    });

                } else {

                    HashMap<String, String> map = new HashMap<>();
                    Call<Void> call = retrofitInterface.executeScreenOff(map);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                            if (response.code() == 200) {

                            } else if (response.code() == 400) {

                            }
                        }
                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                        }
                    });

                }
            }
        });



        //SCREEN 10
        view.findViewById(R.id.sc10).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen10(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 20
        view.findViewById(R.id.sc20).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen20(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 30
        view.findViewById(R.id.sc30).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen30(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 40
        view.findViewById(R.id.sc40).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen40(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 50
        view.findViewById(R.id.sc50).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen50(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 60
        view.findViewById(R.id.sc60).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen60(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 70
        view.findViewById(R.id.sc70).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen70(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 80
        view.findViewById(R.id.sc80).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen80(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 90
        view.findViewById(R.id.sc90).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen90(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });

        //SCREEN 100 MAX
        view.findViewById(R.id.sc100).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeScreen100(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Snackbar.make(view, "OFF", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        } else if (response.code() == 400) {
                            Snackbar.make(view, "Failed", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }



        });


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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
