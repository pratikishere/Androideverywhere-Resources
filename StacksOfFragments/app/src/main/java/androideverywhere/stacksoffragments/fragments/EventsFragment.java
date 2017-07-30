package androideverywhere.stacksoffragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androideverywhere.stacksoffragments.R;
import androideverywhere.stacksoffragments.constants.Constants;
import androideverywhere.stacksoffragments.fragments.events.EventsFragment1;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EventsFragment extends BaseFragment {

    private View view;

    @BindView(R.id.btnNext)
    Button btnNext;

    @OnClick(R.id.btnNext)
    void onNextClick() {
        mActivity.pushFragments(Constants.mCurrentTab,EventsFragment1.newInstance(),true,true);
    }

    public EventsFragment() {
        // Required empty public constructor
    }

    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
