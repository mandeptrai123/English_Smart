package teamkenko.english_smart.Vocabulary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Locale;

import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.R;

public class Adapter_Recycle_Voca extends RecyclerView.Adapter<Adapter_Recycle_Voca.SimpleViewHolder> {
  Context context;
    int[] img_extend;
    String[] mains;
    String[] words;
    String [] description;
    String [] words_ex={"Hello World","Say Hello","Hello Every Body"};
    Intent mSpeechRecognizerIntent;
    TextView text_show_mic;
    int pos;
    SpeechRecognizer mSpeechRecognizer;

    public Adapter_Recycle_Voca(final Context context, int[] img_extend, String[] mains, String[] words, String[] description) {
        this.context = context;
        this.img_extend = img_extend;
        this.mains = mains;
        this.words = words;
        this.description = description;
           mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(context);
          mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en-us");
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE, "en-us");
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 500L);
        mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                Toast.makeText(context,"Result",Toast.LENGTH_SHORT).show();
                ArrayList<String> matches = bundle
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matches != null)
                {
                    text_show_mic.setText(matches.get(0).toUpperCase());
                    if (text_show_mic.getText().equals(words_ex[pos].toUpperCase()))
                    {
                        Toasty.info(context,"Good",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toasty.error(context,"Wrong",Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });
    }

    @NonNull
    @Override
    public Adapter_Recycle_Voca.SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_voca_demo, viewGroup, false);


        return new Adapter_Recycle_Voca.SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SimpleViewHolder simpleViewHolder, final int i) {
        // set listener
        // go !
        simpleViewHolder.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet ani_alter = new AnimatorSet();
                simpleViewHolder.s_1.setY(-500f);
                simpleViewHolder.s_2.setY(-500f);
                simpleViewHolder.s_3.setY(-500f);
                ani_alter.playTogether(
                        ObjectAnimator.ofFloat(simpleViewHolder.layout_two,"translationX",1000f),
                        ObjectAnimator.ofFloat(simpleViewHolder.layout_one,"translationX",0f)
                );
               ani_alter.setDuration(700);
               ani_alter.start();
            }
        });
        // back !
        simpleViewHolder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet ani_alter = new AnimatorSet();
                ani_alter.playTogether(
                        ObjectAnimator.ofFloat(simpleViewHolder.layout_two,"translationX",0f),
                        ObjectAnimator.ofFloat(simpleViewHolder.layout_one,"translationX",-1000f)
                );
                ani_alter.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        simpleViewHolder.s_1.setY(-500f);
                        simpleViewHolder.s_2.setY(-500f);
                        simpleViewHolder.s_3.setY(-500f);
                        ViewCompat.animate( simpleViewHolder.s_1).translationY(0f).setDuration(600).start();
                        ViewCompat.animate( simpleViewHolder.s_2).translationY(0f).setDuration(600).start();
                        ViewCompat.animate( simpleViewHolder.s_3).translationY(0f).setDuration(600).start();
                    }
                });
                ani_alter.setDuration(700);
                ani_alter.start();
            }
        });
        simpleViewHolder.cir_extend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.show();
                if (progressDialog.getWindow() != null) {
                    progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                progressDialog.setCancelable(true);
                progressDialog.setContentView(R.layout.item_dialog_voca);
                ListView listView = (ListView)progressDialog.findViewById(R.id.list_dialog_voca);
                listView.setY(-500f);
                ViewCompat.animate(listView).translationY(0f).setDuration(500).start();
                Adapter_List_Extend adapter = new Adapter_List_Extend(context,words_ex);
                listView.setAdapter(adapter);
            }
        });
        simpleViewHolder.cir_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.show();
                if (progressDialog.getWindow() != null) {
                    progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                progressDialog.setContentView(R.layout.item_dialog_mic);
                RelativeLayout rl = (RelativeLayout) progressDialog.findViewById(R.id.item_relative_dia_mic);
                final Button but_start_mic = (Button) progressDialog.findViewById(R.id.item_but_dialog_mic);
                  text_show_mic = (TextView) progressDialog.findViewById(R.id.item_text_dialog_mic) ;
                rl.setScaleX(0f);
                rl.setScaleY(0f);
                ViewCompat.animate(rl).scaleY(1f).scaleX(1f).setDuration(500).start();
                but_start_mic.setText("Start");
                but_start_mic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pos = i;
                        if(but_start_mic.getText().equals("Start"))
                        {
                            but_start_mic.setText("Close");
                            text_show_mic.setText("Listening................");

                            mSpeechRecognizer.startListening(mSpeechRecognizerIntent);

                        }else
                        {
                            mSpeechRecognizer.stopListening();
                            progressDialog.dismiss();
                        }
                    }
                });



            }
        });


      simpleViewHolder.cir_extend.setImageResource(img_extend[i]);
      simpleViewHolder.cir_mic.setImageResource(R.drawable.miscro_gg);
      simpleViewHolder.t_main.setText(mains[i]);
      simpleViewHolder.t_words.setText(words[i]);
      simpleViewHolder.t_des.setText(description[i]);


    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
      // init
      LottieAnimationView cir_extend;
        LottieAnimationView cir_mic;
        TextView t_first,t_main,t_words,t_des;
        ImageView go,back,s_1,s_2,s_3;
        RelativeLayout layout_one,layout_two;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            // components of relative two.
            cir_extend = (LottieAnimationView) itemView.findViewById(R.id.item_extend);
            t_first   = (TextView)  itemView.findViewById(R.id.first_time);
            go        = (ImageView) itemView.findViewById(R.id.item_alter_go);
            t_words   = (TextView)  itemView.findViewById(R.id.text_words_voca);
            s_1       = (ImageView) itemView.findViewById(R.id.star_one);
            s_2       = (ImageView) itemView.findViewById(R.id.star_two);
            s_3       = (ImageView) itemView.findViewById(R.id.star_three);
            layout_two= (RelativeLayout) itemView.findViewById(R.id.relative_two);
            // components of relative one.
            cir_mic = (LottieAnimationView) itemView.findViewById(R.id.item_mic_voca);
            t_main  = (TextView)        itemView.findViewById(R.id.item_main_voca);
            t_des   = (TextView)        itemView.findViewById(R.id.item_des_voca);
            back    = (ImageView)       itemView.findViewById(R.id.item_alter_back);
            layout_one= (RelativeLayout) itemView.findViewById(R.id.relative_one);
            layout_one.setX(-1000f);
            s_1.setY(-500f);
            s_2.setY(-500f);
            s_3.setY(-500f);
            ViewCompat.animate(s_1).translationY(0f).setDuration(600).start();
            ViewCompat.animate(s_2).translationY(0f).setDuration(600).start();
            ViewCompat.animate(s_3).translationY(0f).setDuration(600).start();

        }
    }
}
