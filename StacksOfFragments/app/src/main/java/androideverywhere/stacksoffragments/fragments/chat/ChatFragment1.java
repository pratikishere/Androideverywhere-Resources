package androideverywhere.stacksoffragments.fragments.chat;

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


public class ChatFragment1 extends BaseFragment {

    private View view;

    @BindView(R.id.btnNext)
    Button btnNext;

    @OnClick(R.id.btnNext)
    void onNextClick() {
        mActivity.pushFragments(Constants.mCurrentTab,ChatFragment2.newInstance(),true,true);
    }

    public ChatFragment1() {
    }

    public static ChatFragment1 newInstance() {
        ChatFragment1 fragment = new ChatFragment1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat_1, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


}
