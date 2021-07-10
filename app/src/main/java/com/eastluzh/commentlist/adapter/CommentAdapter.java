package com.eastluzh.commentlist.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.eastluzh.commentlist.R;
import com.eastluzh.commentlist.entity.CommentBaseItemEntity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.CLOSE;
import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.EMPTY;
import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.LINE;
import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.PARENT_COMMENT;
import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.SHOW;
import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.SON_COMMENT;
import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.TOP;

/**
 * Describe： 评论适配器
 *
 * @author 路平[1611159036@qq.com] at 2021/5/15 13:38
 */
public class CommentAdapter extends BaseMultiItemQuickAdapter<CommentBaseItemEntity, BaseViewHolder> {

    private int mMinLimit;

    public CommentAdapter(@Nullable List<CommentBaseItemEntity> data, int mMinLimit) {
        super(data);
        this.mMinLimit = mMinLimit;
        addItemType(PARENT_COMMENT, R.layout.item_comment_parent);
        addItemType(SON_COMMENT, R.layout.item_comment_son);
        addItemType(LINE, R.layout.item_comment_line);
        addItemType(TOP, R.layout.item_comment_top);
        addItemType(CLOSE, R.layout.item_comment_close_show);
        addItemType(SHOW, R.layout.item_comment_close_show);
        addItemType(EMPTY, R.layout.item_comment_empty);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, CommentBaseItemEntity item) {
        switch (holder.getItemViewType()) {
            case PARENT_COMMENT:
                holder.setText(R.id.tv_name, item.getName());
                break;
            case SON_COMMENT:
                holder.setText(R.id.tv_name, item.getName());
                break;
            case TOP:
                break;
            case CLOSE:
                holder.setText(R.id.tv_status, String.format("展开%s条回复", 2));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.setLayout(SHOW);
                        getData().addAll(holder.getLayoutPosition(), item.getMoreSon());
                        item.setPos(mMinLimit - 1 + item.getMoreSon().size());
                        notifyDataSetChanged();
                    }
                });
                break;
            case SHOW:
                holder.setText(R.id.tv_status, "收起");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        item.setLayout(CLOSE);
                        getData().removeAll(item.getMoreSon());
                        item.setPos(mMinLimit - 1);
                        notifyDataSetChanged();
                    }
                });
                break;
            default:
                break;
        }
    }
}
