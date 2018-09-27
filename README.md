# Customizable-Material-Dialog-Box
A Highly Customizable Material Dialog Box

# Example
Colors,Buttons,Images,Title,Message,Corners,views can be modified as you want

![Screenshot](https://i.imgur.com/MkeZI0j.gif)

# How to add to your app 

add this to your dependencies in build.gradle file
```
implementation 'com.github.Badranh:Customizable-Material-Dialog-Box:0.1'
```
Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
# Usage

# JAVA: 
```
 final MaterialDialog dialog = new MaterialDialog();
 dialog.setMessage("This is my super cool dialog  and it can be animated with more than 20 animations!Marianne or husbands if at stronger ye. Yet diminution she impossible understood age. \n");
 dialog.setAnimation(getAnim()); //choose your own animation.getAnim() is anim that choose animations randomly
 dialog.setDialogImage(R.drawable.user);
 dialog.setPostiveButtonText("Accept");
 dialog.setNegativeBtnText("Decline");
 dialog.setTitleText("New Friend Request");
 dialog.setTitleTextColor("#ABCABC");
 dialog.setCanceleable(false);
 dialog.setTitleTextStyle(MaterialDialog.textStyle.BOLD);
 dialog.setMessageTextStyle(MaterialDialog.textStyle.ITALIC);
 dialog.setBtnPositiveColor("#ADCDDD");
 dialog.setBtnPositiveBgColor("#00000000");
 dialog.setBtnNegativeBgColor("#00000000");
 dialog.setTitleSize(20f);
 dialog.setCardRadius(20f);
 dialog.setPositiveButtonClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
       Toast.makeText(MainActivity.this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
 }
});
 dialog.setNegtaiveButtonClickListener(new View.OnClickListener() {
    @Override
      public void onClick(View view) {
         dialog.dismiss();
      }
  });

dialog.show(getSupportFragmentManager(),"Tag");
```
# Available Methods
| Methods | Description |
| --- | --- |
| setAnimation(Anims query) | Set The Animation <b>MORE THAN 20 ANIMATION </b> |
| setMessage(String Message) |Set the message of the dialog |
| setPositiveButtonClickListener(View.OnClickListener listener) | set onClickListener for postive button  |
| setNegtaiveButtonClickListener(View.OnClickListener listener) | set onClickListener for negative button  |
| setCanceleable(boolean isCanceleable)| Allow or Prevent the dialog from being closed when touched outside  |
| setPostiveButtonText(String text) | Set positive button text  |
| setNegativeBtnText(String negativeBtnText) |  Set negative button text  |
| setTextMessageSize(float Size) | Change Size of the text of the message |
| setTextMessageColor(String Hex) | Change color of the text of the message |
| setDialogImage(int ref) |  set the image of dialog from drawable folder |
| setDialogImageDrawable(Drawable imageDrawable) | set the image of dialog as a drawable programtically |
| setTitleText(String titleText) | set Title text |
| setTitleTextColor(String titleHex) | set Title text color |
| setTitleFont(Typeface titleFont)) | set Title text font |
| setTitleTextStyle(textStyle style) | <b>NORMAL</b> , <b>BOLD</b> , <b>ITALIC</b> , <b>BOLD_ITALIC</b> |
| setMessageTextStyle(textStyle style) | <b>NORMAL</b> , <b>BOLD</b> , <b>ITALIC</b> , <b>BOLD_ITALIC</b> |
| setBtnNegativeColor(String btnNegativeColor) | Will change color of the text in the button ex: "#FFFFFF" |
| setBtnPositiveColor(String btnPositiveColor) | Will change the color text of the button |
| setBtnPositiveBgColor(String btnPositiveBgColor) | | set bg color of positive button |
| setBtnNegativeBgColor(String btnNegativeBgColor) | set bg color of negative button |
| setTitleSize(float titleSize) | set title text size |
| setView(View view) | change the whole view with your own view |
| setCardRadius(float cardRadius) | set rounded corners for the dilaog |
| setMessageFont(Typeface messageFont) | Change the font of the text message |

# LICENCE:
MIT
