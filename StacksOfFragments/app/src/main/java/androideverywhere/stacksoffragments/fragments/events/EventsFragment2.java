package androideverywhere.stacksoffragments.fragments.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androideverywhere.stacksoffragments.R;
import androideverywhere.stacksoffragments.constants.Constants;
import androideverywhere.stacksoffragments.fragments.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EventsFragment2 extends BaseFragment {

    private View view;

    @BindView(R.id.btnNext)
    Button btnNext;

    @OnClick(R.id.btnNext)
    void onNextClick() {
         mActivity.pushFragments(Constants.mCurrentTab,EventsFragment3.newInstance(),true,true);
    }

    public EventsFragment2() {
    }

    public static EventsFragment2 newInstance() {
        EventsFragment2 fragment = new EventsFragment2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_events_2, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


}
