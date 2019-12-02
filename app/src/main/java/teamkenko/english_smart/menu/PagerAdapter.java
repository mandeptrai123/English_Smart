package teamkenko.english_smart.menu;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import teamkenko.english_smart.Event.Event_Main;
import teamkenko.english_smart.Solo_Words.DauChu_Main;
import teamkenko.english_smart.ThanhTich.Rank_Demo;

public class PagerAdapter extends FragmentStatePagerAdapter {

    PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new DauChu_Main();
                break;
            case 1:
                frag = new Menu_Main();
                break;
            case 2:
                frag = new Event_Main();
                break;
            case 3:
              frag = new Rank_Demo();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        return title;
    }
}
