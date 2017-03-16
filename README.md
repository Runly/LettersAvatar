# LettersAvatar

`LettersAvatar` is a bitmap tool, you can use it to create a bitmap with characters.


### Image
<img src="https://github.com/Runly/LettersAvatar/blob/master/image/image.png" width = "593" height = "379" align=center />


### Download

- Add this in your **root** `build.gradle` :

```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

- Add this in your **app** `build.gradle` :

```groovy
dependencies {
    compile 'com.github.Runly:LettersAvatar:v1.0.2'
}
```

### Usage

```java
    ImageView imageView = (ImageView) findViewById(R.id.image);
    
    LetterAvatar.with(mContext)
        .firstLetter("A", true)
        .letterColor(Color.WHITE)
        .backgroundColorResId(R.color.bg_color_one)
        .letterSize(150)
        .canvasSize(300, 300)
        .into(imageView);
```

#### or


```java
    ImageView imageView = (ImageView) findViewById(R.id.image);
    
    Bitmap bitmap = LetterAvatar.with(mContext)
                        .firstLetter("A", true)
                        .letterColor(Color.WHITE)
                        .backgroundColorResId(R.color.bg_color_one)
                        .letterSize(150)
                        .canvasSize(300, 300)
                        .create();
                        
    imageView.setImageBitmap(bitmap);     
   
```

### Recommend

If you want to use `CircleImageView` , I recommend : 

* <a href="https://github.com/hdodenhof/CircleImageView">CircleImageView</a>


### Methods
|method name|ddescription
|---|---|
|firstLetter(String text, boolean capitalized)|only draw first character, and set the letters to uppercase
|chineseFirstLetter(String text, boolean capitalized)|draw chinese word's first letter
|letters(String text)|draw all characters
|letterSize(int size)|set letter size with px
|letterSizeDIP(int size)|set letter size with dip
|canvasSize(int width, int height)|set canvas width and height with px
|canvasSizeDIP(int width, int height)|set canvas width and height with dip
|letterColor(int color)|set letter color
|letterColorResId(int resId)|set letter color with resId
|backgroundColor(int color)|set background color
|backgroundColorResId(int resId)|set background color with resId
|create()|return the bitmap
|into(ImageView imageView)|set the bitmap into a imageView


### Thanks

* <a href="https://github.com/stuxuhai/jpinyin">jpinyin</a>
 
* <a href="https://github.com/hdodenhof/CircleImageView">CircleImageView</a>

