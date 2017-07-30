package androideverywhere.stacksoffragments.fragments.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androideverywhere.stacksoffragments.R;
import androideverywhere.stacksoffragments.fragments.BaseFragment;
import butterknife.ButterKnife;


public class ChatFragment2 extends BaseFragment {

    private View view;

    public ChatFragment2() {
    }

    public static ChatFragment2 newInstance() {
        ChatFragment2 fragment = new ChatFragment2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chat_2, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


}
