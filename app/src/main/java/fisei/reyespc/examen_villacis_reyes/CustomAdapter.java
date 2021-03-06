package fisei.reyespc.examen_villacis_reyes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Integer> numeros;

    public CustomAdapter(Context context, ArrayList<Integer> numeros) {
        this.context = context;
        this.numeros = numeros;
    }

    @Override
    public int getCount() {
        return numeros.size();
    }

    @Override
    public Object getItem(int i) {
        return numeros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public ArrayList<Integer> getDataRV(){
        return this.numeros;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView edtNumero;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_numeros_rv, null);
        }
        edtNumero = view.findViewById(R.id.textViewNumero);
        edtNumero.setText(numeros.get(i).toString());

        return view;
    }
}
