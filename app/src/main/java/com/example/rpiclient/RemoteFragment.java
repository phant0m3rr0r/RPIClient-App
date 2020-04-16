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


public class RemoteFragment extends Fragment {
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

    public RemoteFragment() {
        // Required empty public constructor
    }

    public static RemoteFragment newInstance(String param1, String param2) {
        RemoteFragment fragment = new RemoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


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
        View view = inflater.inflate(R.layout.fragment_remote, container, false);


        String sServerIp = settings.getString("PREF_SERVER_IP","");
        String sServerPort = settings.getString("PREF_REMOTE_PORT","");
        String IP = "http://" + sServerIp + ":" +  sServerPort;
        //String IP = "http://192.168.8.155";
        retrofit = new Retrofit.Builder()
                .baseUrl(IP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        super.onViewCreated(view, savedInstanceState);


        //POWER
        view.findViewById(R.id.remPower).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemotePower(map);

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

        //MUTE
        view.findViewById(R.id.remMute).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteMute(map);

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

        //VOLUME DOWN
        view.findViewById(R.id.remVolDown).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteDown(map);

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

        //VOLUME UP
        view.findViewById(R.id.remVolUp).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteUp(map);

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

        //LINE1
        view.findViewById(R.id.remLine1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteLine1(map);

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

        //LINE2
        view.findViewById(R.id.remLine2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteLine2(map);

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

        //OPT
        view.findViewById(R.id.remOpt).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteOpt(map);

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

        //COX
        view.findViewById(R.id.remCox).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteCox(map);

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

        //BLUETOOTH
        view.findViewById(R.id.remBluetooth).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteBT(map);

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

        //PLAYPAUSE
        view.findViewById(R.id.remPlaypause).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemotePlayPause(map);

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

        //REWIND
        view.findViewById(R.id.remRewind).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteRewind(map);

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

        //FORWARD
        view.findViewById(R.id.remForward).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                HashMap<String, String> map = new HashMap<>();

                Call<Void> call = retrofitInterface.executeRemoteForward(map);

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