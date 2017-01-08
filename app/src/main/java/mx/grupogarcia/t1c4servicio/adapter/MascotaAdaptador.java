package mx.grupogarcia.t1c4servicio.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import com.coursera.sacbe.petagramaxelsegura.DetalleMascotaFoto;
//import com.coursera.sacbe.petagramaxelsegura.R;
//import com.coursera.sacbe.petagramaxelsegura.pojo.FotoMascota;
import com.squareup.picasso.Picasso;
import mx.grupogarcia.t1c4servicio.DetalleMascotaFoto;
import mx.grupogarcia.t1c4servicio.pojo.FotoMascota;
import mx.grupogarcia.t1c4servicio.R;


import java.util.ArrayList;

/**
 * Created by Luis García on 03/01/2017.
 */
public class MascotaAdaptador extends  RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<FotoMascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<FotoMascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    //Inflar el layout y lo pasará al view holder para obtener los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final FotoMascota fotoMascota = mascotas.get(position);
        //mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());

        Picasso.with(activity)
                .load(fotoMascota.getUrlFoto())
                .placeholder(R.drawable.siluet)
                .into(mascotaViewHolder.imgFoto);

        mascotaViewHolder.tvNombre.setText(fotoMascota.getNombreCompleto());
        mascotaViewHolder.tvRaza.setText(fotoMascota.getNombreUsuario());

        String raiting = "";

        //if(fotoMascota.getLikesFoto()>0)
        raiting = String.valueOf(fotoMascota.getLikesFoto());

        mascotaViewHolder.tvRaiting.setText(String.valueOf(raiting)); //mascota.getRaiting())+" Likes"

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Toast.makeText(activity, fotoMascota.getNombreCompleto(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascotaFoto.class);
                intent.putExtra(activity.getResources().getString(R.string.pUrl), fotoMascota.getUrlFoto());
                intent.putExtra(activity.getResources().getString(R.string.pLikes), fotoMascota.getLikesFoto());
//                intent.putExtra(activity.getResources().getString(R.string.pRaza), mascota.getRaza());

                //String raiting = "";

                /*if(mascota.getRaiting()>0)
                    raiting = String.valueOf(mascota.getRaiting());*/

                //intent.putExtra(activity.getResources().getString(R.string.pRating), raiting);
                activity.startActivity(intent);
                //activity.finish();

            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
               /* ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvRaiting.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)) + " Likes");
                */
                Toast.makeText(activity, "Diste like a " + fotoMascota.getNombreUsuario(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene la lista
        return ((mascotas==null)? 0 : mascotas.size());
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRaza;
        private TextView tvRaiting;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaza = (TextView) itemView.findViewById(R.id.tvRazaCV);
            tvRaiting = (TextView) itemView.findViewById(R.id.tvRatingCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
