package com.paking.team.colorpopup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.paking.team.colorpopup.data.ColorData;
import com.paking.team.colorpopup.modal.ColorModal;

import java.util.ArrayList;

/**
 * Created by fcsdev on 1/7/17.
 */
//List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.Lines));

public class ChangeColorApdater extends BaseAdapter {
    ViewbHoler viewbHoler;
    ArrayList<ColorModal> colorList = null;
    Context context;

    public ChangeColorApdater() {
        if (colorList == null)
            colorList = new ArrayList<>();

    }

    public void setlistAdapter(ArrayList<ColorModal> colorList) {
        this.colorList = colorList;
        this.notifyDataSetChanged();
    }

    public void updateItemByPos(int pos, ColorModal value) {
        colorList.set(pos, value);
        this.notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return colorList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private View view;
    ColorData colorData;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (context == null) {
            context = viewGroup.getContext();
            colorData = new ColorData(context);
        }

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_color, viewGroup, false);
            viewbHoler = new ViewbHoler();
            viewbHoler.imgColorSelected = (ImageView) view.findViewById(R.id.imgColorSelectTeb);
            viewbHoler.colorItem = view.findViewById(R.id.colorViewItem);
            view.setTag(viewbHoler);
        } else {
            viewbHoler = (ViewbHoler) view.getTag();
        }

        ColorModal colorModal = colorList.get(i);
        ChangeColor(colorModal.getColor());
        Glide.with(viewGroup.getContext()).load(R.drawable.ic_colorpicker_swatch_selected).into(viewbHoler.imgColorSelected);
        if (colorData.getColorIsChecked().getPosition() == i && colorData.getColorIsChecked().isCheck()) {
            viewbHoler.imgColorSelected.setVisibility(View.VISIBLE);
        } else {
            viewbHoler.imgColorSelected.setVisibility(View.GONE);
        }

        return view;
    }

    // this function  change color for draweble
    private void ChangeColor(String color) {
        GradientDrawable colorDraweble = (GradientDrawable) viewbHoler.colorItem.getBackground();
        colorDraweble.setColor(Color.parseColor(color));
    }

    private class ViewbHoler {
        ImageView imgColorSelected;
        View colorItem;
        public void oncreateItem(View view) {

        }
    }

}
