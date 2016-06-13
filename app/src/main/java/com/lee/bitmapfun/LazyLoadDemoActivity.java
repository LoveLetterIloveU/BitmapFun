package com.lee.bitmapfun;

import com.lee.bitmapfun.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LazyLoadDemoActivity extends Activity
{
    TosImageViewer m_imageViewer2 = null;
    String m_countText = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main2);
        
        m_imageViewer2 = (TosImageViewer)findViewById(R.id.image_viewer);
        
        findViewById(R.id.load_image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final View view = v;
                final TextView textView = (TextView)findViewById(R.id.textView_imgCount);
                view.setEnabled(false);
                textView.setText("Loading images, please wait...");
                
                m_imageViewer2.updateImageViewer();
                m_imageViewer2.setImageViewerListener(new IImageViewerListener()
                {
                    @Override
                    public void onSearchCompleted(int nCount)
                    {
                        m_countText = "Image Count = " + nCount;
                        textView.setText(m_countText);
                        view.setEnabled(true);
                    }
                    
                    @Override
                    public void onImageSelectedChanged(View v, int position, MediaInfo media)
                    {
                        textView.setText(m_countText + "\t Select image, path = " + media.getFileName());
                    }
                });
            }
        });
        
        findViewById(R.id.reset_image).setVisibility(View.GONE);
        findViewById(R.id.reset_image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //MiniThumbFile.reset();
                m_imageViewer2.updateGridview();
            }
        });
    }
}
