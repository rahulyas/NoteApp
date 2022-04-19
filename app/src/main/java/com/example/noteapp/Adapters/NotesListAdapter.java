package com.example.noteapp.Adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.ModelClass.Notes;
import com.example.noteapp.NotesClickListener;
import com.example.noteapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{
    Context context;
    List<Notes> list;
    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.textView_title.setText(list.get(position).getTitle());
        holder.textView_title.setSelected(true);

        holder.textview_notes.setText(list.get(position).getNotes());

        holder.textview_dates.setText(list.get(position).getDate());
        holder.textview_dates.setSelected(true);

        if(list.get(position).isPinned())
        {
            holder.imaeview_pin.setImageResource(R.drawable.pin);
        }
        else {
            holder.imaeview_pin.setImageResource(0);
        }

        int color_code =getRandomColor();
        if (Build.VERSION.SDK_INT >= 23) {
            holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code, null));
        }
        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
                return true;
            }
        });
    }

    private int getRandomColor(){
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.color);
        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);
        colorCode.add(R.color.color6);
        colorCode.add(R.color.color7);

        Random random =new Random();
        int random_color = random.nextInt(colorCode.size());
        return colorCode.get(random_color);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(List<Notes> filerList){
        list = filerList;
        notifyDataSetChanged();
    }
}

class NotesViewHolder extends RecyclerView.ViewHolder{

    CardView notes_container;
    TextView textView_title,textview_notes,textview_dates;
    ImageView imaeview_pin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        notes_container = itemView.findViewById(R.id.notes_container);
        textView_title = itemView.findViewById(R.id.textView_title);
        textview_notes = itemView.findViewById(R.id.textview_notes);
        textview_dates = itemView.findViewById(R.id.textview_dates);
        imaeview_pin = itemView.findViewById(R.id.imaeview_pin);
    }
}
