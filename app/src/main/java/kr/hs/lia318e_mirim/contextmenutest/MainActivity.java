package kr.hs.lia318e_mirim.contextmenutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout Linear; // 전역 변수
    Button but2;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1 = (Button)findViewById(R.id.but1);
        but2 = (Button)findViewById(R.id.but2);

        // 버튼을 길게 누르면 ContextMenu가 나온다.
        registerForContextMenu(but1);
        registerForContextMenu(but2);

        Linear = (LinearLayout) findViewById(R.id.Linear);
        img1 = (ImageView) findViewById(R.id.img1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        if(v.getId() == R.id.but1){
            menu.setHeaderTitle("배경색");
            menu.setHeaderIcon(R.drawable.icon1);
            menuInflater.inflate(R.menu.menu1, menu);
        } // end of if

        if(v.getId() == R.id.but2){
            menuInflater.inflate(R.menu.menu2, menu);
        } // end of if
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.menu1_item_red:
                Linear.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu1_item_blue:
                Linear.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menu1_item_pink:
                Linear.setBackgroundColor(Color.rgb(255,178,245)); // 메소드 사용 색 지정
                return true;

            case R.id.menu2_item_rotation:
                img1.setRotation(img1.getRotationX()+90);
                return true;
            case R.id.menu2_item_size:
                img1.setScaleX(img1.getScaleX()*1.5f); // 실수형 => f
                img1.setScaleY(img1.getScaleY()*1.5f);;
                return true;
        } // end of switch

        return false;
    }
}