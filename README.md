# WidgetLibs
##### Tips:自定义组合控件、activity右滑退出、富有弹性的ScrollView、ToolBar+viewPager切换fragemnt、MaterialDesign风格的样式等. 
#######  笔者的第一个开源库，不喜勿喷，欢迎指导
## ---------------------------------------------------------------


# I.怎使用此开源库
## 在使用该功能前，你需要添加以下依赖
### Step 1. Add the JitPack repository to your build file
       Add it in your root build.gradle at the end of repositories:
      （在根build.gradle添加）
       allprojects {
           repositories {
			maven { url 'https://jitpack.io' }
          }
      }

### Step 2. Add the dependency
	dependencies {
	        implementation 'com.github.PrettyAnt:WidgetLibs:v1.0.2'
	}
	
### ***************************************************************************************

# II.类库功能

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
    
## TextView阴影效果「提供了两种实现方式，另一种详见本类库中ImageTextView部分源码--->>[传送门](https://github.com/PrettyAnt/WidgetLibs/blob/master/prettyant_widget_libs/src/main/java/com/example/widget/ImgTextView.java)」
    只需在xml文件中添加如下节点就可：
        <com.example.widget.StrokeTextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content">
        ...
        </com.example.widget.ElasticScrollView>
	
	

### ******************************************************************************************

# III.Demo其他的一些效果

## TabLayout+Toolbar+ViewPager实现各种导航栏效果
    详见demo

## MaterialDesign风格的样式
    详见demo


### ***
（不喜勿喷，欢迎指导，谢谢 ~）
