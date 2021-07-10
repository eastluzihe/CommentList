package com.eastluzh.commentlist.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Describe：评论base实体
 *
 * @author 路平[1611159036@qq.com] at 2021/5/15 11:06
 */
public class CommentBaseItemEntity implements MultiItemEntity {
    private int pos;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public int getItemType() {
        return layout;
    }

    public final static int PARENT_COMMENT = 0;
    public final static int SON_COMMENT = 1;
    public final static int LINE = 2;
    public final static int TOP = 3;
    public final static int CLOSE = 4;
    public final static int SHOW = 5;
    public final static int EMPTY = 6;

    private int layout;

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    private int id;
    private String name;

    private List<CommentBaseItemEntity> moreSon;

    public List<CommentBaseItemEntity> getMoreSon() {
        return moreSon;
    }

    public void setMoreSon(List<CommentBaseItemEntity> moreSon) {
        this.moreSon = moreSon;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CommentBaseItemEntity sonBean = (CommentBaseItemEntity) o;
//        return id == sonBean.id;
//    }
//
//    @SuppressLint("NewApi")
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

}
