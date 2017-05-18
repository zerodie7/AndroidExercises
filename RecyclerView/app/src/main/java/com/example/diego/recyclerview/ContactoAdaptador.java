package com.example.diego.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 17/05/2017.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    public ContactoAdaptador(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.foto.setImageResource(contacto.getFoto());
        contactoViewHolder.contacto.setText(contacto.getNombre());
        contactoViewHolder.numero.setText(contacto.getTelefono());
        contactoViewHolder.likes.setText(String.valueOf(contacto.getLikes()));
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView contacto;
        private TextView numero;
        private TextView likes;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            foto        = (ImageView) itemView.findViewById(R.id.imageView_foto);
            contacto    = (TextView) itemView.findViewById(R.id.textView_Contacto);
            numero      = (TextView) itemView.findViewById(R.id.textView_numero);
            likes       = (TextView) itemView.findViewById(R.id.textView_likes);
        }
    }
}
