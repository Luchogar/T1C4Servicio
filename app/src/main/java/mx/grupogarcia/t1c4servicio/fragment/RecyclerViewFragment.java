package mx.grupogarcia.t1c4servicio.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.coursera.sacbe.petagramaxelsegura.R;
//import com.coursera.sacbe.petagramaxelsegura.adapter.MascotaAdaptador;
//import com.coursera.sacbe.petagramaxelsegura.pojo.FotoMascota;
//import com.coursera.sacbe.petagramaxelsegura.presentador.IRecyclerViewFragmentPresenter;
//import com.coursera.sacbe.petagramaxelsegura.presentador.RecyclerViewFragmentPresenter;

import mx.grupogarcia.t1c4servicio.presentador.RecyclerViewFragmentPresenter;
import mx.grupogarcia.t1c4servicio.presentador.IRecyclerViewFragmentPresenter;
import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;
import mx.grupogarcia.t1c4servicio.adapter.MascotaAdaptador;
import mx.grupogarcia.t1c4servicio.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<FotoMascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascota);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<FotoMascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public void generarLinearLyout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }
}
