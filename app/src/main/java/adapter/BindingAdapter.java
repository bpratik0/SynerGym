package adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BindingAdapter {
    @androidx.databinding.BindingAdapter("loadImage")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView).load(url).centerCrop().into(imageView);
    }

    @androidx.databinding.BindingAdapter("loadDetailsImage")
    public static void loadDetailsImage(ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
    }

}
