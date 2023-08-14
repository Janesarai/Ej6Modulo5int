package com.example.ej6modulo5int;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ej6modulo5int.databinding.FragmentRecicleAdapterBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecicleAdapter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecicleAdapter extends Fragment {
    private List<Lista> listaFru = new ArrayList<>();
    private FragmentRecicleAdapterBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecicleAdapter() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecicleAdapter.
     */
    // TODO: Rename and change types and number of parameters
    public static RecicleAdapter newInstance(String param1, String param2) {
        RecicleAdapter fragment = new RecicleAdapter();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecicleAdapterBinding.inflate(getActivity().getLayoutInflater());

        Adapter adapter = new Adapter();
        adapter.setData(getData());

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(binding.recyclerView.getContext(), DividerItemDecoration.VERTICAL));


        return binding.getRoot();
    }

    private List<Lista> getData() {

        listaFru.add(new Lista("Naranja", "https://i0.wp.com/historiasdelahistoria.com/wordpress-2.3.1-ES-0.1-FULL/wp-content/uploads/2015/11/naranja.jpg?w=607&ssl=1", "N-A-R-A-N-J-A"));
        listaFru.add(new Lista("Mora", "https://cdn.ppfam.com/files/445-27896-imagen/mora.jpg", "M-O-R-A"));
        listaFru.add(new Lista("Arandanos", "https://sanangel.edu.mx/sites/default/files/gdi/Mora-Azul-Banner.jpg", "A-R-A-N-D-A-N-O-S"));
        listaFru.add(new Lista("Melocoton", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTSr_ctdogvZkBvILA1iYPQTplN8BCCbUUesgFuPqODj6pQqCQjN-gJpd9Ca9hpaHnH4o&usqp=CAU", "M-E-L-O-C-O-T-O-N"));
        listaFru.add(new Lista("Damasco", "https://5aldia.cl/wp-content/uploads/2018/03/damasco.jpg", "D-A-M-A-S-C-O"));
        listaFru.add(new Lista("Maracuya", "https://i0.wp.com/procamp.cl/wp-content/uploads/2020/07/marcuya.png?fit=600%2C600&ssl=1", "M-A-R-A-C-U-Y-A"));
        listaFru.add(new Lista("Pomelo", "https://cugat.cl/multi/chillan/wp-content/uploads/sites/9/2022/07/2542025000002-2.jpg", "P-O-M-E-L-O"));
        return listaFru;

    }
}