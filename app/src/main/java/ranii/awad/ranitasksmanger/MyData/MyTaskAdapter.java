package raniawad.myapplication.MyData;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ranii.awad.ranitasksmanger.R;

public class MyTaskAdapter extends ArrayAdapter<MyTask> {
    public MyTaskAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //View v=View.inflate(getContext(), R.layout.task_item_layout,parent);
        View v= LayoutInflater.from(getContext()).inflate(R.layout.task_item_layout,parent,false);

        MyTask item = getItem(position);
        TextView title=v.findViewById(R.id.itmTaskTitle);
        TextView subject=v.findViewById(R.id.itmTaskSubject);
        ImageView delete=v.findViewById(R.id.itmBtndel);
        ImageView call=v.findViewById(R.id.itmBtncall);
        ImageView edit=v.findViewById(R.id.itmBtnEdit);
        RatingBar RatingBar=v.findViewById(R.id.itmRating);
        ImageView image=v.findViewById(R.id.itmImg);

        //وضع قيك المعطى المسترج على كائنات الواجهه
        title.setText(item.getTitle());
        subject.setText(item.getSubject());
        RatingBar.setRating(5*(item.getImportant()/(float)10));

        if(item.getImage()==null || item.getImage().length()==0)
        {
          image.setImageResource(R.mipmap.my_logo);
        }
        else
        {
            //todo deal with image
        }


        return v;

    }
}
