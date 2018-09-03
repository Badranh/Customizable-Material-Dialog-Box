package net.cryptobrewery.materialdialogboxlibrary;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

/**
 * Created by Hasan Badran on 9/2/2018.
 */

public class MaterialDialog extends DialogFragment {
    public enum Anims {SLIDE_UP_DOWN,BOUNCE_SLIDE_DOWN,BLINK_SLIDEDOWN,FADE_IN_SLIDEDOWN,ROTATE_SLIDEDOWN
                    ,ZOOMIN_SLIDEDOWN,FADE_IN_FADE_OUT,BLINK_FADE_OUT,BOUNCE_FADE_OUT,ROTATE_FADE_OUT,
                    SLIDE_UP_FADE_OUT,ZOOMIN_FADE_OUT,ZoomIn_ZoomOut,SLIDE_UP_TRANSLATE,BOUNCE_TRANSLATE,BLINK_TRANSLATE,FADE_IN_TRANSLATE,ROTATE_TRANSLATE
                    ,ZOOMIN_TRANSLATE,SLIDE_UP_FLIP,BOUNCE_FLIP,BLINK_FLIP,FADE_IN_FLIP,ROTATE_FLIP,ZOOMIN_FLIP}

    //TODO:Move Dialog States
    public enum DialogState {SUCCESS,FAILURE,WARNING}
    public enum textStyle {BOLD,ITALIC,NORMAL,BOLD_ITALIC}
    private int reference,ImageReference;
    private String Message,PostiveBtnText="Yes",NegativeBtnText="No",MessageHex="#000000",TitleText="Title",TitleHex="#A3A3A3",btnPositiveColor,btnNegativeColor
            ,btnPositiveBgColor,btnNegativeBgColor;
    private float textSize=0,TitleSize=0,cardRadius;
    private boolean CardRadiusSet = false;
    private textStyle chosenTitleStyle,chosenMessageStyle;
    private Drawable DialogImageDrawable = null;
    private View.OnClickListener PostiveListener=null,NegativeListener=null;
    private Button btnPositive,btnNegative;
    private AlertDialog.Builder builder;
    private TextView MessageContainer,TitleContainer;
    private ImageView DialogImage;
    private boolean isCanceleable;
    private View mView;
    private boolean isImageReferenceSet = false;
    private Typeface titleFont,MessageFont;
    private CardView Originalview;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog,null);

        if(mView !=null)
            view = mView;
        else {
            Originalview = (CardView) view;
            MessageContainer = view.findViewById(R.id.msg);
            btnNegative = view.findViewById(R.id.BtnNegative);
            btnPositive = view.findViewById(R.id.BtnPostive);
            DialogImage = view.findViewById(R.id.IMG);
            TitleContainer = view.findViewById(R.id.title);
            TitleContainer.setText(TitleText);
            MessageContainer.setText(Message);
            if (TitleSize != 0)
                TitleContainer.setTextSize(TitleSize);
        }
        builder.setView(view);
        builder.setCancelable(isCanceleable);
        return builder.create();
    }
    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow()
                .getAttributes().windowAnimations = reference;
        if(mView == null) {
            if (PostiveListener == null) {
                btnPositive.setVisibility(View.INVISIBLE);
            } else {
                btnPositive.setOnClickListener(PostiveListener);
                btnPositive.setText(PostiveBtnText);
            }
            if (NegativeListener == null) {
                btnNegative.setVisibility(View.INVISIBLE);
            } else {
                btnNegative.setOnClickListener(NegativeListener);
                btnNegative.setText(NegativeBtnText);
            }
            if (textSize != 0)
                MessageContainer.setTextSize(textSize);
            if (MessageHex != null)
                MessageContainer.setTextColor(Color.parseColor(MessageHex));
            if (isImageReferenceSet)
                DialogImage.setImageResource(ImageReference);

            if (DialogImageDrawable != null) {
                DialogImage.setImageDrawable(DialogImageDrawable);
            }
            if (titleFont != null)
                TitleContainer.setTypeface(titleFont);
            if (MessageFont != null)
                MessageContainer.setTypeface(MessageFont);
            if(CardRadiusSet)
                Originalview.setRadius(cardRadius);
            if (TitleHex != null)
                TitleContainer.setTextColor(Color.parseColor(TitleHex));
            if (chosenMessageStyle != null) {
                switch (chosenMessageStyle) {
                    case NORMAL:
                        MessageContainer.setTypeface(MessageContainer.getTypeface(), Typeface.NORMAL);
                        break;
                    case ITALIC:
                        MessageContainer.setTypeface(MessageContainer.getTypeface(), Typeface.ITALIC);
                        break;
                    case BOLD:
                        MessageContainer.setTypeface(MessageContainer.getTypeface(), Typeface.BOLD);
                        break;
                    case BOLD_ITALIC:
                        MessageContainer.setTypeface(MessageContainer.getTypeface(), Typeface.BOLD_ITALIC);
                        break;

                }
            }
            if (chosenTitleStyle != null) {
                switch (chosenTitleStyle) {
                    case NORMAL:
                        TitleContainer.setTypeface(TitleContainer.getTypeface(), Typeface.NORMAL);
                        break;
                    case ITALIC:
                        TitleContainer.setTypeface(TitleContainer.getTypeface(), Typeface.ITALIC);
                        break;
                    case BOLD:
                        TitleContainer.setTypeface(TitleContainer.getTypeface(), Typeface.BOLD);
                        break;
                    case BOLD_ITALIC:
                        TitleContainer.setTypeface(TitleContainer.getTypeface(), Typeface.BOLD_ITALIC);
                        break;

                }
            }

            if (getDialog() != null)
                getDialog().setCanceledOnTouchOutside(isCanceleable);
            if (btnNegativeColor != null)
                btnNegative.setTextColor(Color.parseColor(btnNegativeColor));
            if (btnPositiveColor != null)
                btnPositive.setTextColor(Color.parseColor(btnPositiveColor));
            if (btnNegativeBgColor != null)
                btnNegative.setBackgroundColor(Color.parseColor(btnNegativeBgColor));
            if (btnPositiveBgColor != null)
                btnPositive.setBackgroundColor(Color.parseColor(btnPositiveBgColor));
        }
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

    }
    public void setAnimation(Anims query){
        switch (query){
            case ZoomIn_ZoomOut:
                reference = R.style.Animation_ZoomInZoomOut;
                break;
            case SLIDE_UP_DOWN:
                reference = R.style.Animation_SlideUpSlideDown;
                break;
            case BOUNCE_SLIDE_DOWN:
                reference = R.style.Animation_BounceSlideDown;
                break;
            case BLINK_SLIDEDOWN:
                reference = R.style.Animation_BlinkSlideDown;
                break;
            case FADE_IN_SLIDEDOWN:
                break;
            case ROTATE_SLIDEDOWN:
                reference = R.style.Animation_RotateSlideDown;
                break;
            case ZOOMIN_SLIDEDOWN:
                reference = R.style.Animation_ZoomInSlideDown;
                break;

            case BOUNCE_FADE_OUT:
                reference = R.style.Animation_BounceFadeOut;
                break;
            case BLINK_FADE_OUT:
                reference = R.style.Animation_BlinkFadeOut;
                break;
            case FADE_IN_FADE_OUT:
                reference = R.style.Animation_FadeInFadeOut;
                break;
            case ROTATE_FADE_OUT:
                reference = R.style.Animation_RotateFadeOut;
                break;
            case ZOOMIN_FADE_OUT:
                reference = R.style.Animation_ZoomInFadeOut;
                break;
            case SLIDE_UP_FADE_OUT:
                reference = R.style.Animation_SlideUpFadeOut;
                break;
            case SLIDE_UP_TRANSLATE:
                reference = R.style.Animation_SlideUpTranslate;
                 break;
            case BLINK_TRANSLATE:
                reference = R.style.Animation_BlinkTranslate;
                break;
            case BOUNCE_TRANSLATE:
                reference = R.style.Animation_BounceTranslate;
                break;
            case FADE_IN_TRANSLATE:
                reference = R.style.Animation_FadeInTranslate;
                break;
            case ROTATE_TRANSLATE:
                reference = R.style.Animation_RotateTranslate;
                break;
            case ZOOMIN_TRANSLATE:
                reference = R.style.Animation_ZoomInTranslate;
                break;
            case BLINK_FLIP:
                reference = R.style.Animation_BlinkFlip;
                break;
            case FADE_IN_FLIP:
                reference = R.style.Animation_FadeInFlip;
                break;
            case BOUNCE_FLIP:
                reference = R.style.Animation_BounceFlip;
                break;
            case ROTATE_FLIP:
                reference = R.style.Animation_RotateFlip;
                break;
            case SLIDE_UP_FLIP:
                reference = R.style.Animation_SlideUpFlip;
                break;
            case ZOOMIN_FLIP:
                reference = R.style.Animation_ZoomInFlip;
                break;
                default:

        }
    }
    public void setMessage(String Message){
        this.Message = Message;
    }
    public void setPositiveButtonClickListener(View.OnClickListener listener){
        PostiveListener = listener;
    }
    public void setNegtaiveButtonClickListener(View.OnClickListener listener){
        NegativeListener = listener;
    }
    public void setCanceleable(boolean isCanceleable){
        this.isCanceleable = isCanceleable;
    }
    public void setPostiveButtonText(String text){
        PostiveBtnText = text;
    }
    public void setNegativeBtnText(String negativeBtnText) {
        NegativeBtnText = negativeBtnText;
    }
    public void setTextMessageSize(float Size){
        textSize = Size;
    }
    public void setTextMessageColor(String Hex){
        MessageHex = Hex;
    }
    public  void setDialogImage(int ref){
        isImageReferenceSet=true;
        ImageReference = ref;
    }
    public void setDialogImageDrawable(Drawable imageDrawable){

        imageDrawable = DialogImageDrawable;
    }
    public void setTitleText(String titleText) {
        TitleText = titleText;
    }
    public void setTitleTextColor(String titleHex) {
        TitleHex = titleHex;
    }
    public void setTitleFont(Typeface titleFont) {
        this.titleFont = titleFont;
    }
    public void setTitleTextStyle(textStyle style){
                chosenTitleStyle = style;
    }
    public void setMessageTextStyle(textStyle style){
            chosenMessageStyle = style;
    }
    public void setBtnNegativeColor(String btnNegativeColor) {
        this.btnNegativeColor = btnNegativeColor;
    }
    public void setBtnPositiveColor(String btnPositiveColor) {
        this.btnPositiveColor = btnPositiveColor;
     }
    public void setBtnPositiveBgColor(String btnPositiveBgColor) {
        this.btnPositiveBgColor = btnPositiveBgColor;
    }
    public void setBtnNegativeBgColor(String btnNegativeBgColor) {
        this.btnNegativeBgColor = btnNegativeBgColor;
    }
    public void setTitleSize(float titleSize) {
        TitleSize = titleSize;
    }
    public void setView(View view) {
        mView = view;
    }
    public void setCardRadius(float cardRadius) {
        CardRadiusSet = true;
        this.cardRadius = cardRadius;
    }

    public void setMessageFont(Typeface messageFont) {
        MessageFont = messageFont;
    }
}
