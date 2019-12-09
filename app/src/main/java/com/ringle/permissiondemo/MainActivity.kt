package com.ringle.permissiondemo

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ringle_ai.common.permission.annotation.Permission
import com.ringle_ai.common.permission.annotation.PermissionCanceled
import com.ringle_ai.common.permission.annotation.PermissionDenied

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    /**
     *权限请求
     *点击同意授权后回调到这里
     */
    @Permission(arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE))
    fun permissionRequest() {
        Log.e(TAG, "授权成功")
    }


    /**
     *取消授权
     */
    @PermissionCanceled
    fun permissionCancelded() {
        Log.e(TAG, "取消授权")
    }


    /**
     *取消授权,并点击了不再提示
     *此时根据业务需求引导用户打开设置页面手动授权
     *(只要有一个权限点击了不再提示都会回调到这里,这时应该
     *引导用户打开设置页面进行手动授权）
     */
    @PermissionDenied
    fun permissionDenied() {
        Log.e(TAG, "取消授权,不再提示")
    }
}
