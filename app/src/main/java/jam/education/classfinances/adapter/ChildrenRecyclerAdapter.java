package jam.education.classfinances.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import jam.education.classfinances.R;
import jam.education.classfinances.model.Child;

public class ChildrenRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Child> children = new ArrayList<>();

    public ChildrenRecyclerAdapter() {
        //Test data, remove later
        children.add(new Child("Джон Смит"));
        children.add(new Child("Джон Смит"));
        children.add(new Child("Джон Смит"));
        children.add(new Child("Джон Смит"));
        children.add(new Child("Джон Смит"));
        children.add(new Child("Джон Смит"));
        children.add(new Child("Джон Смит"));
        children.add(new Child("Джон Смит"));
        children.add(new Child("Karen Smith"));
    }

    public void setCharacterItems(List<Child> characters) {
        this.children.addAll(characters);
        notifyDataSetChanged();
    }

    public List<Child> getChildren() {
        return children;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView childCardView = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.children_recycler_item, parent, false);
        return new ChildCardView(childCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Child child = children.get(position);
        ChildCardView cardView = (ChildCardView) holder;
        TextView childNumber = cardView.cardView.findViewById(R.id.child_number);
        TextView childName = cardView.cardView.findViewById(R.id.child_name);

        childNumber.setText(String.valueOf(position + 1));
        childName.setText(child.getName());

    }

    @Override
    public int getItemCount() {
        return children.size();
    }

    private class ChildCardView extends RecyclerView.ViewHolder{
        CardView cardView;


        public ChildCardView(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.child_card_view);
        }
    }
}
