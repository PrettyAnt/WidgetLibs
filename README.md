# WidgetLibs
自定义组合控件、activity右滑退出、富有弹性的ScrollView、ToolBar+viewPager切换fragemnt、MaterialDesign风格的样式等. 


# 在使用该功能前，你需要添加以下依赖
# Step 1. Add the JitPack repository to your build file
       Add it in your root build.gradle at the end of repositories:
      （在根build.gradle添加）
       allprojects {
           repositories {
			maven { url 'https://jitpack.io' }
          }
      }

# Step 2. Add the dependency
	dependencies {
	        implementation 'com.github.PrettyAnt:WidgetLibs:v1.0.1'
	}

## 组合控件的使用（如ImageView+TextView）
    在xml布局中添加如下节点即可：
    <com.example.widget.ImgTextView
      ...
     />
    当然，此demo只列举了ImageView+TextView组合的实现方案，其他组合同理(那么上述的依赖可能就满足不了你了)

## 富有弹性的ScrollView
    只需在xml文件中添加如下节点就可：
    <com.example.widget.ElasticScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    ...
    </com.example.widget.ElasticScrollView>

## 右滑关闭当前页面
    调用此方法即可：
      SlidingLayout rootView = new SlidingLayout(this);
      rootView.bindActivity(this);
    最好在BaseActivity调用此方法，通过重写来控制当前界面是否需要实现此功能

## Toolbar+viewpager实现fragment的功能
    详见demo

## Demo2演示的是MaterialDesign风格的样式,可以参考
    详见demo


### ***
（不喜勿喷，欢迎指导，谢谢 ~）
