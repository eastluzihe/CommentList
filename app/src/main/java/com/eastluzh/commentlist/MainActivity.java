package com.eastluzh.commentlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eastluzh.commentlist.adapter.CommentAdapter;
import com.eastluzh.commentlist.entity.CommentBaseItemEntity;

import java.util.ArrayList;
import java.util.List;

import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.CLOSE;
import static com.eastluzh.commentlist.entity.CommentBaseItemEntity.LINE;

/**
 * Describe： 仿抖音评论列表
 *
 * @author 路平[1611159036@qq.com] at 2021/5/15 10:59
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_view;
    private CommentAdapter mAdapter = null;
    /**
     * 二级评论 展示限制按钮最小值 最小不小于1
     */
    private int minLimitNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_view = findViewById(R.id.rv_view);
        mAdapter = new CommentAdapter(null, minLimitNum);
        rv_view.setLayoutManager(new LinearLayoutManager(this));
        rv_view.setAdapter(mAdapter);
        setAdapter();
    }

    private void setAdapter() {
        List<CommentBaseItemEntity> list = new ArrayList<>();
        //top
        CommentBaseItemEntity topBean = new CommentBaseItemEntity();
        topBean.setLayout(CommentBaseItemEntity.TOP);
        topBean.setId(1);
        topBean.setName("路平");
        list.add(topBean);
        //一级评论
        for (int i = 0; i < 10; i++) {
            CommentBaseItemEntity parentBean = new CommentBaseItemEntity();
            parentBean.setLayout(CommentBaseItemEntity.PARENT_COMMENT);
            parentBean.setId(i + 1);
            parentBean.setName("路平的一级评论");
            list.add(parentBean);
            List<CommentBaseItemEntity> moreSonList = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                CommentBaseItemEntity sonBean = new CommentBaseItemEntity();
                sonBean.setLayout(CommentBaseItemEntity.SON_COMMENT);
                sonBean.setId(20 + j);
                sonBean.setName("路平的二级评论");
                sonBean.setPos(j);
                if (j > minLimitNum - 1 && 6 > minLimitNum) {
                    moreSonList.add(sonBean);
                } else {
                    list.add(sonBean);
                }
            }
            if (6 > minLimitNum) {
                CommentBaseItemEntity moreBean = new CommentBaseItemEntity();
                moreBean.setLayout(CLOSE);
                moreBean.setMoreSon(moreSonList);
                list.add(moreBean);
            }
        }
        //分割线
        CommentBaseItemEntity lineBean = new CommentBaseItemEntity();
        lineBean.setLayout(LINE);
        list.add(lineBean);
        mAdapter.setNewInstance(list);
    }

}