package cn.syf.studyarchitecture.java;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.syf.studyarchitecture.R;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月28日17时17分
 * E-mail  : jason_sunyf@163.com
 */
public class JavaCustomAdapter extends PagedListAdapter<JavaDataBean, JavaCustomAdapter.JavaCustomViewHolder> {


    JavaCustomAdapter(@NonNull DiffUtil.ItemCallback<JavaDataBean> diffCallback) {
        super(diffCallback);
    }

    JavaCustomAdapter(@NonNull AsyncDifferConfig<JavaDataBean> config) {
        super(config);
    }

    @NonNull
    @Override
    public JavaCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new JavaCustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JavaCustomViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }

    public static DiffUtil.ItemCallback<JavaDataBean> diffCallback() {
        return new DiffUtil.ItemCallback<JavaDataBean>() {
            @Override
            public boolean areItemsTheSame(JavaDataBean oldItem, JavaDataBean newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(JavaDataBean oldItem, JavaDataBean newItem) {
                return oldItem == newItem;
            }
        };
    }


    class JavaCustomViewHolder extends RecyclerView.ViewHolder {
        JavaDataBean dataBean;
        TextView name;

        void bindTo(JavaDataBean item) {
            this.dataBean = item;
            name.setText(item.getName());
        }

        JavaCustomViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
