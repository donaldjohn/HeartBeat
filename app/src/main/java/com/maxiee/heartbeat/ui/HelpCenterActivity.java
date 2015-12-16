package com.maxiee.heartbeat.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.maxiee.heartbeat.R;
import com.maxiee.heartbeat.ui.adapter.HelpListAdapter;
import com.maxiee.heartbeat.ui.common.BaseActivity;
import com.maxiee.heartbeat.ui.common.RecyclerInsetsDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by maxiee on 15/12/15.
 */
public class HelpCenterActivity extends BaseActivity {

    public static final String[] TITLES = new String[] {
            /*1: */ "开启心动之旅"
    };

    public static final String[] DESCRIPTIONS = new String[] {
            /*1: */ "心动是一款怎样的记录软件?背后的理念如何?本文将一一进行阐述……"
    };

    public static final String[] FILENAMES = new String[] {
            /*1: */ "2333.html"
    };

    @Bind(R.id.toolbar)         Toolbar         mToolbar;
    @Bind(R.id.recyclerview)    RecyclerView    mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.helpcenter));

        HelpListAdapter adapter = new HelpListAdapter(TITLES, DESCRIPTIONS, FILENAMES);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerInsetsDecoration(this));
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}