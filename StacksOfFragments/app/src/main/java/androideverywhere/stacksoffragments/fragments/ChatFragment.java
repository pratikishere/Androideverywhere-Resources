package androideverywhere.stacksoffragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androideverywhere.stacksoffragments.R;
import androideverywhere.stacksoffragments.constants.Constants;
import androideverywhere.stacksoffragments.fragments.chat.ChatFragment1;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ChatFragment extends BaseFragment{
    public View view;

    @BindView(R.id.btnNext)
    Button btnNext;

    @OnClick(R.id.btnNext)
    void onNextClick() {
        mActivity.pushFragments(Constants.mCurrentTab, ChatFragment1.newInstance(),true,true);
    }

    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        mActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
