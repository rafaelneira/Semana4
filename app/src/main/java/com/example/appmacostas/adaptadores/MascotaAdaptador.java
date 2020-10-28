package com.example.appmacostas.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmacostas.model.Mascota;
import com.example.appmacostas.R;
import com.example.appmacostas.model.ConstructorMascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas=mascotas;
        this.activity= activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = getView(parent);

        return new MascotaViewHolder(v);
    }

    private View getView(@NonNull ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,
                false);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLike.setText(mascota.getFavorito() + " Likes");

        mascotaViewHolder.btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a: " +mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.likeMascota(mascota);
                mascotaViewHolder.tvLike.setText(constructorMascotas.obtenerlikeMascota(mascota)+ " " +activity.getString(R.string.favorito));

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnlike;
        private TextView tvLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCV= itemView.findViewById(R.id.tvNombre);
            btnlike=itemView.findViewById(R.id.btnlike);
            tvLike=itemView.findViewById(R.id.tvLike);

        }
    }

}
