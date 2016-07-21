package in.utsav.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import in.utsav.awesomequotes.DetailActivity;
import in.utsav.awesomequotes.MainActivity;
import in.utsav.awesomequotes.R;
import in.utsav.model.Quote;

/**
 * Created by hp on 15-07-16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    ArrayList<Quote> quotesList;
    Context context;

    public CustomAdapter(ArrayList<Quote> quotesList,Context context){
        this.quotesList=quotesList;
        this.context = context;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater .from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        CustomViewHolder cv = new CustomViewHolder(v);
        return cv;

    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        holder.quoteText.setText(quotesList.get(position).getTitleText());
        holder.authorName.setText(quotesList.get(position).getAuthorName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quote quoteObj = quotesList.get(holder.getAdapterPosition());
                String title = quoteObj.getTitleText();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("QuoteText",quoteObj.getTitleText());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {

        return quotesList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView quoteText;
        TextView authorName;
        CardView cardView;

        public CustomViewHolder(View itemView) {
            super(itemView);

            quoteText =(TextView) itemView.findViewById(R.id.quoteText);
            authorName = (TextView) itemView.findViewById(R.id.authorName);
            cardView = (CardView) itemView.findViewById(R.id.cardView);


        }
    }
}

