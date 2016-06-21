package badassapps.aaron.spindown;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aaron on 6/17/2016.
 */
public class LifeCounterFragment extends Fragment {

    Button getBottomRight, getBottomLeft, getTopRight, getTopLeft;
//    TextView getTopPlayerTop, getTopPlayerBottom, getBottomPlayerBottom, getBottomPlayerTop;
    TextView tv;
    int counterPlayerOne, counterPlayerTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counterPlayerOne = 0;
        counterPlayerTwo = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.life_counter_fragment, container, false);

//      Left: + | Right: -
        getBottomRight = (Button) view.findViewById(R.id.bottomRight);
        getBottomLeft = (Button) view.findViewById(R.id.bottomLeft);
        getTopRight = (Button) view.findViewById(R.id.topRight);
        getTopLeft = (Button) view.findViewById(R.id.topLeft);
        tv = (TextView) view.findViewById(R.id.textView);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "YouRookMarbelous.ttf");
        getBottomRight.setTypeface(tf);
        getBottomLeft.setTypeface(tf);
        getTopRight.setTypeface(tf);
        getTopLeft.setTypeface(tf);
        tv.setTypeface(tf);

//        getTopPlayerTop = (TextView) view.findViewById(R.id.topPlayerTop);
//        getTopPlayerBottom = (TextView) view.findViewById(R.id.topPlayerBottom);
//        getBottomPlayerTop = (TextView) view.findViewById(R.id.bottomPlayerTop);
//        getBottomPlayerBottom = (TextView) view.findViewById(R.id.bottomPlayerBottom);

        //Add to 2nd player life
        getBottomLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counterPlayerTwo+=1;
                String counter = Integer.toString(counterPlayerTwo);
                tv.setText(counter);
            }
        });

        //Subtract to 2nd player life
        getBottomRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counterPlayerTwo-=1;
                String counter = Integer.toString(counterPlayerTwo);
                tv.setText(counter);
            }
        });

        //Add to 1st player life
        getTopLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counterPlayerOne+=1;
                String counter = Integer.toString(counterPlayerOne);
                tv.setText(counter);

            }
        });

        //Subtract to 1st player life
        getTopRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                counterPlayerOne-=1;
                String counter = Integer.toString(counterPlayerOne);
                tv.setText(counter);
            }
        });

        return view;
    }
}
