package himanshugoel.com.githubusers.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import himanshugoel.com.githubusers.Model.GithubUsers;
import himanshugoel.com.githubusers.R;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder> {
    private List<GithubUsers> githubUsersList = new ArrayList<>();

    @NonNull
    @Override
    public GithubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GithubAdapter.ViewHolder holder, int position) {
        Picasso.get().load(githubUsersList.get(position).getAvatarUrl()).into(holder.imgUserImage);
        holder.txtUserName.setText(githubUsersList.get(position).getLogin());
        holder.txtLink.setText(githubUsersList.get(position).getHtmlUrl());

    }

    @Override
    public int getItemCount() {
        return githubUsersList.size();
    }

    public void setItems(List<GithubUsers> githubUsersList) {
        this.githubUsersList = githubUsersList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUserImage;
        TextView txtUserName;
        TextView txtLink;

        public ViewHolder(View itemView) {
            super(itemView);
            imgUserImage = itemView.findViewById(R.id.imgUser);
            txtUserName = itemView.findViewById(R.id.txtName);
            txtLink = itemView.findViewById(R.id.txtLink);
        }
    }
}
