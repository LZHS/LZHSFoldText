# LZHSFlodText 可折叠TextView 

[![](https://img.shields.io/badge/LZHSFlodText-lzhs_fold_text_v1.0.1-brightgreen.svg)](https://jitpack.io/#LZHS/LZHSFlodText)



### gradle
Step 1.Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
 		 ...
 		 maven { url 'https://jitpack.io' }
 	}
}
```

Step 2. Add the dependency

```
dependencies {
	    implementation 'com.github.LZHS:LZHSFoldText:lzhs_fold_text_v1.0.1'
}
```  

### 自定义折叠TextView
* 支持文字设置在结尾或者另起一行
* 支持设置点击事件
* 支持设置提示文本内容


### 效果图

![](https://github.com/LZHS/LZHSFoldText/blob/master/images/image01.jpg)


### 使用用例

```
 <com.lzhs.lzhsfoldtext.views.LZHSFlodText
            android:id="@+id/mLZHSFlodText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#fff"
            android:textColor="#000"
            app:showMaxLine="4"
            app:showTipAfterExpand="true"
            app:tipClickable="true"
            app:tipColor="@color/colorPrimary"
            app:tipGravity="nextLine" />
            
```

* showMaxLine 最大行数
* showTipAfterExpand 点击展开后是否显示收起全文提示
* tipClickable 提示是否可以点击
* tipColor 提示文字颜色
* tipGravity 提示文字位置 0-最后一行末尾，1-另起一行
* isSetParentClick 是否为父View设置了点击事件
* foldText 折叠时的提示文字
* expandText 展开时的提示文字




### 参考

[Android 可折叠TextView](https://www.jianshu.com/p/53d47c54177e)
