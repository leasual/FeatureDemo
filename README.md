# FeatureDemo

#### 使用google instant app 构建应用，加快多人协作开发的速度。

#### 参考官方demo

#### [构建instant app](https://codelabs.developers.google.com/codelabs/android-instant-apps/index.html#0)

#### [构建multi-feature app](https://codelabs.developers.google.com/codelabs/android-instant-apps/index.html#0)

#### 框架设计

##### 该框架使用android architecture component(MVVM) + dagger2 + retrofit + rxjava + kotlin方式
##### 通过拆分dagger依赖，各个模块通过依赖base，完成各自模块的注入。
