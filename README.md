## react-native-channel-info

[![npm version](https://badge.fury.io/js/react-native-channel-info@2x.png)](http://badge.fury.io/js/react-native-channel-info)

Channel Information for react-native
使用美团方案统计Android分发渠道

## Installation

First you need to install react-native-channel-info:

```javascript
npm install react-native-channel-info --save
```

### Installation (iOS)

Not Support Now, Always return IAPPSTORE

### Installation (Android)

* In `android/setting.gradle`

```gradle
...
include ':react-native-channel-info', ':app'
project(':react-native-channel-info').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-channel-info/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-channel-info')
}
```

* register module (in MainActivity.java)

On newer versions of React Native (0.18+):

```java
import cn.tuofeng.RNChannelInfo.RNChannelInfo;  // <--- import

public class MainActivity extends ReactActivity {
  ......

  /**
   * A list of packages used by the app. If the app uses additional views
   * or modules besides the default ones, add more packages here.
   */
    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
        new RNChannelInfo(), // <------ add here
        new MainReactPackage());
    }
}
```