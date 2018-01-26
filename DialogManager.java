
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v7.app.AlertDialog;

public class DialogManager {

    private Context mContext;
    private String mTitle;
    private String mMessage;
    private String mPositiveButtonText;
    private String mNegativeButtonText;
    private Drawable mIcon;
    private boolean mShowPositiveButton;
    private boolean mShowNegativeButton;

    private DialogManager(Builder builder) {
        mContext = builder.mContext;
        mTitle = builder.mTitle;
        mMessage = builder.mMessage;
        mIcon = builder.mIcon;
        mShowNegativeButton = builder.mShowNegativeButton;
        mShowPositiveButton = builder.mShowPositiveButton;
        mPositiveButtonText = builder.mPositiveButtonText;
        mNegativeButtonText = builder.mNegativeButtonText;
        if (builder.mIInfoListener != null) {
            builder.mIConfirmListener = null;
            mShowNegativeButton = false;
        }
        showAlert(builder);
    }

    private void showAlert(final Builder builder) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext).setTitle(mTitle);
        alertDialogBuilder.setTitle(mTitle).setMessage(mMessage);

        if (mShowPositiveButton) {
            alertDialogBuilder.setPositiveButton(mPositiveButtonText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    if (builder.mIInfoListener != null) {
                        builder.mIInfoListener.onConfirm();
                    }

                    if (builder.mIConfirmListener != null) {
                        builder.mIConfirmListener.onConfirm();
                    }
                }
            });
        }

        if (mShowNegativeButton) {
            alertDialogBuilder.setNegativeButton(mNegativeButtonText, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    if (builder.mIConfirmListener != null) {
                        builder.mIConfirmListener.onDismiss();
                    }
                }
            });
        }

        if (mIcon != null) alertDialogBuilder.setIcon(mIcon);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        if (builder.mPositiveButtonColor != null)
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(builder.mPositiveButtonColor);

        if (builder.mNegativeButtonColor != null)
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(builder.mNegativeButtonColor);
    }

    public static class Builder {
        private Context mContext;
        private String mTitle;
        private String mMessage;
        private Drawable mIcon;
        private boolean mShowPositiveButton = true;
        private boolean mShowNegativeButton;
        private String mPositiveButtonText = "Yes";
        private String mNegativeButtonText = "No";
        private Integer mPositiveButtonColor;
        private Integer mNegativeButtonColor;
        private IInfoListener mIInfoListener;
        private IConfirmListener mIConfirmListener;

        public Builder setContext(Context context) {
            mContext = context;
            return this;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setMessage(String message) {
            mMessage = message;
            return this;
        }

        public Builder setIcon(Drawable icon) {
            mIcon = icon;
            return this;
        }

        public Builder setPositiveButton(boolean showPositiveButton) {
            mShowPositiveButton = showPositiveButton;
            return this;
        }

        public Builder setPositiveButtonText(String buttonText) {
            mPositiveButtonText = buttonText;
            return this;
        }

        public Builder setPositiveButtonColor(@ColorRes Integer positiveButtonColor) {
            mPositiveButtonColor = mContext.getResources().getColor(positiveButtonColor);
            return this;
        }

        public Builder setNegativeButton(boolean showNegaiveButton) {
            mShowNegativeButton = showNegaiveButton;
            return this;
        }

        public Builder setNegativeButtonText(String buttonText) {
            mNegativeButtonText = buttonText;
            return this;
        }

        public Builder setNegativeButtonColor(@ColorRes Integer negativeButtonColor) {
            mNegativeButtonColor = mContext.getResources().getColor(negativeButtonColor);
            return this;
        }

        public Builder setInfoListener(IInfoListener infoListener) {
            mIInfoListener = infoListener;
            return this;
        }

        public Builder setConfirmListener(IConfirmListener confirmListener) {
            mIConfirmListener = confirmListener;
            return this;
        }

        public DialogManager build() {
            return new DialogManager(this);
        }

    }

    public interface IInfoListener {
        void onConfirm();
    }

    public interface IConfirmListener {
        void onConfirm();
        void onDismiss();
    }
}
