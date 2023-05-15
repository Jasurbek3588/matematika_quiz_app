package com.example.matematika;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Config extends AppCompatActivity {
    private Context myContext;
    private UsersAdapter mUsersAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<String> keys, List<User> users){

        myContext=context;
        mUsersAdapter=new UsersAdapter(users,keys);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mUsersAdapter);



    }

    class UserItemView extends RecyclerView.ViewHolder {
        private TextView Name;
        private TextView email;
        private TextView score;
        private TextView level;
        private ProgressBar progressBar;



        private String key;

        public UserItemView(ViewGroup parent) {
            super(LayoutInflater.from(myContext).
                    inflate(R.layout.userentry, parent, false));
            Name = itemView.findViewById(R.id.textname);
            email = itemView.findViewById(R.id.textemail);
            score = itemView.findViewById(R.id.textscore);
            level = itemView.findViewById(R.id.level);
            progressBar = itemView.findViewById(R.id.progressBar);




        }

        public void bind(User user, String key) {
            Name.setText(user.getSec_name());
            email.setText(user.getEmail());
            score.setText(user.getScore());
            level.setText((String.valueOf((long) (Double.parseDouble(user.getProgressBar())/(10)))));
            progressBar.setProgress(Integer.parseInt(String.valueOf((long) (Double.parseDouble(user.getProgressBar())%(10.001)))));
            progressBar.setMax(10);


            this.key = key;
        }

    }

    class UsersAdapter extends RecyclerView.Adapter<UserItemView> {
        private List<User> mUserList;
        private List<String> mKeys;

        public UsersAdapter(List<User> mUserList, List<String> mKeys) {
            Collections.sort(mUserList, new Comparator<User>() {
                @Override
                public int compare(User user, User t1) {
                    return user.score.compareToIgnoreCase(t1.score);
                }
            });
            Collections.reverse(mUserList);
            this.mUserList = mUserList;
            this.mKeys = mKeys;
                    }

        @NonNull
        @Override
        public UserItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UserItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull UserItemView holder, int position) {
            holder.bind(mUserList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mUserList.size();
        }
    }
}
