package jam.education.classfinances.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
import jam.education.classfinances.model.Donate;

import static jam.education.classfinances.adapter.DonatesRecyclerAdapter.DONATE_INFO;

public class ChildrenDetailRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Donate> donates = new ArrayList<>();

    public ChildrenDetailRecyclerAdapter() {
        //Mock data, delete later
        donates.add(new Donate(1, "Ремонт", new Date(), BigDecimal.TEN, 45));
        donates.add(new Donate(2, "Шторы", new Date(), BigDecimal.valueOf(15), 35));
        donates.add(new Donate(3, "Новый Год", new Date(), BigDecimal.valueOf(20), 45));
        donates.add(new Donate(4, "Выпускной", new Date(), BigDecimal.valueOf(5), 95));
        donates.add(new Donate(5, "8 марта", new Date(), BigDecimal.TEN, 45));
        donates.add(new Donate(6, "Спорт", new Date(), BigDecimal.TEN, 13));
        donates.add(new Donate(7, "Вода", new Date(), BigDecimal.TEN, 5));
        donates.add(new Donate(8, "На рыбок", new Date(), BigDecimal.TEN, 45));
        donates.add(new Donate(9, "Книга", new Date(), BigDecimal.TEN, 45));
        donates.add(new Donate(10, "Учебные пособия", new Date(), BigDecimal.TEN, 45));
        donates.add(new Donate(11, "Факультативы", new Date(), BigDecimal.TEN, 45));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.donate_info_recycler_item, parent, false);
        return new DonateCardView(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DonateCardView donateCardView = (DonateCardView) holder;
        final CardView cardView = donateCardView.cardView;
        TextView donateName = cardView.findViewById(R.id.donate_name);
        TextView donateAmount = cardView.findViewById(R.id.donate_amount);
        TextView donateDate = cardView.findViewById(R.id.donate_date);
        ProgressBar donateProgress = cardView.findViewById(R.id.donate_progress);

        final Donate donate = donates.get(position);

        donateProgress.getProgressDrawable().setColorFilter(
                Color.parseColor("#278811"), android.graphics.PorterDuff.Mode.SRC_IN);

        donateName.setText(donate.getName());
        donateAmount.setText(donate.getAmount().toString() + "Р");
        donateDate.setText("До 22.11.2019");
        if (position == 2) {
            donateName.setTextColor(Color.RED);
        }
        donateProgress.setProgress(donate.getProgress());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = cardView.getContext();
                Intent intent = new Intent(context, DonatedParentsActivity.class);
                intent.putExtra(DONATE_INFO, donate);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return donates.size();
    }

    public class DonateCardView extends RecyclerView.ViewHolder {
        private CardView cardView;

        public DonateCardView(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.donate_info_item);
        }
    }

}
