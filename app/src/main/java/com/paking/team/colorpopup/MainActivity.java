package com.paking.team.colorpopup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.paking.team.colorpopup.data.ColorData;
import com.paking.team.colorpopup.modal.ColorModal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int i;
    ColorModal colorModal;
    TextView txt;
    GridView gricColor;
    ArrayList<ColorModal> colorModals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        colorModals = new ArrayList<>();
        setContentView(R.layout.activity_main);
        final ColorData colorData = new ColorData(this);
        List<String> colorStringList = Arrays.asList(getResources().getStringArray(R.array.color_array));

        final ChangeColorApdater changeColorApdater = new ChangeColorApdater();

        gricColor = (GridView) findViewById(R.id.gricColor);
        final ArrayList<ColorModal> colorModals = new ArrayList<>();

        colorModal = new ColorModal();
        int i = 0;

        for (String color : colorStringList) {
            colorModal = new ColorModal();
            colorModal.setColor(color);
            colorModal.setCheck(false);
            colorModal.setPosition(i);
            colorModals.add(colorModal);
            i++;
        }

        changeColorApdater.setlistAdapter(colorModals);
        gricColor.setAdapter(changeColorApdater);

        gricColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                colorData.setIsckeckColor(new ColorModal(colorModals.get(i).getColor(), i, true));
                changeColorApdater.notifyDataSetChanged();


            }
        });
    }

}
