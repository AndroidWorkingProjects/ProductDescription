package productdescription.rahul.com.productdescription;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hadoop on 25/4/16.
 */
public class ImagePreview extends Activity {

    ViewPager viewPager;
    CustomPagerAdapter customPagerAdapter;
    ImageView close;

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.imagepreview);

        close = (ImageView)findViewById(R.id.close);

        int resources[] = getIntent().getExtras().getIntArray("resources");
        int current = getIntent().getExtras().getInt("current");

        customPagerAdapter = new CustomPagerAdapter(ImagePreview.this);
        customPagerAdapter.setResources(resources);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(customPagerAdapter);
        viewPager.setCurrentItem(current);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.noanim,R.anim.popoutclose);
            }
        });
    }
}
