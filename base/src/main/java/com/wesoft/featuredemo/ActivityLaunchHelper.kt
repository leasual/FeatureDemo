package com.wesoft.featuredemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri

class ActivityLaunchHelper {

    companion object {
        private const val URL_BASE = "https://feature.wesoft.com"
        private const val URL_SPACE = "$URL_BASE/space"
        private const val URL_SCENE = "$URL_BASE/scene"

        /******** profile *********/
        private const val URL_PROFILE = "$URL_BASE/profile"
        private const val URL_PROFILE_EDIT = "$URL_BASE/profile/edit"


        fun launchScene(activity: Activity, name: String) {
            try {
                val intent = baseIntent(URL_SCENE, activity)
                intent.putExtra("name", name)
                activity.startActivity(intent)
            } catch (e: Exception) {
            }
        }

        fun launchProfile(activity: Activity, name: String) {
            try {
                val intent = baseIntent(URL_PROFILE, activity)
                intent.putExtra("name", name)
                activity.startActivity(intent)
            } catch (e: Exception) {
            }
        }

        fun launchEditProfile(activity: Activity, name: String) {
            try {
                val intent = baseIntent(URL_PROFILE_EDIT, activity)
                intent.putExtra("name", name)
                activity.startActivity(intent)
            } catch (e: Exception) {
            }
        }

        private fun baseIntent(url: String, context: Context? = null): Intent {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    .addCategory(Intent.CATEGORY_DEFAULT)
                    .addCategory(Intent.CATEGORY_BROWSABLE)
            //if set context null will show user switch browser or app to open, else it use app to open by default
            if (context != null) {
                intent.`package` = context.packageName
            }
            return intent
        }
    }
}