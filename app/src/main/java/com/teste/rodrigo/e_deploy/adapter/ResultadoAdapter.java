package com.teste.rodrigo.e_deploy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teste.rodrigo.e_deploy.R;
import com.teste.rodrigo.e_deploy.model.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigobarbosa on 02/09/17.
 */

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadoViewHolder>{
    private Context mContext;
    private List<State> lista;
    private ResultadoOnClickListener onClickListener;

    public ResultadoAdapter(Context context, ResultadoOnClickListener onClickListener, List<State> lista) {
        this.mContext = context;
        this.onClickListener = onClickListener;
        this.lista = lista;
    }

    public interface ResultadoOnClickListener {
        public void OnClickResultado(View view, int index);

    }


    @Override
    public ResultadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_resultado, parent, false);
        ResultadoViewHolder holder = new ResultadoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ResultadoViewHolder holder, int position) {
        State r = lista.get(position);

        holder.tvCidade.setText(mContext.getString(R.string.label_list_cidade, r.getNome()));
        holder.tvEstado.setText(mContext.getString(R.string.label_list_estado, r.getEstado()));


        if (onClickListener != null) {
            holder.view.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.OnClickResultado(holder.view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ResultadoViewHolder extends RecyclerView.ViewHolder {

        TextView tvCidade;
        TextView tvEstado;

        private View view;

        public ResultadoViewHolder(View view) {
            super(view);
            this.view = view;
            this.tvCidade = (TextView) view.findViewById(R.id.tvCidade);

            this.tvEstado = (TextView) view.findViewById(R.id.tvEstado);

        }
    }
}

/*package br.com.trasmontano.trasmontanoassociadomobile.adapter;

        import android.content.Context;
        import android.net.Uri;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import com.mikhaellopez.circularimageview.CircularImageView;

        import java.io.File;
        import java.util.List;

        import br.com.trasmontano.trasmontanoassociadomobile.DTO.Associado;
        import br.com.trasmontano.trasmontanoassociadomobile.R;

*//**
 * Created by rbarbosa on 07/07/2016.
 *//*

public class AssociadoLoginAdapter extends RecyclerView.Adapter<AssociadoLoginAdapter.AssociadoViewHolder> {
    private Context context;
    private List<Associado> lstAssociado;
    private final AssociadoOnClickListener onClickListener;

    public interface AssociadoOnClickListener {
        public void OnClickAssociado(View view, int index);
        public void OnClickMenu(View view, int index);
    }

    public AssociadoLoginAdapter(Context context, List<Associado> lstAssociado, AssociadoOnClickListener onClickListener) {
        this.context = context;
        this.lstAssociado = lstAssociado;
        this.onClickListener = onClickListener;
    }

    @Override
    public AssociadoLoginAdapter.AssociadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_associado, parent, false);
        AssociadoViewHolder holder = new AssociadoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final AssociadoLoginAdapter.AssociadoViewHolder holder, final int position) {
        Associado r = lstAssociado.get(position);

        holder.tiNomeAssociado.setText(r.getNome());
        holder.tiMatricula.setText(r.getUsuario());

        if (r.getCaminhoImagem() != null) {
            File file = new File(r.getCaminhoImagem());
            if (file.exists()) {
                holder.ivAssociado.setImageURI(Uri.parse(r.getCaminhoImagem()));
            }
        }
        if (onClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.OnClickAssociado(holder.view, position);
                }
            });
            holder.ivOpcoes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.OnClickMenu(holder.view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lstAssociado.size();
    }

    public static class AssociadoViewHolder extends RecyclerView.ViewHolder {

        CircularImageView ivAssociado;
        TextView tiNomeAssociado;
        TextView tiMatricula;
        ImageView ivOpcoes;
        //ProgressBar pbAssociado;
        private View view;

        public AssociadoViewHolder(View view) {
            super(view);
            this.view = view;
            this.tiNomeAssociado = (TextView) view.findViewById(R.id.tvNomeAssociado);
            this.ivAssociado = (CircularImageView) view.findViewById(R.id.ivAssociado);
            this.tiMatricula = (TextView) view.findViewById(R.id.tvMatricula);
            this.ivOpcoes = (ImageView) view.findViewById(R.id.ivOpcoes);
            //this.pbAssociado = (ProgressBar) view.findViewById(R.id.pbAssociado);
        }
    }
}*/

