package com.lee.bitmapfun;

import android.view.View;

public interface IImageViewerListener
{
    public void onImageSelectedChanged(View v, int position, MediaInfo media);
    public void onSearchCompleted(int nCount);
}
