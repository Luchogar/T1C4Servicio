package mx.grupogarcia.t1c4servicio.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mx.grupogarcia.t1c4servicio.DetalleMascotaFoto;
import com.squareup.picasso.Picasso;
import mx.grupogarcia.t1c4servicio.R;
import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;

import java.util.ArrayList;

/**
 * Created by Luis García on 03/01/2017.
 */
public class FotoMascotaAdaptador extends  RecyclerView.Adapter<FotoMascotaAdaptador.FotoMascotaViewHolder> {

    private ArrayList<FotoMascota> fotosMascota;
    private Activity activity;

    public FotoMascotaAdaptador(ArrayList<FotoMascota> fotosMascota, Activity activity){
        this.fotosMascota=fotosMascota;
        this.activity=activity;
    }

    //Inflamos el layout y lo enviara hacia  el view holder para obtener  views
    @Override
    public FotoMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto_mascota, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto_mascota, parent, false);
        return new FotoMascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final FotoMascotaViewHolder mascotaViewHolder, int position) {
        final FotoMascota fotoMascota = fotosMascota.get(position);
        //mascotaViewHolder.imgFotoMascotaCVFrg.setImageResource(fotoMascota.getFoto());

        Picasso.with(activity)
                .load(fotoMascota.getUrlFoto())
                .placeholder(R.drawable.siluet)
                .into(mascotaViewHolder.imgFotoMascotaCVFrg);


        mascotaViewHolder.tvRatingCVFrg.setText(String.valueOf(fotoMascota.getLikesFoto()));

        mascotaViewHolder.imgFotoMascotaCVFrg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascotaFoto.class);
                intent.putExtra(activity.getResources().getString(R.string.pUrl), fotoMascota.getUrlFoto());
                intent.putExtra(activity.getResources().getString(R.string.pLikes), fotoMascota.getLikesFoto());
                activity.startActivity(intent);
                //activity.finish();
            }
        });

    }

    public int getItemCount() {//Cantidad de elementos que contiene la lista
        return fotosMascota.size();
    }

    public static class FotoMascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoMascotaCVFrg;
        private TextView tvRatingCVFrg;

        public FotoMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascotaCVFrg = (ImageView) itemView.findViewById(R.id.imgFotoMascotaCVFrg);
            tvRatingCVFrg = (TextView) itemView.findViewById(R.id.tvRatingCVFrg);
        }
    }

}
