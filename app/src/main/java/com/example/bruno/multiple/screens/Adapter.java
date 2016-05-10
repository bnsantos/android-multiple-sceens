package com.example.bruno.multiple.screens;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bruno on 10/05/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
  private List<String> urls;

  public Adapter(String[] urls) {
    this.urls = Arrays.asList(urls);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false));
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(Integer.toString(position), urls.get(position));
  }

  @Override
  public int getItemCount() {
    return urls.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder{
    private final TextView position;
    private final TextView text;
    private final TextView url;
    private final SimpleDraweeView image;

    public ViewHolder(View itemView) {
      super(itemView);
      position = (TextView) itemView.findViewById(R.id.position);
      text = (TextView) itemView.findViewById(R.id.text);
      url = (TextView) itemView.findViewById(R.id.url);
      image = (SimpleDraweeView) itemView.findViewById(R.id.image);
    }

    public void bind(String position, String url){
      int width = 500, height = 500;
      ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
          .setResizeOptions(new ResizeOptions(width, height))
          .build();
      PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
          .setOldController(image.getController())
          .setImageRequest(request)
          .build();
      image.setController(controller);

      this.position.setText(position);
      this.text.setText(R.string.lorem_ipsum);
      this.url.setText(url);
    }
  }
}
