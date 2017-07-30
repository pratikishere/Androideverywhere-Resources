package androideverywhere.stacksoffragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Stack;

import androideverywhere.stacksoffragments.constants.Constants;
import androideverywhere.stacksoffragments.fragments.BaseFragment;
import androideverywhere.stacksoffragments.fragments.ChatFragment;
import androideverywhere.stacksoffragments.fragments.EventsFragment;
import androideverywhere.stacksoffragments.fragments.HomeFragment;
import androideverywhere.stacksoffragments.fragments.ProfileFragment;
import androideverywhere.stacksoffragments.fragments.SearchFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabsActivity extends AppCompatActivity {

    public boolean doubleBackToExitPressedOnce = false;

    @BindView(R.id.llHome) LinearLayout llHome;
    @BindView(R.id.llEvents) LinearLayout llEvents;
    @BindView(R.id.llSearch) LinearLayout llSearch;
    @BindView(R.id.llChat) LinearLayout llChat;
    @BindView(R.id.llProfile) LinearLayout llProfile;

    @OnClick(R.id.llHome) void onClickHome(){
        setSelectedTab(Constants.TAB_HOME);
    }

    @OnClick(R.id.llEvents) void onClickEvents(){
        setSelectedTab(Constants.TAB_EVENTS);
    }

    @OnClick(R.id.llSearch) void onClickSearch(){
        setSelectedTab(Constants.TAB_SEARCH);
    }

    @OnClick(R.id.llChat) void onClickChat(){
        setSelectedTab(Constants.TAB_CHAT);
    }

    @OnClick(R.id.llProfile) void onClickProfile(){
        setSelectedTab(Constants.TAB_PROFILE);
    }

    /* A HashMap of stacks, where we use tab identifier as keys.. */
    public HashMap<String, Stack<Fragment>> mStacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        setSelectedTab(Constants.mCurrentTab);
    }

    @Override
    public void onBackPressed() {
        if (((BaseFragment) mStacks.get(Constants.mCurrentTab).lastElement()).onBackPressed() == false) {
			/*
			 * top fragment in current tab doesn't handles back press, we can do our thing, which is
			 *
			 * if current tab has only one fragment in stack, ie first fragment is showing for this tab. finish the activity else pop to previous fragment in stack for the same tab
			 */
            if (mStacks.get(Constants.mCurrentTab).size() == 1) {
//                super.onBackPressed(); // or call finish..
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                    return;
                }

                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this,"Tap again to exit StacksOfFragments",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            } else {
                popFragments(true);
            }
        } else {
            // do nothing.. fragment already handled back button press.
        }
    }

	/*
	 * Imagine if you wanted to get an image selected using ImagePicker intent to the fragment. Of course I could have created a public function in that fragment, and called it from
	 * the activity. But couldn't resist myself.
	 */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mStacks.get(Constants.mCurrentTab).size() == 0) {
            return;
        }
		/* Now current fragment on screen gets onActivityResult callback.. */
        mStacks.get(Constants.mCurrentTab).lastElement().onActivityResult(requestCode, resultCode, data);
    }

    private void init(){
        mStacks = new HashMap<>();
        mStacks.put(Constants.TAB_HOME, new Stack<Fragment>());
        mStacks.put(Constants.TAB_EVENTS, new Stack<Fragment>());
        mStacks.put(Constants.TAB_SEARCH, new Stack<Fragment>());
        mStacks.put(Constants.TAB_CHAT, new Stack<Fragment>());
        mStacks.put(Constants.TAB_PROFILE, new Stack<Fragment>());
    }

    private void setSelectedTab(String tabId){
        llHome.setSelected(false);
        llEvents.setSelected(false);
        llSearch.setSelected(false);
        llChat.setSelected(false);
        llProfile.setSelected(false);

        if (tabId.equals(Constants.TAB_HOME)) {
            llHome.setSelected(true);
        } else if (tabId.equals(Constants.TAB_EVENTS)) {
            llEvents.setSelected(true);
        } else if (tabId.equals(Constants.TAB_SEARCH)) {
            llSearch.setSelected(true);
        } else if (tabId.equals(Constants.TAB_CHAT)) {
            llChat.setSelected(true);
        } else if (tabId.equals(Constants.TAB_PROFILE)) {
            llProfile.setSelected(true);
        }

        Constants.mCurrentTab = tabId;
        if (mStacks.get(tabId).size() == 0) {
                /*
                 * First time this tab is selected. So add first fragment of that tab. Dont need animation, so that argument is false. We are adding a new fragment which is not
				 * present in stack. So add to stack is true.
				 */
            if (tabId.equals(Constants.TAB_HOME)) {
                pushFragments(tabId, new HomeFragment(), false, true);
            } else if (tabId.equals(Constants.TAB_EVENTS)) {
                pushFragments(tabId, new EventsFragment(), false, true);
            } else if (tabId.equals(Constants.TAB_SEARCH)) {
                pushFragments(tabId, new SearchFragment(), false, true);
            } else if (tabId.equals(Constants.TAB_CHAT)) {
                pushFragments(tabId, new ChatFragment(), false, true);
            } else if (tabId.equals(Constants.TAB_PROFILE)) {
                pushFragments(tabId, new ProfileFragment(), false, true);
            }

        } else {
            pushFragments(tabId, mStacks.get(tabId).lastElement(), false, false);
        }
    }

    public void pushFragments(String tag, Fragment fragment, boolean shouldAnimate, boolean shouldAdd) {
        if (shouldAdd)
        mStacks.get(tag).push(fragment);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (shouldAnimate)
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);

        ft.replace(R.id.fragmentContainer, fragment,fragment.getClass().getSimpleName());
        ft.commitAllowingStateLoss();
    }

    public void popFragments(boolean shouldAnimate) {
		/*
		 * Select the second last fragment in current tab's stack.. which will be shown after the fragment transaction given below
		 */
        Fragment fragment = mStacks.get(Constants.mCurrentTab).elementAt(mStacks.get(Constants.mCurrentTab).size() - 2);

		/* pop current fragment from stack.. */
        mStacks.get(Constants.mCurrentTab).pop();

		/* We have the target fragment in hand.. Just show it.. Show a standard navigation animation */
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (shouldAnimate)
        ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);

        ft.replace(R.id.fragmentContainer, fragment);
        ft.commitAllowingStateLoss();
    }

    public void clearStack() {
		mStacks.get(Constants.mCurrentTab).clear();
        setSelectedTab(Constants.mCurrentTab);
    }

    public void goToFragment(String fragmentName){
        for (int i = 0; i < mStacks.get(Constants.mCurrentTab).size() ; i++) {
            if(mStacks.get(Constants.mCurrentTab).get(i).getClass().getSimpleName().equalsIgnoreCase(fragmentName)){
                Fragment fragment = mStacks.get(Constants.mCurrentTab).get(i);
                clearStack();
                pushFragments(Constants.mCurrentTab,fragment,false,true);
            }
        }
    }
}
