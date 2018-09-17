package com.lzhs.lzhsfoldtext;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lzhs.library.LZHSFlodText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Integer> mDatas = new ArrayList<>();
    LZHSFlodText mLZHSFlodText;
    RecyclerView mRecyclerView;
    String val = "设计模式（Design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性。 毫无疑问，设计模式于己于他人于系统都是多赢的，设计模式使代码编制真正工程化，设计模式是软件工程的基石，如同大厦的一块块砖石一样。项目中合理的运用设计模式可以完美的解决很多问题，每种模式在现在中都有相应的原理来与之对应，每一个模式描述了一个在我们周围不断重复发生的问题，以及该问题的核心解决方案，这也是它能被广泛应用的原因。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mLZHSFlodText = findViewById(R.id.mLZHSFlodText);
        mLZHSFlodText.setText(val);
        mLZHSFlodText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LZHSFlodText 被点击", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.mFrameLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FrameLayout 被点击", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 10; i++) mDatas.add(i);
        mRecyclerView.setAdapter(new DataAdapter());
    }


    class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
        @NonNull
        @Override
        public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new DataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull DataViewHolder mHolder, final int i) {

            mHolder.mLZHSFlodText.setText(val);
            mHolder.mTextAnchor.setText((mDatas.get(i).intValue() + 1) + "、 可折叠TextView");
            mHolder.mConvertView.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            Toast.makeText(MainActivity.this, "Item " + (mDatas.get(i).intValue() + 1) + " 被点击", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }

            );
            mHolder.mFrameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, (mDatas.get(i).intValue() + 1) + "FrameLayout 被点击", Toast.LENGTH_SHORT).show();
                }
            });
            mHolder.mLZHSFlodText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, (mDatas.get(i).intValue() + 1) + "LZHSFlodText 被点击", Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class DataViewHolder extends RecyclerView.ViewHolder {
            View mConvertView;
            LZHSFlodText mLZHSFlodText;
            TextView mTextAnchor;
            FrameLayout mFrameLayout;

            public DataViewHolder(@NonNull View itemView) {
                super(itemView);
                mConvertView = itemView;
                mLZHSFlodText = itemView.findViewById(R.id.mLZHSFlodText);
                mTextAnchor = itemView.findViewById(R.id.mTextAnchor);
                mFrameLayout = itemView.findViewById(R.id.mFrameLayout);
            }
        }
    }

}
