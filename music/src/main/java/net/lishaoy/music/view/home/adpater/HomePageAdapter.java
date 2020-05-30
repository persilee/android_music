package net.lishaoy.music.view.home.adpater;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import net.lishaoy.music.model.CHANNEL;
import net.lishaoy.music.view.discory.DiscoryFragment;
import net.lishaoy.music.view.friend.FriendFragment;
import net.lishaoy.music.view.mine.MineFragment;

public class HomePageAdapter extends FragmentPagerAdapter {
    private CHANNEL[] channels;

    public HomePageAdapter(FragmentManager fm, CHANNEL[] channels) {
        super(fm);
        this.channels = channels;
    }

    @Override
    public Fragment getItem(int position) {

        int type = channels[position].getValue();

        switch (type){
            case CHANNEL.MINE_ID:
                return MineFragment.newInstance();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.newInstance();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return channels.length;
    }
}
