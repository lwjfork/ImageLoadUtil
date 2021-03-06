package com.lwj.image.glide;

import com.lwj.image.download.ILoadImageUrlConverter;

/**
 * Created:2018/7/2
 * User：lwjfork
 * Email:lwjfork@gmail.com
 * Des:
 * ====================
 */

 public class GlideUrlConverter implements ILoadImageUrlConverter{

     @Override
     public String convertNetUrl(String url) {
        return url;
    }

      @Override
    public String convertFile(String filePath) {
        return filePath;
    }


      @Override
    public String convertContent(String contentPath) {
        return null;
    }


      @Override
    public String convertAssets(String assets) {
        return "file:///android_asset/" + assets;
    }


      @Override
    public String convertDrawable(String drawable) {
        return drawable;
    }
}
