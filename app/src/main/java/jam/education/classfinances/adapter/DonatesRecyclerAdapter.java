package jam.education.classfinances.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jam.education.classfinances.DonatedParentsActivity;
import jam.education.classfinances.R;
import jam.education.classfinances.model.Child;
import jam.education.classfinances.model.Donate;

public class DonatesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final String DONATE_INFO = "donateInfo";
    private List<Donate> donates = new ArrayList<>();

    public DonatesRecyclerAdapter() {
        donates.add(new Donate(1, "Ремонт", new Date(), BigDecimal.TEN, 45));
        donates.add(new Donate(2, "Шторы", new Date(), BigDecimal.valueOf(15), 35));
        donates.add(new Donate(3, "Новый Год", new Date(), BigDecimal.valueOf(20), 45));
        donates.add(new Donate(4, "Выпускной", new Date(), BigDecimal.valueOf(5), 95));
        donates.add(new Donate(5, "8 марта", new Date(), BigDecimal.TEN, 45));
    }

    public void setCharacterItems(List<Donate> donates) {
        this.donates.addAll(donates);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.donates_list_recycler_item, parent, false);
        return new DonatesCardView(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        DonatesCardView donatesCardView = (DonatesCardView) holder;
        final CardView cardView = donatesCardView.cardView;
        TextView donateNumber = cardView.findViewById(R.id.donate_number);
        TextView donateName = cardView.findViewById(R.id.donate_name);
        TextView donateDeadline = cardView.findViewById(R.id.donate_deadline);

        final Donate donate = donates.get(position);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = cardView.getContext();
                Intent intent = new Intent(context, DonatedParentsActivity.class);
                intent.putExtra(DONATE_INFO, donate);
                context.startActivity(intent);
            }
        });


        donateNumber.setText(String.valueOf(position + 1));
        donateName.setText(donate.getName());
        donateDeadline.setText("До 27.11.2019");
    }

    @Override
    public int getItemCount() {
        return donates.size();
    }

    public class DonatesCardView extends RecyclerView.ViewHolder {
        CardView cardView;

        public DonatesCardView(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.donate_card_view);
        }
    }

}
