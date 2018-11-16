package com.wesoft.featuredemo.profile.di

import com.wesoft.featuredemo.di.scope.PerActivity
import com.wesoft.featuredemo.profile.EditProfileActivity
import com.wesoft.featuredemo.profile.ProfileActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun profileActivity(): ProfileActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun editProfileActivity(): EditProfileActivity
}