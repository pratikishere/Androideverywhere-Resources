package androideverywhere.stacksoffragments.fragments.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androideverywhere.stacksoffragments.R;
import androideverywhere.stacksoffragments.fragments.BaseFragment;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EventsFragment3 extends BaseFragment {

    private View view;

    @OnClick(R.id.btnClear) void onClear(){
        mActivity.clearStack();
    }

    public EventsFragment3() {
    }

    public static EventsFragment3 newInstance() {
        EventsFragment3 fragment = new EventsFragment3();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_events_3, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
