package com.lwj.image.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.lwj.image.download.DownLoadListener;
import com.lwj.image.helper.IImageDownLoaderHelper;

/**
 * Created:2018/7/2
 * User：lwjfork
 * Email:lwjfork@gmail.com
 * Des:
 * ====================
 */

public class GlideDownLoader implements IImageDownLoaderHelper {


    @Override
    public void downLoad(Context context, String url, DownLoadListener listener) {
        Glide.with(context).asBitmap().load(url).into(getTarget(listener));
    }


    @Override
    public void downLoad(Fragment fragment, String url, DownLoadListener listener) {
        Glide.with(fragment).asBitmap().load(url).into(getTarget(listener));
    }




    private SimpleTarget<Bitmap> getTarget(DownLoadListener listener) {
        return new SimpleTarget<Bitmap>() {

            @Override
            public void onStart() {
                super.onStart();
                if (listener != null) {
                    listener.onStart();
                }
            }

            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                if (listener != null) {
                    listener.onSuccess(resource);
                }
            }
        };
    }
}
