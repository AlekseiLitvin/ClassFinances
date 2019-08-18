package jam.education.classfinances.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jam.education.classfinances.R;
import jam.education.classfinances.model.Parent;

public class DonatedParentsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Parent> parents = new ArrayList<>();
    private Context context;

    public DonatedParentsRecyclerAdapter(Context context) {
        this.context = context;
        parents.add(new Parent(1, "Аникеева Дарья"));
        parents.add(new Parent(2, "Бобриков Иван"));
        parents.add(new Parent(3, "Борисенко Дмитрий"));
        parents.add(new Parent(4, "Гриневич Александр"));
        parents.add(new Parent(5, "Гриневич Петр"));
    }

    public void setCharacterItems(List<Parent> donates) {
        this.parents.addAll(donates);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.donated_parents_item, parent, false);
        return new DonatedParentCardView(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DonatedParentCardView donatedParentCardView = (DonatedParentCardView) holder;
        CardView cardView = donatedParentCardView.cardView;
        TextView parentNumber = cardView.findViewById(R.id.parent_number);
        TextView parentName = cardView.findViewById(R.id.parent_name);
        Switch isParendDonated = cardView.findViewById(R.id.parent_is_donated);
        Activity context = (Activity) this.context;
        final TextView collectedOverall = context.findViewById(R.id.collected_overall);

        Parent parent = parents.get(position);

        parentNumber.setText(String.valueOf(position + 1));
        parentName.setText(parent.getName());
        isParendDonated.setChecked(position % 2 == 0);
        if (position == 1) {
            isParendDonated.setChecked(true);
        }

        isParendDonated.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String s = collectedOverall.getText().toString();
                    String result = s.replaceAll(" руб", "");
                    int i = Integer.parseInt(result);
                    i += 10;
                    collectedOverall.setText(String.valueOf(i) + " руб");
                } else {
                    String s = collectedOverall.getText().toString();
                    String result = s.replaceAll(" руб", "");
                    int i = Integer.parseInt(result);
                    i -= 10;
                    collectedOverall.setText(String.valueOf(i) + " руб");
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return parents.size();
    }

    class DonatedParentCardView extends RecyclerView.ViewHolder{
        CardView cardView;

        public DonatedParentCardView(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.donated_parent_card_view);
        }
    }

}
